package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.beans.Category;
import com.revature.beans.Flashcard;

@RestController
public class FlashcardController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getFlashcards")
	@HystrixCommand(fallbackMethod="getFakeFlashcards")
	public ResponseEntity<? extends List<Flashcard>> getFlashcards(){
		ResponseEntity<? extends List<Flashcard>> response = null;
		//could also go through Zuul gateway!! 
		response = this.restTemplate.getForEntity("http://localhost:8087/api/allFlashcards", (Class<? extends List<Flashcard>>) ArrayList.class);
		return response;
	}
	
	public ResponseEntity<? extends List<Flashcard>> getFakeFlashcards() {
		List<Flashcard> dummyList = new ArrayList<>();
		Flashcard f = new Flashcard(3, "Where do you stand if you're cold?", "In the corner, it's 90 degrees.",
				new Category(2, "meteorology"));
		Flashcard f2 = new Flashcard(75, "How much wood could a woodchuck chuck?", "Can a woodchuck chuck wood?",
				new Category(2, "meteorology"));
		dummyList.add(f);
		dummyList.add(f2);
		return new ResponseEntity(dummyList, HttpStatus.OK);
	}


}
