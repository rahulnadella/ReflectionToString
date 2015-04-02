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

import java.util.ArrayList;
import java.util.List;

import com.api.mutableObject.MutableObject;

/**
 * The {@class Factory} implements a Plain Old Java Object (POJO) for holding
 * the Set of Vehicle objects for testing purposes.
 * 
 * @version 1.0
 */
public class Factory extends MutableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7385426426613723490L;

	protected List<Vehicle> vehicles;

	/* Get/Set methods for the defined fields in the BMWFactory object */

	public List<Vehicle> getVehicles() {
		if (vehicles.isEmpty()) {
			vehicles = new ArrayList<Vehicle>();
		}

		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
