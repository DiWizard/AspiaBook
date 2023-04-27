package info.malenkov.aspiabook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
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
import info.malenkov.aspiabook.proto.Identify;
import info.malenkov.aspiabook.proto.ServerHello;
import info.malenkov.aspiabook.proto.SessionChallenge;
import info.malenkov.aspiabook.proto.SrpClientKeyExchange;
import info.malenkov.aspiabook.proto.SrpIdentify;
import info.malenkov.aspiabook.proto.SrpServerKeyExchange;
import info.malenkov.aspiabook.proto.ClientHello;
import info.malenkov.aspiabook.proto.Computer;
import info.malenkov.aspiabook.proto.ComputerGroup;
import info.malenkov.aspiabook.proto.Data;
import info.malenkov.aspiabook.proto.Encryption;

public class AspiaBook {
    private final static int abMajorVersion = 1;
	private final static int abMinorVesion = 1;

    private final int THREADS_POOL_SIZE = 20;
    private final int TIMEOUT = 500;
	private final String SPLIT = "<-//->";
    private boolean aabEncrypted = false;
    private String aabPath = null;
    private String aabPathWrite = null;
    private String aabPassword = null;
    private byte[] aabData = null;
    private String jsonPath = null;
    private String ipNet = null;
    private int aspiaPort = 8050;
    private boolean saveIp = false;
	private int ipTimeout = TIMEOUT;
	private String hostUser = "";
	private String hostPassword = "";
	private boolean saveCred = false;

    private static String abName = "AspiaBook";
	private static String abCopyright = "(c) Copyright 2023 Maxim V. Malenkov\n\nThird-party component:\n- guava (c) 2009 Google Inc.; Apache-2.0 license\n- protobuf (c) 2008 Google Inc.; BSD 3-Clause License\n- bouncycastle (c) 2000 - 2021 The Legion of the Bouncy Castle Inc; MIT license";
   
	class HostInfo{
		String hostIp;
		String hostName;

		public HostInfo(String ip, String name){
			hostIp = ip;
			hostName = name;
		}

		public String getIp(){
			return hostIp;
		}

		public String getName(){
			return hostName;
		}
	}

	private List<HostInfo> foundHosts = new ArrayList<>();

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

	public void setHostUser(String user){
		hostUser = user;
	}

	public void setHostPassword(String password){
		hostPassword = password;
	}

    public void setPathWrite(String aabPathWrite){
        this.aabPathWrite = aabPathWrite;
    }

    public void setPassword(String aabPassword){
        this.aabPassword = aabPassword;
        if(aabPassword != null && aabPassword != ""){
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

	public void setTimeout(int timeout){
		if(timeout < 200) 
			ipTimeout = 200;
		else if(timeout > 5000)
			ipTimeout = 5000;
		else
			ipTimeout = timeout;
	}

	public void saveCredential(boolean cred){
		saveCred = cred;
	}

	public void netScan() throws InterruptedException, ExecutionException, UnknownHostException{
		Date date = new Date();  

        if(ipNet != null) {
            final SubnetUtils utils = new SubnetUtils(ipNet);
            final String[] allIps = utils.getInfo().getAllAddresses();
            final ExecutorService es = Executors.newFixedThreadPool(THREADS_POOL_SIZE);
            final List<Future<Boolean>> futures = new ArrayList<>();
        
            for (String ip : allIps) {
              futures.add(portIsOpen(es, ip, aspiaPort, ipTimeout));
            }
            
            es.shutdown();
            int openPorts = 0;
            for (final Future<Boolean> f : futures) {
                if (f.get()) {
                  openPorts++;
                }
            }
        
            System.out.println("\nThere are " + openPorts + " open ports on network " + ipNet + " (probed with a timeout of " + ipTimeout + "ms)");
        
            if(openPorts > 0){
                ComputerGroup computerGroup = ComputerGroup
                    .newBuilder()
                    .build();

				for(int inc = 0; inc < foundHosts.size(); inc++) {
					String tmpName = "";
					String tmpComment = "";
					String tmpUser = "";
					String tmpPassword = "";

					if(saveCred){
						tmpUser = hostUser;
						tmpPassword = hostPassword;
					}

					if(foundHosts.get(inc).getName().indexOf(SPLIT) > 0) {
						String temp[] = foundHosts.get(inc).getName().split(SPLIT);
						tmpName = temp[0];
						tmpComment = temp[1];
					}else{
						tmpName = foundHosts.get(inc).getIp();
						tmpComment = foundHosts.get(inc).getName();
					}

                    Computer computer = Computer.newBuilder()
						.setUsername(tmpUser)
						.setPassword(tmpPassword)
                        .setName(tmpName)
						.setComment(tmpComment)
                        .setAddress(foundHosts.get(inc).getIp())
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
            }else{
				aabData = null;	
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

        if(aabPathWrite != null && aabData != null) {
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
				String tmpIp = null;
				String tmpHost = null;

				Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), timeout);
                socket.close();

                if(saveIp){
                    tmpIp = ip;
					tmpHost = getHostInfo(ip, hostUser, hostPassword);
                }else{
                    tmpIp = getHostName(ip);
					tmpHost = getHostInfo(ip, hostUser, hostPassword);
                }

				foundHosts.add(new HostInfo(tmpIp, tmpHost));

                System.out.print("+");
                return true;
              } catch (Exception ex) {
                System.out.print(".");
                return false;
              }
            }
        });
    }

