package info.malenkov.aspiabook;

import java.math.BigInteger;
import java.util.Random;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import org.bouncycastle.util.Arrays;

import info.malenkov.aspiabook.proto.Encryption;

public class SPREngine {
	private final int kIVSize = 12; // 96 bits, 12 bytes.
	private final int kTagSize = 16; // 128 bits, 16 bytes.
		
	private BigInteger N = null;
	private BigInteger g = null;
	private BigInteger A = null;
	private BigInteger a = null;
	private BigInteger B = null;
	private BigInteger s = null;
	private BigInteger u = null; 
	private BigInteger x = null;
	private BigInteger client_key = null;
	private BigInteger session_key = null;
	private BigInteger decrypt_iv = null;
	private byte[] iv = null;
	private Cipher cipher;
	private Encryption encryptionAlgo = Encryption.ENCRYPTION_UNKNOWN;

	SPREngine(String user, String password, Encryption algorithm, byte[] number, byte[] generator, byte[] salt, byte[] srvB, byte[] srvIV) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		iv = new byte[kIVSize]; new Random().nextBytes(iv);
		encryptionAlgo = algorithm;

		N = new BigInteger(1, number);
		g = new BigInteger(1, generator);
		s = new BigInteger(1, salt);
		B = new BigInteger(1, srvB);
		decrypt_iv = new BigInteger(1, srvIV);

		a = new BigInteger(128*8, new SecureRandom());
		A = SPRMatch.calc_A(a, N, g);
		u = SPRMatch.calc_u(A, B, N);
		x = SPRMatch.calc_x(s, user, password); 
		client_key = SPRMatch.calcClientKey(N, B, g, x, a, u); // S
		session_key = SPRMatch.hash_BLAKE2s256(client_key); // K
	}

	public byte[] getKey() {
		return SPRMatch.BI2BA(client_key);
	}

	public byte[] getIV() {
		return iv;
	}

	public byte[] getA() {
		return SPRMatch.BI2BA(A);
	}

	public byte[] geta(){
		return SPRMatch.BI2BA(a);
	}

	public byte[] getSessionKey(){
		return SPRMatch.BI2BA(session_key);
	}

	public byte[] encrypt(byte[] data) throws Exception {
		SecretKeySpec keySpec = null;
		
		switch (encryptionAlgo) {
			case ENCRYPTION_AES256_GCM:
				cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
				keySpec = new SecretKeySpec(SPRMatch.BI2BA(session_key), "AES");
				GCMParameterSpec gcmSpec = new GCMParameterSpec(kTagSize*Byte.SIZE, iv);
				cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec);
				break;
			case ENCRYPTION_CHACHA20_POLY1305:
				cipher = Cipher.getInstance("ChaCha20-Poly1305", "BC"); 
				keySpec = new SecretKeySpec(SPRMatch.BI2BA(session_key), "ChaCha20-Poly1305");
				IvParameterSpec ivSpec = new IvParameterSpec(iv);
				cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
				break;
			default:
				throw new Exception("SPREngine.encrypt(): Unknown encryption algorithm...");
		}

		byte[] encrypted = cipher.doFinal(data);
		byte[] tag = Arrays.copyOfRange(encrypted, encrypted.length - kTagSize, encrypted.length);
		byte[] body = Arrays.copyOfRange(encrypted, 0, encrypted.length - kTagSize);

		iv = SPRMatch.BI2BA(SPRMatch.increment(new BigInteger(1, iv)));
		return Arrays.concatenate(tag, body);
	}

	public byte[] decrypt(byte[] data) throws Exception {
		SecretKeySpec keySpec = null;

		byte[] tag = Arrays.copyOfRange(data, 0, kTagSize);
		byte[] body = Arrays.copyOfRange(data, kTagSize, data.length);

		switch (encryptionAlgo) {
			case ENCRYPTION_AES256_GCM:
				cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
				keySpec = new SecretKeySpec(SPRMatch.BI2BA(session_key), "AES");
				GCMParameterSpec gcmSpec = new GCMParameterSpec(kTagSize*Byte.SIZE, SPRMatch.BI2BA(decrypt_iv));
				cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);
				break;
			case ENCRYPTION_CHACHA20_POLY1305:
				cipher = Cipher.getInstance("ChaCha20-Poly1305", "BC"); 
				keySpec = new SecretKeySpec(SPRMatch.BI2BA(session_key), "ChaCha20-Poly1305");
				IvParameterSpec ivSpec = new IvParameterSpec(SPRMatch.BI2BA(decrypt_iv));
				cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
				break;
			default:
				throw new Exception("SPREngine.decryp(): Unknown encryption algorithm...");
		}

		decrypt_iv = SPRMatch.increment(decrypt_iv);		
		return cipher.doFinal(Arrays.concatenate(body, tag));
	}
}