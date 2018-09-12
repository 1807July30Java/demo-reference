package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.Flashcard;
import com.revature.repository.FlashcardRepository;

@Component
@WebService(endpointInterface="com.revature.soap.FlashcardService")
public class FlashcardServiceImpl implements FlashcardService {
	
	@Autowired
	FlashcardRepository fr;
	
	@Override
	public List<Flashcard> getAllFlashcards() {
		return fr.getFlashcards();
	}

	@Override
	public String addFlashcard(Flashcard flashcard) {
		return "added "+(fr.persistFlashcard(flashcard)).toString();
	}

}
