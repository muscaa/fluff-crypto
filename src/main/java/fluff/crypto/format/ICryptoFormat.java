package fluff.crypto.format;

import fluff.crypto.format.formats.DefaultCryptoFormat;
import fluff.crypto.format.formats.HexCryptoFormat;

public interface ICryptoFormat {
	
	ICryptoFormat DEFAULT = new DefaultCryptoFormat();
	ICryptoFormat HEX = new HexCryptoFormat();
	
	byte[] Bytes(byte[] bytes);
	
	String String(byte[] bytes);
}
