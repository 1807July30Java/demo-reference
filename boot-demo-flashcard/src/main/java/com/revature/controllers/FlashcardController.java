package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;
import com.revature.repositories.FlashcardDao;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(value="http://localhost:4200")
public class FlashcardController {
	
	@Autowired
	FlashcardDao fd;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hello world",HttpStatus.OK);
	}
	
	@GetMapping("/allFlashcards")
	public ResponseEntity<List<Flashcard>> getAllFlashcards(){
		return new ResponseEntity<>(fd.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/byCategory/{category}")
	public ResponseEntity<List<Flashcard>> getFlashcardsByCategory(@PathVariable int category){
		return new ResponseEntity<>(fd.getByCategory(new Category(category, null)), HttpStatus.OK);
	}
	
	@PostMapping("/addFlashcard")
	public ResponseEntity<String> addFlashcard(@RequestBody Flashcard flashcard) {

		ResponseEntity<String> resp = null;
		try {
			fd.save(flashcard);
			resp = new ResponseEntity<>("FLASHCARD CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE FLASHCARD", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
