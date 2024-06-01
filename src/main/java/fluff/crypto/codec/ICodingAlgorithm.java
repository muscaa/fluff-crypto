package fluff.crypto.codec;

import fluff.crypto.CryptoOutput;

/**
 * Defines the methods for encoding and decoding algorithms.
 */
public interface ICodingAlgorithm {
    
    /**
     * Encodes the specified byte array and writes the result to the provided {@link CryptoOutput}.
     *
     * @param out the output to write the encoded data
     * @param bytes the byte array to encode
     * @throws CodingException if an error occurs during encoding
     */
    void encode(CryptoOutput out, byte[] bytes) throws CodingException;
    
    /**
     * Decodes the specified byte array and writes the result to the provided {@link CryptoOutput}.
     *
     * @param out the output to write the decoded data
     * @param bytes the byte array to decode
     * @throws CodingException if an error occurs during decoding
     */
    void decode(CryptoOutput out, byte[] bytes) throws CodingException;
}
