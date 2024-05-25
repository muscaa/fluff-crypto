package fluff.crypto.codec;

import fluff.crypto.CryptoException;

public class CodingException extends CryptoException {
	
	private static final long serialVersionUID = -7779468307818234401L;
	
	public CodingException() {
        super();
    }
	
    public CodingException(String message) {
        super(message);
    }
    
    public CodingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CodingException(Throwable cause) {
        super(cause);
    }
}
