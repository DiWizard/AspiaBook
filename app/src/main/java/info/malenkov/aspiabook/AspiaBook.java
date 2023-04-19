package info.malenkov.aspiabook;

import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.SubnetUtils;
import org.bouncycastle.crypto.generators.SCrypt;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import info.malenkov.aspiabook.proto.EncryptionType;
import info.malenkov.aspiabook.proto.File;
import info.malenkov.aspiabook.proto.Computer;
import info.malenkov.aspiabook.proto.ComputerGroup;
import info.malenkov.aspiabook.proto.Data;

public class AspiaBook {

    private final static int abMajorVersion = 1;
	private final static int abMinorVesion = 0;

    private final int THREADS_POOL_SIZE = 20;
    private final int TIMEOUT = 200;
    private List<String> aspiaIps = new ArrayList<>();

    private boolean aabEncrypted = false;
    private String aabPath = null;
    private String aabPathWrite = null;
    private String aabPassword = null;
    private byte[] aabData = null;
    private String jsonPath = null;
    private String ipNet = null;
    private int aspiaPort = 8050;
    private boolean saveIp = false;

    private static String abName = "AspiaBook";
	private static String abCopyright = "(c) Copyright 2023 Maxim V. Malenkov\n\nThird-party component:\n- guava (c) 2009 Google Inc.; Apache-2.0 license\n- protobuf (c) 2008 Google Inc.; BSD 3-Clause License\n- bouncycastle (c) 2000 - 2021 The Legion of the Bouncy Castle Inc; MIT license";
   

    AspiaBook(){
        Security.addProvider(new BouncyCastleProvider());
    }

    public void printVersion(){
		System.out.println(abName + " v." + abMajorVersion + "." + abMinorVesion);
		System.out.println(abCopyright);
		System.out.println("");
		if(System.getProperty("java.vendor").length() > 0 && System.getProperty("java.version").length() > 0){
			System.out.println("JavaVM version: " + System.getProperty("java.vendor") + " " + System.getProperty("java.version"));
			if(System.getProperty("os.name").length() > 0 && System.getProperty("os.arch").length() > 0){
				System.out.println("Running on " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ")");
			}
		}
        System.out.println("");
	}

    public void saveIpOnly(boolean saveIp){
        this.saveIp = saveIp;
    }

    public void setPath(String aabPath){
        this.aabPath = aabPath;
    }

    public void setPathWrite(String aabPathWrite){
        this.aabPathWrite = aabPathWrite;
    }

    public void setPassword(String aabPassword){
        this.aabPassword = aabPassword;
        if(aabPassword != null){
            aabEncrypted = true;
        }
    }

    public void setPathJSON(String jsonPath){
        this.jsonPath = jsonPath;
    }

    public void setNet(String ipNet) {
		if(ipNet.indexOf(":") > 0){
			String buffer[] = ipNet.split(":");
			this.ipNet = buffer[0]; 
			aspiaPort = Integer.valueOf(buffer[1]); 
		}else{
			this.ipNet = ipNet;
		}
    }

	public void netScan() throws InterruptedException, ExecutionException, UnknownHostException{
		Date date = new Date();  

        if(ipNet != null) {
            final SubnetUtils utils = new SubnetUtils(ipNet);
            final String[] allIps = utils.getInfo().getAllAddresses();
            final ExecutorService es = Executors.newFixedThreadPool(THREADS_POOL_SIZE);
            final List<Future<Boolean>> futures = new ArrayList<>();
        
            for (String ip : allIps) {
              futures.add(portIsOpen(es, ip, aspiaPort, TIMEOUT));
            }
            
            es.shutdown();
            int openPorts = 0;
            for (final Future<Boolean> f : futures) {
                if (f.get()) {
                  openPorts++;
                }
            }
        
            System.out.println("\nThere are " + openPorts + " open ports on network " + ipNet + " (probed with a timeout of " + TIMEOUT + "ms)");
        
            if(openPorts > 0){
                ComputerGroup computerGroup = ComputerGroup
                    .newBuilder()
                    .build();
                for (String ip : aspiaIps) {
                    Computer computer = Computer.newBuilder()
                        .setName(ip)
                        .setAddress(ip)
                        .setPort(aspiaPort)
                        .setCreateTime(date.getTime()/1000)
                        .setModifyTime(date.getTime()/1000)
                        .build();
                        computerGroup = computerGroup.newBuilder(computerGroup).addComputer(computer).build();
                }
                aabData = Data.newBuilder()
                    .mergeRootGroup(computerGroup)
                    .build()
                    .toByteArray();
            }
        }
	}

    public boolean load(){
        boolean result = false;

        if(aabPath != null){
            try {
                byte[] aabBuffer = Files.readAllBytes(FileSystems.getDefault().getPath(aabPath));
                File aspiaAddressBookFile = File.parseFrom(aabBuffer);
                switch(aspiaAddressBookFile.getEncryptionType()){
                    case ENCRYPTION_TYPE_CHACHA20_POLY1305:
                        aabData = decrypt(aspiaAddressBookFile.getData().toByteArray(), aspiaAddressBookFile.getHashingSalt().toByteArray(), aabPassword.getBytes());
                        result = true;
                        break;
                
                    case ENCRYPTION_TYPE_NONE:
                        aabData = aspiaAddressBookFile.getData().toByteArray();
                        result = true;
                        break;
                
                    default:
                        System.out.println("<!> ERROR: The address book file is encrypted with an unsupported encryption type.");
                        break;
                }					
            } catch (Exception e) {
                System.out.println("<!> AspiaBook.load() error:\n" + e);
            }
        }

        return result;
    }

