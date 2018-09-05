package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks class as Spring bean
@Scope(value="prototype")
public class ComponentScannedBear extends Bear {
	
	@Autowired
	private Cave cave;
	
	@Override
	public Cave getCave() {
		return this.cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in ComponentScannedBear. this bear is: "+this.toString());
		System.out.println("cave: "+cave.toString());
	}
	
	public void defaultInit() {
		System.out.println("ComponentScannedBear custom init");
	}
}
