package fluff.crypto.hash.algorithms;

import java.security.MessageDigest;

import fluff.crypto.CryptoOutput;
import fluff.crypto.hash.HashingException;
import fluff.crypto.hash.IHashingAlgorithm;
import fluff.crypto.utils.CryptoUtils;

/**
 * An implementation of the {@link IHashingAlgorithm} interface for the SHA 384 hashing algorithm.
 */
public class SHA_384HashingAlgorithm implements IHashingAlgorithm {
	
	private static final MessageDigest md = CryptoUtils.getMessageDigest("SHA-384");
	
	@Override
	public void hash(CryptoOutput out, byte[] bytes) throws HashingException {
		out.write(md.digest(bytes));
	}
}
