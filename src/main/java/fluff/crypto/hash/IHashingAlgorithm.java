package fluff.crypto.hash;

import fluff.crypto.CryptoOutput;

public interface IHashingAlgorithm {
	
	void hash(CryptoOutput out, byte[] bytes) throws HashingException;
}
