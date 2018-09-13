package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.Category;
import com.revature.domain.Flashcard;
import com.revature.exception.FlashcardException;
import com.revature.repository.FlashcardRepository;

@Component
@WebService(endpointInterface="com.revature.soap.FlashcardService")
public class FlashcardServiceImpl implements FlashcardService {
	
	@Autowired
	FlashcardRepository fr;
	
	@Override
	public List<Flashcard> getAllFlashcards() {
		ArrayList<Flashcard> fl = new ArrayList<Flashcard>();//fr.getFlashcards();
		fl.add(new Flashcard(4,"Question?","Answer",new Category(2, "meteorology")));
		return fl;
	}

	@Override
	public String addFlashcard(Flashcard flashcard) throws FlashcardException {
		if (flashcard.getAnswer() == null) {
			throw new FlashcardException();
		}
		return "added "+(fr.persistFlashcard(flashcard)).toString();
	}

}
