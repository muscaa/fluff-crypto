package fluff.crypto.hash;

import fluff.crypto.CryptoOutput;

/**
 * Interface representing a hashing algorithm.
 */
public interface IHashingAlgorithm {
	
	/**
	 * Computes the hash of the given byte array and writes the result to the specified {@link CryptoOutput}.
	 *
	 * @param out the {@link CryptoOutput} to write the hash to
	 * @param bytes the byte array to hash
	 * @throws HashingException if an error occurs during hashing
	 */
	void hash(CryptoOutput out, byte[] bytes) throws HashingException;
}
