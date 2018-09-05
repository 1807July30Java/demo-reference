package com.revature.beans;

public class BearWithAutoByName extends Bear {
	
	//method identifier must match name of the dependency
	public void setCave(Cave c) {
		this.cave = c;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutoByName. this bear is: "+this.toString());
		System.out.println("cave: "+cave.toString());
	}

}
