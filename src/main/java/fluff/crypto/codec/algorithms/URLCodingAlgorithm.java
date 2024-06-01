package fluff.crypto.codec.algorithms;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import fluff.crypto.CryptoOutput;
import fluff.crypto.codec.CodingException;
import fluff.crypto.codec.ICodingAlgorithm;

/**
 * Implements URL encoding and decoding algorithms.
 */
public class URLCodingAlgorithm implements ICodingAlgorithm {
	
	@Override
	public void encode(CryptoOutput out, byte[] bytes) throws CodingException {
		String encoded = URLEncoder.encode(new String(bytes), StandardCharsets.UTF_8);
		out.write(encoded);
	}
	
	@Override
	public void decode(CryptoOutput out, byte[] bytes) throws CodingException {
		String decoded = URLDecoder.decode(new String(bytes), StandardCharsets.UTF_8);
		out.write(decoded);
	}
}
