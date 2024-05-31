package fluff.crypto.codec.algorithms;

public class Base64CodingAlgorithm extends AlphabetBasedCodingAlgorithm {
	
	public static final int DATA_SIZE = 3;
	public static final int DATA_BITS = 8;
	
	public static final int BASE64_SIZE = 4;
	public static final int BASE64_BITS = 6;
	
	public Base64CodingAlgorithm() {
		super(BASE64_SIZE, BASE64_BITS, DATA_SIZE, DATA_BITS,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
	}
}
