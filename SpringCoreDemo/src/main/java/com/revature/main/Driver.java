package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;
import com.revature.beans.BearWithAutoByName;
import com.revature.beans.BearWithAutoByType;
import com.revature.beans.BearWithConstructor;
import com.revature.beans.BearWithSetter;
import com.revature.beans.Cave;
import com.revature.beans.ComponentScannedBear;

public class Driver {

	public static void main(String[] args) {

		// allow us to access IoC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		//funWithCaves(ac);
		funWithBears(ac);
		
		
		String[] names = ac.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
		
		// close AC after we're done
		((AbstractApplicationContext) ac).close();
	}

	static void funWithCaves(ApplicationContext ac) {
		Cave c = (Cave) ac.getBean("cave");
		System.out.println(c.toString());
		
		Cave c2 = (Cave) ac.getBean("cave");
		System.out.println(c2.toString());
	}
	
	static void funWithBears(ApplicationContext ac) {
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();

		Bear b3 = (BearWithAutoByName) ac.getBean("autoBearByName");
		b3.methodInBear();
		
		Bear b4 = (BearWithAutoByType) ac.getBean("autoBearByType");
		b4.methodInBear();
		
		Bear b5 = (ComponentScannedBear) ac.getBean("componentScannedBear");
		b5.methodInBear();
		
		Bear b6 = (ComponentScannedBear) ac.getBean("componentScannedBear");
		b6.methodInBear();
		
	}

}
