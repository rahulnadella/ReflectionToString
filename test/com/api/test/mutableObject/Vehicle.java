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
package com.api.test.mutableObject;

import com.api.mutableObject.MutableObject;

/**
 * The {@class Vehicle} is Plain Old Java Object (POJO) for defining descriptive
 * parameters for a Vehicle.
 * 
 * @version 1.0
 */
public class Vehicle extends MutableObject {

	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 4991234326700512801L;

	protected String make;
	protected String model;
	protected String manufacturer;
	protected Engine engine;

	/**
	 * The constructor method for creating a Vehicle object with the attributes
	 * make, model, and manufacturer
	 */
	public Vehicle(String make, String model, String manufacturer) {
		setMake(make);
		setModel(model);
		setManufacturer(manufacturer);
	}

	/**
	 * The constructor method for creating a Vehicle object with the attributes
	 * make, model, manufacturer, and engine
	 */
	public Vehicle(String make, String model, String manufacturer, Engine engine) {
		this(make, model, manufacturer);
		setEngine(engine);
	}

	/* Get/Set methods for the defined fields in the Vehicle object */

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
