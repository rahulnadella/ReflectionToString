package com.api.test.mutableObject;

import java.util.ArrayList;
import java.util.List;

import com.api.mutableObject.MutableObject;

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
