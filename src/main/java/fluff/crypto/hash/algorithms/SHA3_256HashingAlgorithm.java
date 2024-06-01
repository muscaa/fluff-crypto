package fluff.crypto.hash.algorithms;

import java.security.MessageDigest;

import fluff.crypto.CryptoOutput;
import fluff.crypto.hash.HashingException;
import fluff.crypto.hash.IHashingAlgorithm;
import fluff.crypto.utils.CryptoUtils;

/**
 * An implementation of the {@link IHashingAlgorithm} interface for the SHA3 256 hashing algorithm.
 */
public class SHA3_256HashingAlgorithm implements IHashingAlgorithm {
	
	private static final MessageDigest md = CryptoUtils.getMessageDigest("SHA3-256");
	
	@Override
	public void hash(CryptoOutput out, byte[] bytes) throws HashingException {
		out.write(md.digest(bytes));
	}
}
