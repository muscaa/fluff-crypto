package fluff.crypto.hash;

import java.io.IOException;
import java.io.InputStream;

import fluff.crypto.CryptoOutput;
import fluff.crypto.CryptoResult;

/**
 * Utility class for performing hashing operations using a specified hashing algorithm.
 */
public class HashingFunctions {
	
	private final IHashingAlgorithm algorithm;
	
	/**
	 * Constructs a new {@code HashingFunctions} instance with the specified hashing algorithm.
	 *
	 * @param algorithm the hashing algorithm to use
	 */
	public HashingFunctions(IHashingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	/**
	 * Hashes the given byte array and returns the result.
	 *
	 * @param bytes the byte array to hash
	 * @return the result of the hashing operation
	 * @throws HashingException if an error occurs during hashing
	 */
	public CryptoResult hash(byte[] bytes) throws HashingException {
		CryptoOutput out = new CryptoOutput();
		algorithm.hash(out, bytes);
		return out.getResult();
	}
	
	/**
	 * Hashes the given string and returns the result.
	 *
	 * @param s the string to hash
	 * @return the result of the hashing operation
	 * @throws HashingException if an error occurs during hashing
	 */
	public CryptoResult hash(String s) throws HashingException {
		return hash(s.getBytes());
	}
	
	/**
	 * Hashes the contents of the given input stream and returns the result.
	 *
	 * @param input the input stream to hash
	 * @return the result of the hashing operation
	 * @throws HashingException if an error occurs during hashing
	 */
	public CryptoResult hash(InputStream input) throws HashingException {
		try {
			return hash(input.readAllBytes());
		} catch (IOException e) {
			throw new HashingException(e);
		}
	}
}
