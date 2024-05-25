package fluff.crypto;

import fluff.crypto.format.ICryptoFormat;

public class CryptoResult {
	
	private final ICryptoFormat format;
	private final byte[] bytes;
	
	public CryptoResult(ICryptoFormat format, byte[] bytes) {
		this.format = format;
		this.bytes = bytes;
	}
	
	public CryptoResult format(ICryptoFormat format) {
		return new CryptoResult(format, bytes);
	}
	
	public byte[] Bytes() {
		return format.Bytes(bytes);
	}
	
	public String String() {
		return format.String(bytes);
	}
}
