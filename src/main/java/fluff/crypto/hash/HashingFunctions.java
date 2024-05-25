package fluff.crypto.hash;

import java.io.IOException;
import java.io.InputStream;

import fluff.crypto.CryptoOutput;
import fluff.crypto.CryptoResult;

public class HashingFunctions {
	
	private final IHashingAlgorithm algorithm;
	
	public HashingFunctions(IHashingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	public CryptoResult hash(byte[] bytes) throws HashingException {
		CryptoOutput out = new CryptoOutput();
		algorithm.hash(out, bytes);
		return out.getResult();
	}
	
	public CryptoResult hash(String s) throws HashingException {
		return hash(s.getBytes());
	}
	
	public CryptoResult hash(InputStream input) throws HashingException {
		try {
			return hash(input.readAllBytes());
		} catch (IOException e) {
			throw new HashingException(e);
		}
	}
}
