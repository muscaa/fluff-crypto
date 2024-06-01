package fluff.crypto.format;

import fluff.crypto.format.formats.DefaultCryptoFormat;
import fluff.crypto.format.formats.HexCryptoFormat;

/**
 * Interface for defining cryptographic formats.
 */
public interface ICryptoFormat {
	
	/**
	 * The default cryptographic format.
	 */
	ICryptoFormat DEFAULT = new DefaultCryptoFormat();
	
	/**
	 * The hexadecimal cryptographic format.
	 */
	ICryptoFormat HEX = new HexCryptoFormat();
	
	/**
	 * Converts the given byte array into a formatted byte array.
	 *
	 * @param bytes the input byte array
	 * @return the formatted byte array
	 */
	byte[] Bytes(byte[] bytes);
	
	/**
	 * Converts the given byte array into a formatted string.
	 *
	 * @param bytes the input byte array
	 * @return the formatted string
	 */
	String String(byte[] bytes);
}
