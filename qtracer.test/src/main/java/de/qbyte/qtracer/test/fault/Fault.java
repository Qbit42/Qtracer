package de.qbyte.qtracer.test.fault;

public class Fault {

	/* ***** PROPERTIES ***** */

	private final Class<? extends Throwable>	exception;
	private final String						exceptionMessage;

	private Class<? extends Throwable>	cause			= null;
	private String						causeMessage	= null;

	/* ***** CONSTRUCTORS ***** */

	public Fault(Class<? extends Throwable> exception, String message) {

		// save exception data
		this.exception = exception;
		this.exceptionMessage = message;
	}

	/* ***** METHODS ***** */

	public Fault addCause(Class<? extends Throwable> exception, String message) {

		// save cause data
		this.cause = exception;
		this.causeMessage = message;

		// return this instance
		return this;

	}

	/* ***** GETTER ***** */

	public Class<? extends Throwable> getException() {
		return exception;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public Class<? extends Throwable> getCause() {
		return cause;
	}

	public String getCauseMessage() {
		return causeMessage;
	}

}
