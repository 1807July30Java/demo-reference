package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.domain.Flashcard;
import com.revature.soap.FlashcardService;

public class Driver {

	public static void main(String[] args) {
		
		FlashcardService fs = getFlashcardService();
		//retrieve flashcards
		List<Flashcard> cards = fs.getAllFlashcards();
		for (Flashcard f : cards) {
			System.out.println(f);
		}
		
	}
	
	static FlashcardService getFlashcardService() {
		
		String serviceUrl = "http://localhost:8084/SoapServiceDemo/Flashcard";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(FlashcardService.class);
		factory.setAddress(serviceUrl);
		
		//set up interceptors
		LoggingInInterceptor inInt = new LoggingInInterceptor();
		LoggingOutInterceptor outInt = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInt);
		factory.getOutInterceptors().add(outInt);
		inInt.setPrintWriter(new PrintWriter(System.out));
		outInt.setPrintWriter(new PrintWriter(System.out));
		
		return (FlashcardService) factory.create();
	}

}
