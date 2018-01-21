package de.qbyte.qtracer.test.fault;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class FaultMatcher extends TypeSafeMatcher<Throwable> {

	/* ***** PROPERTIES ***** */

	private final Class<? extends Throwable>	exception;
	private final String						exceptionMessage;

	/* ***** CONSTRUCTORS ***** */

	public FaultMatcher(Class<? extends Throwable> exception, String exceptionMessage) {
		this.exception = exception;
		this.exceptionMessage = exceptionMessage;
	}

	/* ***** METHODS ***** */

	@Override
	protected boolean matchesSafely(Throwable fault) {
		return fault.getClass() == this.exception && fault.getMessage().equals(exceptionMessage);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("exception ").appendValue(exception).appendText(" with message ").appendValue(exceptionMessage);
	}
}