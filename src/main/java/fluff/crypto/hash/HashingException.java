package fluff.crypto.hash;

import fluff.crypto.CryptoException;

/**
 * Represents an exception specific to hashing operations.
 */
public class HashingException extends CryptoException {
	
	private static final long serialVersionUID = -7779468307818234401L;
	
	/**
	 * Constructs a new {@code HashingException} with {@code null} as its detail message.
	 */
	public HashingException() {
        super();
    }
	
	/**
	 * Constructs a new {@code HashingException} with the specified detail message.
	 *
	 * @param message the detail message
	 */
    public HashingException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new {@code HashingException} with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public HashingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new {@code HashingException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public HashingException(Throwable cause) {
        super(cause);
    }
}
