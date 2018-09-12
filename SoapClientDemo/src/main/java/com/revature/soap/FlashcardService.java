package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

import com.revature.domain.Flashcard;

@WebService
public interface FlashcardService {
	
	/*
	 * a contract (WSDL) will be generated based on this interface
	 * go to /Flashcard?wsdl to see the file
	 */

	public List<Flashcard> getAllFlashcards();
	
	public String addFlashcard(Flashcard flashcard);
}
