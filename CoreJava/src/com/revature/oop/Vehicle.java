package com.revature.oop;

public abstract class Vehicle {

	// instance field, will be inherited by subtypes
	protected int yearMade;

	public Vehicle(int yearMade) {
		super();
		this.yearMade = yearMade;
	}

	public abstract void go();

	public Vehicle() {
		super();
	}

	public int getYearMade() {
		return yearMade;
	}

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	@Override
	public String toString() {
		return "Vehicle [yearMade=" + yearMade + "]";
	}

}
