package fluff.crypto.codec.algorithms;

/**
 * Implements Base32 encoding and decoding algorithm using the AlphabetBasedCodingAlgorithm.
 */
public class Base32CodingAlgorithm extends AlphabetBasedCodingAlgorithm {
	
	/** The size of the data block. */
	public static final int DATA_SIZE = 5;
	
	/** The number of bits per data block. */
	public static final int DATA_BITS = 8;
	
	/** The size of the Base32 encoded block. */
	public static final int BASE32_SIZE = 8;
	
	/** The number of bits per Base32 encoded block. */
	public static final int BASE32_BITS = 5;
	
	/**
	 * Constructs a new Base32CodingAlgorithm with the Base32 alphabet.
	 */
	public Base32CodingAlgorithm() {
		super(BASE32_SIZE, BASE32_BITS, DATA_SIZE, DATA_BITS,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
	}
}
