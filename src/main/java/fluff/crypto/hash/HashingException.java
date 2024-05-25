package fluff.crypto.hash;

import fluff.crypto.CryptoException;

public class HashingException extends CryptoException {
	
	private static final long serialVersionUID = -7779468307818234401L;
	
	public HashingException() {
        super();
    }
	
    public HashingException(String message) {
        super(message);
    }
    
    public HashingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public HashingException(Throwable cause) {
        super(cause);
    }
}
