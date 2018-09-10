package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Flashcard;

@Repository
public interface FlashcardDao extends JpaRepository<Flashcard, Integer>{
	
	//two choices: CrudRepository (supertype) or JpaRepository
	// also PagingAndSortingRepository  or other subtypes 

}
