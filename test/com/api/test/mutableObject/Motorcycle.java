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

/**
 * The {@class Motorcycle} is a specific type of {@link Vehicle}. This object
 * could have its own fields in the future.
 * 
 * @version 1.0
 */
public class Motorcycle extends Vehicle {

	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 1776719200371695802L;

	/**
	 * The constructor for creating an Motorcycle object with attributes
	 * associated to the Vehicle
	 */
	public Motorcycle(String make, String model, String manufacturer,
			Engine engine) {
		super(make, model, manufacturer, engine);
	}
}
