package de.qbyte.qtracer.test.testdata;

import java.util.ArrayList;
import java.util.List;

public class TestData {

	/* ***** PROPERTIES ***** */

	private final Class<?>[]	classes;
	private List<Object[]>		data	= new ArrayList<>();

	/* ***** CONSTRUCTORS ***** */

	public TestData(Class<?>... classes) {

		// check for empty classes
		if (classes == null || classes.length == 0)
			throw new IllegalArgumentException("no classes supplied");

		// store classes
		this.classes = classes;

	}

	/* ***** METHODS ***** */

	public void set(Object... objects) {

		// check for similar lengths
		if (objects.length != this.classes.length)
			throw new IllegalArgumentException("wrong number of arguments");

		// check for right types
		for (int i = 0; i < objects.length; i++) {

			Object object = objects[i];
			Class<?> clazz = this.classes[i];

			if (object != null && !clazz.isInstance(object))
				throw new IllegalArgumentException("wrong type of argument");

		}

		// add data set
		this.data.add(objects);

	}

	public Object[] create() {

		// convert list to array
		return this.data.toArray(new Object[this.data.size()]);

	}

}
