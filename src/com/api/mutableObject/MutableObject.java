/*
 The MIT License (MIT)

 Copyright (c) 2015 Rahul Nadella https://github.com/rahulnadella 

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */
package com.api.mutableObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.util.mutableObject.PropertiesCache;

/**
 * The {@class MutableObject} uses Reflection API to access the field values to
 * generate the toString for the extended class and any super classes as long as
 * the Property (associated to mutable.properties) 'recursive' is set to true.
 * 
 * Please, be aware of performance issues of reflective methods. Thus, if the
 * performance of your toString implementation is important, I recommend you to
 * ignore this method and make your own implementation. However, if the
 * performance doesn’t matter you can benefit from this method.
 *
 * @version 1.0
 */
public class MutableObject implements Serializable {

	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 5410677756832167708L;

	@Override
	public String toString() {
		/*
		 * If true, the fields declared by the ancestor classes of the given
		 * object’s type also included in the returned string. Otherwise, only
		 * the fields declared by the object’s type are printed.
		 */
		boolean recursive = Boolean.parseBoolean(PropertiesCache.getInstance()
				.getProperty("recursive"));
		/* Retrieve the new line separator */
		String newLine = System.getProperty("line.separator");
		/* Start building the result of the current Object.toString */
		StringBuilder result = new StringBuilder();
		result.append(this.getClass().getSimpleName());
		result.append(" {");
		result.append(newLine);

		Class<?> cls = this.getClass();

		while (cls != null && !cls.equals(this)) {
			/*
			 * the fields declared by the current class (object’s type or an
			 * ancestor of it) are retrieved
			 */
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				/* Visit non-static fields only */
				if (!Modifier.isStatic(f.getModifiers())) {
					try {
						/* Get the value of private field */
						f.setAccessible(true);
						/* Append the current field name and value */
						result.append(f.getName());
						result.append(" = ");
						result.append(f.get(this));
					} catch (IllegalAccessException iae) {
						iae.printStackTrace();
					}
					result.append(newLine);
				}
			}

			if (!recursive)
				break;
			/* Recursive is true then retrieve the superclass */
			cls = cls.getSuperclass();
		}

		return result.append("}").toString();
	}
}
