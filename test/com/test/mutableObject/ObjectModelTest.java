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
package com.test.mutableObject;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.api.test.mutableObject.BMWFactory;
import com.api.test.mutableObject.Engine;
import com.api.test.mutableObject.Motorcycle;
import com.api.test.mutableObject.Vehicle;
import com.util.mutableObject.PropertiesCache;

/**
 * The {@link ObjectModelTest} tests the implementation of the reflection based
 * toString method.
 * 
 * @version 1.0
 */
public class ObjectModelTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * {@link com.api.mutableObject.MutableObject#toString()}
	 */
	@Test
	public void testToStringRecurive() {
		/*
		 * Set the recursive property to 'true' (this is the default behavior if
		 * not specified)
		 */
		PropertiesCache.getInstance().setProperty("recursive",
				String.valueOf(true));
		/* StringBuilder of desired output of the toString of Vehicle object */
		StringBuilder resultWithoutEngine = new StringBuilder("Vehicle {\n");
		resultWithoutEngine.append("make = BMW\n");
		resultWithoutEngine.append("model = 328xi\n");
		resultWithoutEngine.append("manufacturer = Germany\n");
		resultWithoutEngine.append("engine = null\n");
		resultWithoutEngine.append("}");
		/* Create Vehicle without Engine */
		Vehicle bmw3Series = new Vehicle("BMW", "328xi", "Germany");
		/* Verify that the generated toString matches */
		assertNotNull(bmw3Series);
		assertEquals(bmw3Series.toString(), resultWithoutEngine.toString());
		/*
		 * StringBuilder of desired output of the toString of Vehicle object
		 * with Engine
		 */
		StringBuilder resultWithEngine = new StringBuilder("Vehicle {\n");
		resultWithEngine.append("make = BMW\n");
		resultWithEngine.append("model = M20\n");
		resultWithEngine.append("manufacturer = Germany\n");
		resultWithEngine.append("engine = Engine {\n");
		resultWithEngine.append("type = six-cylinder engine\n");
		resultWithEngine.append("}\n");
		resultWithEngine.append("}");
		/* Create the Engine object */
		Engine engine = new Engine("six-cylinder engine");
		/* Create the Vehicle object with the Engine attached */
		Vehicle bmwM20 = new Vehicle("BMW", "M20", "Germany", engine);
		/* Verify that the generated toString matches */
		assertNotNull(bmwM20);
		assertEquals(bmwM20.toString(), resultWithEngine.toString());
		assertNotSame(bmwM20, resultWithEngine);
		assertNotSame(bmw3Series.toString(), bmwM20.toString());
		/* Create the Factory object */
		BMWFactory bmwFactory = new BMWFactory();
		List<Vehicle> cars = new ArrayList<Vehicle>();
		cars.add(bmw3Series);
		cars.add(bmwM20);
		bmwFactory.setVehicles(cars);
		/*
		 * StringBuilder of actual output of the toString of BMWFactory object
		 * with a list of Vehicle objects
		 */
		StringBuilder resultBMWFactory = new StringBuilder("BMWFactory {\n");
		resultBMWFactory.append("vehicles = [Vehicle {\n");
		resultBMWFactory.append("make = BMW\n");
		resultBMWFactory.append("model = 328xi\n");
		resultBMWFactory.append("manufacturer = Germany\n");
		resultBMWFactory.append("engine = null\n");
		resultBMWFactory.append("}, Vehicle {\n");
		resultBMWFactory.append("make = BMW\n");
		resultBMWFactory.append("model = M20\n");
		resultBMWFactory.append("manufacturer = Germany\n");
		resultBMWFactory.append("engine = Engine {\n");
		resultBMWFactory.append("type = six-cylinder engine\n");
		resultBMWFactory.append("}\n");
		resultBMWFactory.append("}]\n");
		resultBMWFactory.append("}");
		/* Verify that the generated toString matches */
		assertNotNull(bmwFactory);
		assertNotSame(bmwFactory, resultBMWFactory);
		assertEquals(bmwFactory.toString(), resultBMWFactory.toString());
	}

	/**
	 * {@link com.api.mutableObject.MutableObject#toString()}
	 */
	@Test
	public void testToStringNonRecursive() {
		/* Set the recursive property to 'false' (default is always 'true') */
		PropertiesCache.getInstance().setProperty("recursive",
				String.valueOf(false));

		boolean recursive = Boolean.valueOf(PropertiesCache.getInstance()
				.getProperty("recursive"));
		assertFalse(recursive);
		/* StringBuilder of desired output of the toString of Motorcycle object */
		StringBuilder resultBMWS1000XR = new StringBuilder("Motorcycle {\n");
		resultBMWS1000XR.append("}");
		/* Create the Engine */
		Engine engine = new Engine("two-cylinder engine");
		/* Create the Motorcycle with an engine */
		Motorcycle bmwS1000XR = new Motorcycle("BMW", "S 1000 XR", "Germany",
				engine);
		assertNotNull(bmwS1000XR);
		/* Verify that the generated toString matches */
		assertEquals(bmwS1000XR.toString(), resultBMWS1000XR.toString());
		assertNotSame(bmwS1000XR, resultBMWS1000XR);
		/* Explicitly set the recursive property to 'true' (was 'false' before) */
		PropertiesCache.getInstance().setProperty("recursive",
				String.valueOf(true));

		recursive = Boolean.valueOf(PropertiesCache.getInstance().getProperty(
				"recursive"));
		assertTrue(recursive);
		/* StringBuilder of desired output of the toString of Motorcycle object */
		StringBuilder resultBMWS1000XRWithRecursion = new StringBuilder(
				"Motorcycle {\n");
		resultBMWS1000XRWithRecursion.append("make = BMW\n");
		resultBMWS1000XRWithRecursion.append("model = S 1000 XR\n");
		resultBMWS1000XRWithRecursion.append("manufacturer = Germany\n");
		resultBMWS1000XRWithRecursion.append("engine = Engine {\n");
		resultBMWS1000XRWithRecursion.append("type = two-cylinder engine\n");
		resultBMWS1000XRWithRecursion.append("}\n");
		resultBMWS1000XRWithRecursion.append("}");
		/* Verify that the generated toString matches */
		assertEquals(bmwS1000XR.toString(),
				resultBMWS1000XRWithRecursion.toString());
		assertNotSame(bmwS1000XR, resultBMWS1000XRWithRecursion);

	}
}
