package fluff.crypto;

import java.io.ByteArrayOutputStream;

import fluff.crypto.format.ICryptoFormat;

public class CryptoOutput {
	
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	public void write(byte[] b) {
		out.writeBytes(b);
	}
	
	public void write(byte[] b, int off, int len) {
		out.write(b, off, len);
	}
	
	public CryptoResult getResult() {
		return new CryptoResult(ICryptoFormat.DEFAULT, out.toByteArray());
	}
}
