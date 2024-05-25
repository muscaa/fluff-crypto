package fluff.crypto.codec.algorithms;

import java.util.Arrays;

import fluff.crypto.CryptoOutput;
import fluff.crypto.codec.CodingException;
import fluff.crypto.codec.ICodingAlgorithm;

public class Base64CodingAlgorithm implements ICodingAlgorithm {
	
	private static final byte EQUALS_SIGN = (byte) '=';
	private static final byte EQUALS_SIGN_DEC = -1;
	private static final byte WHITE_SPACE_DEC = -2;
	private static final byte INVALID_DEC = -3;
	private static final byte[] ENC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes();
	private static final byte[] DEC = new byte[128];

	static {
		Arrays.fill(DEC, INVALID_DEC);
		
		for (int i = 0; i < 64; i++) DEC[ENC[i]] = (byte) i;
		DEC[EQUALS_SIGN] = EQUALS_SIGN_DEC;
		
		DEC['\t'] = WHITE_SPACE_DEC;
		DEC['\n'] = WHITE_SPACE_DEC;
		DEC['\r'] = WHITE_SPACE_DEC;
		DEC[' '] = WHITE_SPACE_DEC;
	}
	
	@Override
	public void encode(CryptoOutput out, byte[] bytes) throws CodingException {
		final int len43 = bytes.length * 4 / 3;
		
		byte[] outBuff = new byte[len43 + ((bytes.length % 3) > 0 ? 4 : 0)];
		int d = 0;
		int e = 0;
		int len2 = bytes.length - 2;
		
		for (; d < len2; d += 3, e += 4) encode3to4(bytes, d, 3, outBuff, e);
		
		if (d < bytes.length) {
			encode3to4(bytes, d, bytes.length - d, outBuff, e);
			e += 4;
		}
		
		out.write(outBuff, 0, e);
	}
	
	@Override
	public void decode(CryptoOutput out, byte[] bytes) throws CodingException {
		byte[] outBuff = new byte[bytes.length * 3 / 4];
		int outBuffPosn = 0;
		
		byte[] b4 = new byte[4];
		int b4Posn = 0;
		
		for (int i = 0; i < bytes.length; i++) {
			byte sbiCrop = (byte) (bytes[i] & 0x7f);
			byte sbiDecode = DEC[sbiCrop];
			
			if (EQUALS_SIGN_DEC <= sbiDecode) {
				b4[b4Posn++] = sbiCrop;
				if (b4Posn > 3) {
					outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn);
					b4Posn = 0;
					
					if (sbiCrop == EQUALS_SIGN) break;
				}
			} else if (sbiDecode != WHITE_SPACE_DEC) {
				throw new CodingException("Bad Base64 input character decimal " + Integer.valueOf(bytes[i] & 0xff) + " in array position " + Integer.valueOf(i));
			}
		}
		
		out.write(outBuff, 0, outBuffPosn);
	}
	
	private static void encode3to4(byte[] source, int srcOffset, int numSigBytes, byte[] destination, int destOffset) {
		int inBuff = 0;
		switch (numSigBytes) {
			case 3:
				inBuff |= (source[srcOffset + 2] << 24) >>> 24;
				
			case 2:
				inBuff |= (source[srcOffset + 1] << 24) >>> 16;
				
			case 1:
				inBuff |= (source[srcOffset] << 24) >>> 8;
		}
		
		switch (numSigBytes) {
			case 3:
				destination[destOffset] = ENC[(inBuff >>> 18)];
				destination[destOffset + 1] = ENC[(inBuff >>> 12) & 0x3f];
				destination[destOffset + 2] = ENC[(inBuff >>> 6) & 0x3f];
				destination[destOffset + 3] = ENC[(inBuff) & 0x3f];
				break;
				
			case 2:
				destination[destOffset] = ENC[(inBuff >>> 18)];
				destination[destOffset + 1] = ENC[(inBuff >>> 12) & 0x3f];
				destination[destOffset + 2] = ENC[(inBuff >>> 6) & 0x3f];
				destination[destOffset + 3] = EQUALS_SIGN;
				break;
				
			case 1:
				destination[destOffset] = ENC[(inBuff >>> 18)];
				destination[destOffset + 1] = ENC[(inBuff >>> 12) & 0x3f];
				destination[destOffset + 2] = EQUALS_SIGN;
				destination[destOffset + 3] = EQUALS_SIGN;
				break;
		}
	}
	
	private static int decode4to3(byte[] source, int srcOffset, byte[] destination, int destOffset) {
		if (source[srcOffset + 2] == EQUALS_SIGN) {
			int outBuff = ((DEC[source[srcOffset]] & 0xFF) << 18) | ((DEC[source[srcOffset + 1]] & 0xFF) << 12);
			destination[destOffset] = (byte) (outBuff >>> 16);
			return 1;
		} else if (source[srcOffset + 3] == EQUALS_SIGN) {
			int outBuff = ((DEC[source[srcOffset]] & 0xFF) << 18) | ((DEC[source[srcOffset + 1]] & 0xFF) << 12) | ((DEC[source[srcOffset + 2]] & 0xFF) << 6);
			destination[destOffset] = (byte) (outBuff >>> 16);
			destination[destOffset + 1] = (byte) (outBuff >>> 8);
			return 2;
		} else {
			int outBuff = ((DEC[source[srcOffset]] & 0xFF) << 18) | ((DEC[source[srcOffset + 1]] & 0xFF) << 12) | ((DEC[source[srcOffset + 2]] & 0xFF) << 6) | ((DEC[source[srcOffset + 3]] & 0xFF));
			destination[destOffset] = (byte) (outBuff >> 16);
			destination[destOffset + 1] = (byte) (outBuff >> 8);
			destination[destOffset + 2] = (byte) (outBuff);
			return 3;
		}
	}
}
