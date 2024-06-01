package fluff.crypto.codec.algorithms;

/**
 * Implements Base64 encoding and decoding algorithm using the AlphabetBasedCodingAlgorithm.
 */
public class Base64CodingAlgorithm extends AlphabetBasedCodingAlgorithm {
	
	/** The size of the data block. */
	public static final int DATA_SIZE = 3;
	
	/** The number of bits per data block. */
	public static final int DATA_BITS = 8;
	
	/** The size of the Base64 encoded block. */
	public static final int BASE64_SIZE = 4;
	
	/** The number of bits per Base64 encoded block. */
	public static final int BASE64_BITS = 6;
	
	/**
	 * Constructs a new Base64CodingAlgorithm with the Base64 alphabet and padding character '='.
	 */
	public Base64CodingAlgorithm() {
		super(BASE64_SIZE, BASE64_BITS, DATA_SIZE, DATA_BITS,
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
	}
}
