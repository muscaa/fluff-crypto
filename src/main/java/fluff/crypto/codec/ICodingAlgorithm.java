package fluff.crypto.codec;

import fluff.crypto.CryptoOutput;

public interface ICodingAlgorithm {
	
	void encode(CryptoOutput out, byte[] bytes) throws CodingException;
	
	void decode(CryptoOutput out, byte[] bytes) throws CodingException;
}
