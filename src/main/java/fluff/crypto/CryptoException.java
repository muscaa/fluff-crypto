package fluff.crypto;

/**
 * Represents an exception that occurs during cryptographic operations.
 */
public class CryptoException extends RuntimeException {
    
    private static final long serialVersionUID = -1618973400518140574L;
    
    /**
     * Constructs a new CryptoException with {@code null} as its detail message.
     */
    public CryptoException() {
        super();
    }
    
    /**
     * Constructs a new CryptoException with the specified detail message.
     *
     * @param message the detail message
     */
    public CryptoException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new CryptoException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new CryptoException with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public CryptoException(Throwable cause) {
        super(cause);
    }
}