	private String getHostName(String ip){
		String result = ip;

		InetAddress addr;
		try {
			addr = InetAddress.getByName(ip);
			result = addr.getHostName();
		} catch (UnknownHostException e) {
			// Do nothing
			System.out.println("\n<!>getHostName(" + ip + ") error: " + e);
		}

		return result;
	}

	private String getHostInfo(String hostIp, String hostUser, String hostPassword){
		String result = "<!> Wrong user name or password";
		Encryption serverEncryption = Encryption.ENCRYPTION_UNKNOWN;
		SPREngine sprEngine = null;
		boolean alwaysFine = true;
		byte[] data = null;

		try{
			Socket socket = new Socket(hostIp, aspiaPort);
			socket.setSoTimeout(ipTimeout);
			BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());

			// ---->>> ClientHello
			ClientHello clientHello = ClientHello.newBuilder()
					.setEncryption(Encryption.ENCRYPTION_CHACHA20_POLY1305_VALUE | Encryption.ENCRYPTION_AES256_GCM_VALUE)
					.setIdentify(Identify.IDENTIFY_SRP)
					.build();
			byte[] clientHelloDATA = addSize(clientHello.toByteArray());
			out.write(clientHelloDATA);
			out.flush();

			// <<<---- ServerHello
			if(alwaysFine){
				data = read(in);
				if (data.length > 0) {
					data = skipSize(data);
					if (var128Decode(data) > 0) {
						ServerHello serverHello = ServerHello.parseFrom(data);
						serverEncryption = serverHello.getEncryption();
					}else{
						System.out.print("<!> ServerHello protobuf error.");
						alwaysFine = false;
					}
				}else{
					System.out.print("<!> ServerHello error.");
					alwaysFine = false;
				}
			}

			// ---->>> SrpIdentify
			if(alwaysFine){
				SrpIdentify srpIdentify = SrpIdentify.newBuilder().setUsername(hostUser).build();
				byte[] srpIdentifyDATA = addSize(srpIdentify.toByteArray());
				out.write(srpIdentifyDATA);
				out.flush();
			}
			
			// <<<---- SrpServerKeyExchange
			if(alwaysFine){
				data = read(in);
				if (data.length > 0) {
					if (var128Decode(data) > 0) {
						data = skipSize(data);
						SrpServerKeyExchange srpServerKeyExchange = SrpServerKeyExchange.parseFrom(data);
						sprEngine = new SPREngine(hostUser , hostPassword, 
							serverEncryption,
							srpServerKeyExchange.getNumber().toByteArray(), 
							srpServerKeyExchange.getGenerator().toByteArray(), 
							srpServerKeyExchange.getSalt().toByteArray(), 
							srpServerKeyExchange.getB().toByteArray(), 
							srpServerKeyExchange.getIv().toByteArray());
					}else{
						System.out.print("<!> SprServerKeyExchange protobuf error.");
						alwaysFine = false;
					}
				}else{
					System.out.print("<!> SprServerKeyExchange error.");
					alwaysFine = false;
				}
			}

			// ---->>> SrpClientKeyExchange
			if(alwaysFine && sprEngine != null){
				SrpClientKeyExchange srpClientKeyExchange = SrpClientKeyExchange.newBuilder()
					.setA(ByteString.copyFrom(sprEngine.getA()))
					.setIv(ByteString.copyFrom(sprEngine.getIV()))
					.build();

				byte[] srpClientKeyExchangeDATA = addSize(srpClientKeyExchange.toByteArray());
				out.write(srpClientKeyExchangeDATA);
				out.flush();
			}
			// <<<----- SessionChallenge
			if(alwaysFine && sprEngine != null){
				data = read(in);
				if (data.length > 0) {
					if (var128Decode(data) > 0) {
						data = skipSize(data);
						SessionChallenge sessionChallenge = SessionChallenge.parseFrom(sprEngine.decrypt(data));
						result = sessionChallenge.getComputerName() + SPLIT + sessionChallenge.getOsName(); 
					}else{
						//result = "<!> SessionChallenge protobuf error.";
						result = result + "\nSessionChallenge protobuf error."; 
						alwaysFine = false;
					}
				}else{
					// result = "<!> SessionChallenge error.";
					result = result + "\nSessionChallenge error."; 
					alwaysFine = false;
				}
			}
			socket.close();
		} catch (Exception e) {
			result = result + "\n" + e; 
		}

