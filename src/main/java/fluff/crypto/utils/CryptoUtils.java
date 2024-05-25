package fluff.crypto.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {
	
	public static MessageDigest getMessageDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {}
		return null;
	}
	
	public static byte[] bytesToHex(byte[] bytes) {
        byte[] out = new byte[bytes.length * 2];
        
        for (int i = 0, j = 0; i < bytes.length; i++) {
            out[j++] = intToChar((0xF0 & bytes[i]) >>> 4);
            out[j++] = intToChar(0x0F & bytes[i]);
        }
        
        return out;
	}
	
	public static byte[] hexToBytes(byte[] bytes) {
		byte[] data = new byte[bytes.length / 2];
		
		for (int i = 0; i < bytes.length; i++) {
			data[i / 2] = (byte) ((charToInt(bytes[i++]) << 4) + charToInt(bytes[i]));
		}
		return data;
	}
	
	private static byte intToChar(int i) {
		if (i >= 0 && i <= 9) return (byte) ('0' + i);
		if (i >= 10 && i <= 15) return (byte) ('a' + i - 10);
		throw new IllegalArgumentException("Unexpected index value: " + i);
	}
	
	private static byte charToInt(byte c) {
		if (c >= '0' && c <= '9') return (byte) (c - '0');
		if (c >= 'a' && c <= 'f') return (byte) (c - 'a' + 10);
		throw new IllegalArgumentException("Unexpected char value: " + c);
	}
}
