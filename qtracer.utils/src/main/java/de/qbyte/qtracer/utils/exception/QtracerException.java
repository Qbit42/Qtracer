package de.qbyte.qtracer.utils.exception;

public class QtracerException extends RuntimeException {

	private static final long serialVersionUID = -146852597023013617L;

	public QtracerException() {
		super();
	}
	
	public QtracerException(String message) {
		super(message);
	}
	
	public QtracerException(Throwable cause) {
		super(cause);
	}

	public QtracerException(Throwable cause, String message) {
		super(message, cause);
	}
	

}
