package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Flashcard;

@Component("flashcardClient")
public class FlashcardClient {

	@Autowired
	private RestTemplate restTemplate;
	
	private String resourceUrl;
	
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	// call our RESTful Flashcard service (boot-demo-flashcard)
	// .exchange give us fine-grained control over request being sent
	public List<Flashcard> getFlashcards() {
		ResponseEntity<List<Flashcard>> response = this.restTemplate.exchange(this.resourceUrl+"/allFlashcards",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Flashcard>>() {});
		return response.getBody();
	}
	
	// add a Flashcard through the RESTful service's POST method, return response text
	public String addFlashcard(Flashcard flashcard) {
		//TODO
		return "";
	}

}
