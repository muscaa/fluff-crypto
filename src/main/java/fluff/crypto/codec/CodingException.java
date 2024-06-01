package fluff.crypto.codec;

import fluff.crypto.CryptoException;

/**
 * Represents an exception that occurs during encoding or decoding operations.
 */
public class CodingException extends CryptoException {
	
	private static final long serialVersionUID = -7779468307818234401L;
	
	/**
	 * Constructs a new {@code CodingException} with {@code null} as its detail message.
	 */
	public CodingException() {
        super();
    }
	
	/**
	 * Constructs a new {@code CodingException} with the specified detail message.
	 *
	 * @param message the detail message
	 */
    public CodingException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new {@code CodingException} with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public CodingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new {@code CodingException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public CodingException(Throwable cause) {
        super(cause);
    }
}
