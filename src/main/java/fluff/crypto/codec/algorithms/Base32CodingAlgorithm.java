package fluff.crypto.codec.algorithms;

public class Base32CodingAlgorithm extends AlphabetBasedCodingAlgorithm {
	
	public static final int DATA_SIZE = 5;
	public static final int DATA_BITS = 8;
	
	public static final int BASE32_SIZE = 8;
	public static final int BASE32_BITS = 5;
	
	public Base32CodingAlgorithm() {
		super(BASE32_SIZE, BASE32_BITS, DATA_SIZE, DATA_BITS,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
	}
}
