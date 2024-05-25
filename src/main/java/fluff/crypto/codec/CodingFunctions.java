package fluff.crypto.codec;

import java.io.IOException;
import java.io.InputStream;

import fluff.crypto.CryptoOutput;
import fluff.crypto.CryptoResult;

public class CodingFunctions {
	
	private final ICodingAlgorithm algorithm;
	
	public CodingFunctions(ICodingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	public CryptoResult encode(byte[] bytes) throws CodingException {
		CryptoOutput out = new CryptoOutput();
		algorithm.encode(out, bytes);
		return out.getResult();
	}
	
	public CryptoResult encode(String s) throws CodingException {
		return encode(s.getBytes());
	}
	
	public CryptoResult encode(InputStream input) throws CodingException {
		try {
			return encode(input.readAllBytes());
		} catch (IOException e) {
			throw new CodingException(e);
		}
	}
	
	public CryptoResult decode(byte[] bytes) throws CodingException {
		CryptoOutput out = new CryptoOutput();
		algorithm.decode(out, bytes);
		return out.getResult();
	}
	
	public CryptoResult decode(String s) throws CodingException {
		return decode(s.getBytes());
	}
	
	public CryptoResult decode(InputStream input) throws CodingException {
		try {
			return decode(input.readAllBytes());
		} catch (IOException e) {
			throw new CodingException(e);
		}
	}
}
