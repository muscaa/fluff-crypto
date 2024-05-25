package fluff.crypto;

public class CryptoException extends RuntimeException {
	
	private static final long serialVersionUID = -1618973400518140574L;
	
	public CryptoException() {
        super();
    }
	
    public CryptoException(String message) {
        super(message);
    }
    
    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CryptoException(Throwable cause) {
        super(cause);
    }
}
