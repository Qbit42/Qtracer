package de.qbyte.qtracer.utils.exception;

import org.junit.Test;

import de.qbyte.qtracer.test.fault.Fault;
import de.qbyte.qtracer.test.fault.FaultTest;
import de.qbyte.qtracer.test.testcase.QtracerTest;

public class QtracerException_Test extends QtracerTest {

	@Test
	public void test() {
		
		FaultTest.expect(this.exception, new Fault(QtracerException.class, ""));

		throw new QtracerException("");
	}

}
