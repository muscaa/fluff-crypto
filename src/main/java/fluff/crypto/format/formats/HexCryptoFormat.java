package fluff.crypto.format.formats;

import fluff.crypto.format.ICryptoFormat;
import fluff.crypto.utils.CryptoUtils;

/**
 * Implementation of the {@link ICryptoFormat} interface that formats bytes as hexadecimal strings.
 */
public class HexCryptoFormat implements ICryptoFormat {
	
	@Override
	public byte[] Bytes(byte[] bytes) {
		return CryptoUtils.bytesToHex(bytes);
	}
	
	@Override
	public String String(byte[] bytes) {
		return new String(Bytes(bytes));
	}
}
