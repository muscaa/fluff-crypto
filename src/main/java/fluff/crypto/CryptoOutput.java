package fluff.crypto;

import java.io.ByteArrayOutputStream;

import fluff.crypto.format.ICryptoFormat;

public class CryptoOutput {
	
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	public void write(byte[] b, int off, int len) {
		out.write(b, off, len);
	}
	
	public void write(byte[] b) {
		write(b, 0, b.length);
	}
	
	public void write(String s) {
		write(s.getBytes());
	}
	
	public CryptoResult getResult() {
		return new CryptoResult(ICryptoFormat.DEFAULT, out.toByteArray());
	}
}
