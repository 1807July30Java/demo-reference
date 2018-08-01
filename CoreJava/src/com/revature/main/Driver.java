package com.revature.main;

//just saves us typing!! 
import com.revature.oop.*; //imports all classes in com.revature.oop package

public class Driver {

	public static void main(String[] args) {

		//life without imports: 
		//com.revature.oop.Truckski t = new com.revature.oop.Truckski();
		
		//life with imports:
		Truckski t = new Truckski();
		
		System.out.println(t.toString());
		
		t.setYearMade(1997);
		
		System.out.println(t.toString());
		
		t.go();
		
		t.turnLeft();
		
		t.turnRight();
		
		ChargingRhino cr = new ChargingRhino();
		
		cr.go();
		
		
	}

}
