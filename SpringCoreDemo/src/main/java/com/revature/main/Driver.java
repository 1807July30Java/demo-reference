package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Cave;

public class Driver {

	public static void main(String[] args) {

		// allow us to access IoC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		funWithCaves(ac);
		
		// close AC after we're done
		((AbstractApplicationContext) ac).close();
	}

	static void funWithCaves(ApplicationContext ac) {
		Cave c = (Cave) ac.getBean("cave");
		System.out.println(c.toString());
	}

}