		return result;
	}

	private byte[] addSize(byte[] value) {
		byte[] newBuffer = null;

		if (value.length > 0) {
			int var128Size = (int) var128Size(value.length);
			newBuffer = new byte[value.length + var128Size];
			System.arraycopy(var128Encode(value.length), 0, newBuffer, 0, var128Size);
			System.arraycopy(value, 0, newBuffer, var128Size, value.length);
		}

		return newBuffer;
	}

	private byte[] skipSize(byte[] value) {
		byte[] newBuffer = null;

		if (value.length > 0) {
			int msgLen = (int) var128Decode(value);
			newBuffer = new byte[msgLen];
			System.arraycopy(value, var128Size(msgLen), newBuffer, 0, msgLen);
		}

		return newBuffer;
	}

	private int var128Size(long x) {
		int size = 1;
		while (Long.compareUnsigned(x, 127) > 0) {
			size++;
			x >>>= 7;
		}
		return size;
	}

	private byte[] var128Encode(long x) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[var128Size(x)]);

		while (Long.compareUnsigned(x, 127) > 0) {
			bb.put((byte) (x & 127 | 128));
			x >>>= 7;
		}
		bb.put((byte) (x & 127));

		return bb.array();
	}

	private long var128Decode(byte[] buffer) {
		ByteBuffer bb = ByteBuffer.wrap(buffer);

		long x = 0;
		int shift = 0;
		long b;
		do {
			b = bb.get() & 0xff;
			x |= (b & 127) << shift;
			shift += 7;
		} while ((b & 128) != 0);
		return x;
	}

	private byte[] read(BufferedInputStream in) throws IOException, InterruptedException{
		int termLength = 0;
		byte[] buffer = new byte[0];
		byte[] term = new byte[16384];

		do{		
			termLength = in.read(term, 0, 16384);
			buffer = concatenate(buffer, term, termLength);
			Thread.sleep(100);
		}while(in.available() > 0);

		return buffer;
	}

	private byte[] concatenate(byte[] first, byte[] second, int length){
		byte[] combined = new byte[first.length + length];
		
		if(first.length > 0){
			System.arraycopy(first,0,combined,0,first.length);
		}
		if(second.length > 0){
			System.arraycopy(second,0,combined,first.length,length);
		}
		
		return combined;
	}
}
