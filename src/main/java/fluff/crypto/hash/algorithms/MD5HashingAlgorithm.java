package fluff.crypto.hash.algorithms;

import java.security.MessageDigest;

import fluff.crypto.CryptoOutput;
import fluff.crypto.hash.HashingException;
import fluff.crypto.hash.IHashingAlgorithm;
import fluff.crypto.utils.CryptoUtils;

/**
 * An implementation of the {@link IHashingAlgorithm} interface for the MD5 hashing algorithm.
 */
public class MD5HashingAlgorithm implements IHashingAlgorithm {
	
	private static final MessageDigest md = CryptoUtils.getMessageDigest("MD5");
	
	@Override
	public void hash(CryptoOutput out, byte[] bytes) throws HashingException {
		out.write(md.digest(bytes));
	}
}
