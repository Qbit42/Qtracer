package de.qbyte.qtracer.test.fault;

import org.junit.rules.ExpectedException;

public class FaultTest {

	/* ***** CONSTRUCTORS ***** */

	// prevent object creation
	private FaultTest() {
	}

	/* ***** METHODS ***** */

	public static void expect(ExpectedException rule, Fault fault) {

		// check only if fault is supplied
		if (fault != null) {
			
			// check base exception and message
			rule.expect(new FaultMatcher(fault.getException(), fault.getExceptionMessage()));
			
			// check cause if supplied
			if (fault.getCause() != null) {
				rule.expectCause(new FaultMatcher(fault.getCause(), fault.getCauseMessage()));
			}
		}

	}
}
