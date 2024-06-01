package fluff.crypto.codec;

import java.io.IOException;
import java.io.InputStream;

import fluff.crypto.CryptoOutput;
import fluff.crypto.CryptoResult;

/**
 * Provides utility functions for encoding and decoding data using a specified {@link ICodingAlgorithm}.
 */
public class CodingFunctions {
    
    private final ICodingAlgorithm algorithm;
    
    /**
     * Constructs a new {@code CodingFunctions} with the specified encoding/decoding algorithm.
     *
     * @param algorithm the encoding/decoding algorithm to use
     */
    public CodingFunctions(ICodingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    /**
     * Encodes the specified byte array.
     *
     * @param bytes the byte array to encode
     * @return the encoded result
     * @throws CodingException if an error occurs during encoding
     */
    public CryptoResult encode(byte[] bytes) throws CodingException {
        CryptoOutput out = new CryptoOutput();
        algorithm.encode(out, bytes);
        return out.getResult();
    }
    
    /**
     * Encodes the specified string.
     *
     * @param s the string to encode
     * @return the encoded result
     * @throws CodingException if an error occurs during encoding
     */
    public CryptoResult encode(String s) throws CodingException {
        return encode(s.getBytes());
    }
    
    /**
     * Encodes data from the specified input stream.
     *
     * @param input the input stream to read data from
     * @return the encoded result
     * @throws CodingException if an error occurs during encoding
     */
    public CryptoResult encode(InputStream input) throws CodingException {
        try {
            return encode(input.readAllBytes());
        } catch (IOException e) {
            throw new CodingException(e);
        }
    }
    
    /**
     * Decodes the specified byte array.
     *
     * @param bytes the byte array to decode
     * @return the decoded result
     * @throws CodingException if an error occurs during decoding
     */
    public CryptoResult decode(byte[] bytes) throws CodingException {
        CryptoOutput out = new CryptoOutput();
        algorithm.decode(out, bytes);
        return out.getResult();
    }
    
    /**
     * Decodes the specified string.
     *
     * @param s the string to decode
     * @return the decoded result
     * @throws CodingException if an error occurs during decoding
     */
    public CryptoResult decode(String s) throws CodingException {
        return decode(s.getBytes());
    }
    
    /**
     * Decodes data from the specified input stream.
     *
     * @param input the input stream to read data from
     * @return the decoded result
     * @throws CodingException if an error occurs during decoding
     */
    public CryptoResult decode(InputStream input) throws CodingException {
        try {
            return decode(input.readAllBytes());
        } catch (IOException e) {
            throw new CodingException(e);
        }
    }
}
