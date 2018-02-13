package de.qbyte.qtracer.utils;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectPrinter {

	/* ***** PROPERTIES ***** */

	private final String				clazz;
	private final Map<String, Object>	properties	= new LinkedHashMap<String, Object>();

	/* ***** CONSTRUCTORS ***** */

	public ObjectPrinter(Object object) {

		// check for null
		if (object == null)
			throw new IllegalArgumentException("object is null");

		// save class name
		this.clazz = object.getClass().getSimpleName();

	}

	/* ***** METHODS ***** */

	public void addProperty(String name, Object value) {

		// add property
		this.properties.put(name, value);

	}

	public String print() {

		// variables
		boolean separateProperty = false;
		boolean separateArray = false;
		StringBuilder sb = new StringBuilder();

		// add class name
		sb.append(this.clazz);

		// add properties
		if (!this.properties.isEmpty()) {

			// begin property list
			sb.append("[");

			for (Entry<String, Object> param : this.properties.entrySet()) {

				// property name and value
				String key = param.getKey();
				Object value = param.getValue();

				// add separator
				if (separateProperty)
					sb.append(", ");

				// add property name
				sb.append(key + "=");

				// add property value based on the type
				if (value == null) {
					sb.append("null");
				} else if (value.getClass().isArray()) {
					sb.append("[");
					for (int i = 0; i < Array.getLength(value); i++) {
						if (separateArray)
							sb.append(",");
						sb.append(Array.get(value, i));
						separateArray = true;
					}
					sb.append("]");
				} else if (value instanceof Class) {

					sb.append(((Class<?>) value).getSimpleName());
				} else {
					sb.append(value);
				}

				// turn on separation
				separateProperty = true;

			}

			// end property list
			sb.append("]");

		}

		// return object string
		return sb.toString();

	}

}
