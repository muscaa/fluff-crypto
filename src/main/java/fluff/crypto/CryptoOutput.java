package fluff.crypto;

import java.io.ByteArrayOutputStream;

import fluff.crypto.format.ICryptoFormat;

/**
 * A utility class for writing cryptographic data to a byte array output stream.
 */
public class CryptoOutput {
    
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    /**
     * Writes a portion of a byte array to the output stream.
     *
     * @param b the byte array
     * @param off the start offset in the data
     * @param len the number of bytes to write
     */
    public void write(byte[] b, int off, int len) {
        out.write(b, off, len);
    }
    
    /**
     * Writes a byte array to the output stream.
     *
     * @param b the byte array
     */
    public void write(byte[] b) {
        write(b, 0, b.length);
    }
    
    /**
     * Writes a string to the output stream.
     *
     * @param s the string
     */
    public void write(String s) {
        write(s.getBytes());
    }
    
    /**
     * Gets the result of the cryptographic operation.
     *
     * @return a {@link CryptoResult} containing the formatted output data
     */
    public CryptoResult getResult() {
        return new CryptoResult(ICryptoFormat.DEFAULT, out.toByteArray());
    }
}