    public boolean save(){
        boolean result = false;

        if(aabPathWrite != null) {
            try {
                if(aabEncrypted){
                    byte[] newSalt = newSalt();
                    byte[] aabEncryptedData = encrypt(aabData, newSalt, aabPassword.getBytes()); 
                    File aabOut  = File.newBuilder().
                        setData(ByteString.copyFrom(aabEncryptedData)).
                        setHashingSalt(ByteString.copyFrom(newSalt)).
                        setEncryptionTypeValue(EncryptionType.ENCRYPTION_TYPE_CHACHA20_POLY1305_VALUE).build();
                    aabOut.writeTo(new FileOutputStream(aabPathWrite, false));
                    result = true;
                }else{
                    File aabOut  = File.newBuilder().
                        setData(ByteString.copyFrom(aabData)).
                        setEncryptionTypeValue(EncryptionType.ENCRYPTION_TYPE_NONE_VALUE).build();
                        aabOut.writeTo(new FileOutputStream(aabPathWrite, false));
                        result = true;
                }
            } catch (Exception e) {
                System.out.println("<!> AspiaBook.save() error:\n" + e);
            }
        }

        return result;
    }

    public boolean export(){
        boolean result = false;

        if(aabPath == null){
            System.out.println("<!> AspiaBook.export() error: Undefinded path to Aspia address book file...");
        }else{
            if(jsonPath == null){
                System.out.println("<!> AspiaBook.export() error: Undefinded path to JSON file...");
            }else{
                try{
                    Data data = Data.parseFrom(aabData);
                    if(data.isInitialized()){
                        byte[] strToBytes = toJSON(data.getAllFields()).getBytes();
                        FileOutputStream outputStream = new FileOutputStream(jsonPath);
                        outputStream.write(strToBytes);
                        outputStream.close();
                    }
                }catch(Exception e){
                    System.out.println("<!> AspiaBook.export() error:\n" + e);
                }
            }
        }

        return result;
    }

    private byte[] decrypt(byte[] data, byte[] salt, byte[] password) throws Exception {
        final int kIVSize = 12; // 96 bits, 12 bytes.
        final int kTagSize = 16; // 128 bits, 16 bytes.

        byte[] iv = Arrays.copyOfRange(data, 0, kIVSize);
        byte[] tag = Arrays.copyOfRange(data, kIVSize, kIVSize + kTagSize);
		byte[] body = Arrays.copyOfRange(data, kIVSize + kTagSize, data.length);

        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", "BC"); 
        SecretKeySpec keySpec = new SecretKeySpec(hash(password, salt), "ChaCha20-Poly1305");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        return cipher.doFinal(Arrays.concatenate(body, tag));
    }

    public byte[] encrypt(byte[] data, byte[] salt, byte[] password) throws Exception {
        final int kTagSize = 16; // 128 bits, 16 bytes.
        byte[] iv = newIV();

        Cipher cipher = Cipher.getInstance("ChaCha20-Poly1305", "BC"); 
        SecretKeySpec keySpec = new SecretKeySpec(hash(password, salt), "ChaCha20-Poly1305");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		byte[] encrypted = cipher.doFinal(data);
		byte[] tag = Arrays.copyOfRange(encrypted, encrypted.length - kTagSize, encrypted.length);
		byte[] body = Arrays.copyOfRange(encrypted, 0, encrypted.length - kTagSize);

		return Arrays.concatenate(iv, Arrays.concatenate(tag, body));
	}

    private byte[] hash(byte[] password, byte[] salt){
        final int N = 16384; // CPU/Memory cost parameter, must be larger than 1, a power of 2, and less than 2^(128 * r / 8).
        final int r = 8; // Block size parameter.
        final int p = 2; // Parallelization parameter, a positive integer less than or equal to ((2^32-1) * hLen) / MFLen where hLen is 32 and MFlen is 128 * r.
        final int kBitsPerByte = 8;
        final int kBitsSize = 256;
        final int kBytesSize = kBitsSize / kBitsPerByte;

        return SCrypt.generate(password, salt, N, r, p, kBytesSize);
    }

    private byte[] newSalt(){
        byte[] buffer = new byte[256];
        new SecureRandom().nextBytes(buffer);
        return buffer;
    }

    private byte[] newIV(){
        byte[] buffer = new byte[12];
        new SecureRandom().nextBytes(buffer);
        return buffer;
    }

    private String toJSON(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    private Future<Boolean> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
        return es.submit(new Callable<Boolean>() {
            @Override public Boolean call() {
              try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), timeout);
                socket.close();
                if(saveIp){
                    aspiaIps.add(ip);
                }else{
                    InetAddress addr = InetAddress.getByName(ip);
                    aspiaIps.add(addr.getHostName());
                }
                System.out.print("+");
                return true;
              } catch (Exception ex) {
                System.out.print(".");
                return false;
              }
            }
        });
    }
  
}
