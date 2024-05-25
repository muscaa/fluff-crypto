package fluff.crypto.format.formats;

import fluff.crypto.format.ICryptoFormat;

public class DefaultCryptoFormat implements ICryptoFormat {
	
	@Override
	public byte[] Bytes(byte[] bytes) {
		return bytes;
	}
	
	@Override
	public String String(byte[] bytes) {
		return new String(Bytes(bytes));
	}
}
