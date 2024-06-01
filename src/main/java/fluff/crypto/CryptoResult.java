package fluff.crypto;

import fluff.crypto.format.ICryptoFormat;

/**
 * Represents the result of a cryptographic operation.
 */
public class CryptoResult {
    
    private final ICryptoFormat format;
    private final byte[] bytes;
    
    /**
     * Constructs a new {@code CryptoResult} with the specified format and byte array.
     *
     * @param format the format to use for the cryptographic result
     * @param bytes the byte array representing the cryptographic data
     */
    public CryptoResult(ICryptoFormat format, byte[] bytes) {
        this.format = format;
        this.bytes = bytes;
    }
    
    /**
     * Returns a new {@code CryptoResult} with the specified format, using the same byte array.
     *
     * @param format the new format to use
     * @return a new {@code CryptoResult} with the specified format
     */
    public CryptoResult format(ICryptoFormat format) {
        return new CryptoResult(format, bytes);
    }
    
    /**
     * Returns the cryptographic data as a byte array.
     *
     * @return the byte array representing the cryptographic data
     */
    public byte[] Bytes() {
        return format.Bytes(bytes);
    }
    
    /**
     * Returns the cryptographic data as a formatted string.
     *
     * @return the string representation of the cryptographic data
     */
    public String String() {
        return format.String(bytes);
    }
}
