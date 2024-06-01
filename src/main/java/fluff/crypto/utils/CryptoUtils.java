package fluff.crypto.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for cryptographic operations.
 */
public class CryptoUtils {
    
    /**
     * Returns a {@link MessageDigest} instance for the specified algorithm.
     *
     * @param algorithm the name of the algorithm requested
     * @return a {@link MessageDigest} instance or null if the algorithm is not available
     */
    public static MessageDigest getMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {}
        return null;
    }
    
    /**
     * Converts a byte array to a hexadecimal representation.
     *
     * @param bytes the byte array to convert
     * @return the hexadecimal representation as a byte array
     */
    public static byte[] bytesToHex(byte[] bytes) {
        byte[] out = new byte[bytes.length * 2];
        
        for (int i = 0, j = 0; i < bytes.length; i++) {
            out[j++] = intToChar((0xF0 & bytes[i]) >>> 4);
            out[j++] = intToChar(0x0F & bytes[i]);
        }
        
        return out;
    }
    
    /**
     * Converts a hexadecimal representation to a byte array.
     *
     * @param bytes the hexadecimal representation as a byte array
     * @return the byte array
     */
    public static byte[] hexToBytes(byte[] bytes) {
        byte[] data = new byte[bytes.length / 2];
        
        for (int i = 0; i < bytes.length; i++) {
            data[i / 2] = (byte) ((charToInt(bytes[i++]) << 4) + charToInt(bytes[i]));
        }
        return data;
    }
    
    /**
     * Converts an integer to its corresponding hexadecimal character.
     *
     * @param i the integer to convert
     * @return the corresponding hexadecimal character as a byte
     */
    private static byte intToChar(int i) {
        if (i >= 0 && i <= 9) return (byte) ('0' + i);
        if (i >= 10 && i <= 15) return (byte) ('a' + i - 10);
        throw new IllegalArgumentException("Unexpected index value: " + i);
    }
    
    /**
     * Converts a hexadecimal character to its corresponding integer value.
     *
     * @param c the hexadecimal character to convert
     * @return the corresponding integer value
     */
    private static byte charToInt(byte c) {
        if (c >= '0' && c <= '9') return (byte) (c - '0');
        if (c >= 'a' && c <= 'f') return (byte) (c - 'a' + 10);
        throw new IllegalArgumentException("Unexpected char value: " + c);
    }
}
