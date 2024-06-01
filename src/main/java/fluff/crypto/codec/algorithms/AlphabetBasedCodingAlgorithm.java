package fluff.crypto.codec.algorithms;

import java.util.Arrays;

import fluff.crypto.CryptoOutput;
import fluff.crypto.codec.CodingException;
import fluff.crypto.codec.ICodingAlgorithm;

/**
 * Implements an alphabet-based encoding and decoding algorithm.
 * This algorithm is configurable with custom alphabets and padding.
 */
public class AlphabetBasedCodingAlgorithm implements ICodingAlgorithm {
	
	private static final byte INVALID = -1;
	
	private final int encSize, encBits;
	private final int decSize, decBits;
	private final int size1;
	private final byte[] enc;
	private final byte[] dec;
	private final byte pad;
	
	/**
	 * Constructs a new AlphabetBasedCodingAlgorithm with padding.
	 *
	 * @param encSize the size of the encoded block
	 * @param encBits the number of bits per encoded block
	 * @param decSize the size of the decoded block
	 * @param decBits the number of bits per decoded block
	 * @param alphabet the encoding alphabet
	 * @param pad the padding character
	 */
	public AlphabetBasedCodingAlgorithm(int encSize, int encBits, int decSize, int decBits, String alphabet, char pad) {
		this.encSize = encSize;
		this.encBits = encBits;
		this.decSize = decSize;
		this.decBits = decBits;
		this.size1 = alphabet.length() - 1;
		this.enc = alphabet.getBytes();
		this.dec = new byte[256];
		this.pad = (byte) pad;
		
		Arrays.fill(dec, INVALID);
		for (byte i = 0; i < enc.length; i++) {
			dec[enc[i]] = i;
		}
	}
	
	/**
	 * Constructs a new AlphabetBasedCodingAlgorithm without padding.
	 *
	 * @param encSize the size of the encoded block
	 * @param encBits the number of bits per encoded block
	 * @param decSize the size of the decoded block
	 * @param decBits the number of bits per decoded block
	 * @param alphabet the encoding alphabet
	 */
	public AlphabetBasedCodingAlgorithm(int encSize, int encBits, int decSize, int decBits, String alphabet) {
		this(encSize, encBits, decSize, decBits, alphabet, (char) 0);
	}
	
	@Override
	public void encode(CryptoOutput out, byte[] bytes) throws CodingException {
	    int maxLen = (bytes.length + encSize) * encSize / decSize;
	    
	    int len = 0;
	    int buffer = 0;
	    int bitsInBuffer = 0;
	    byte[] buf = new byte[maxLen];
	    
	    for (int i = 0; i < bytes.length; i++) {
	        buffer = (buffer << decBits) | (bytes[i] & 0xFF);
	        bitsInBuffer += decBits;
	        
	        while (bitsInBuffer >= encBits) {
	            bitsInBuffer -= encBits;
	            int index = (buffer >> bitsInBuffer) & size1;
	            buf[len++] = enc[index];
	        }
	    }
	    
	    if (bitsInBuffer > 0) {
	        buffer <<= (encBits - bitsInBuffer);
	        int index = buffer & size1;
	        buf[len++] = enc[index];
	    }
	    
	    if (pad != 0) {
		    while (len < maxLen) {
		        buf[len++] = pad;
		    }
	    }
	    
	    out.write(buf, 0, len);
	}
	
	@Override
	public void decode(CryptoOutput out, byte[] bytes) throws CodingException {
	    int maxLen = (bytes.length + decSize) * decSize / encSize;
	    
	    int len = 0;
	    int buffer = 0;
	    int bitsInBuffer = 0;
	    byte[] buf = new byte[maxLen];
	    
	    for (int i = 0; i < bytes.length; i++) {
	        if (bytes[i] == pad) break;
	        
	        int index = dec[bytes[i]];
	        if (index == INVALID) throw new CodingException("Bad input character: " + (char) bytes[i]);
	        
	        buffer = (buffer << encBits) | index;
	        bitsInBuffer += encBits;
	        
	        while (bitsInBuffer >= decBits) {
	            bitsInBuffer -= decBits;
	            buf[len++] = (byte) ((buffer >> bitsInBuffer) & 0xFF);
	        }
	    }
	    
	    out.write(buf, 0, len);
	}
}
