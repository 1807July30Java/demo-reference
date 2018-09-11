package com.revature.beans;


import java.io.Serializable;

public class Flashcard implements Serializable {

	
	public Flashcard(int id, String question, String answer, Category category) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}
	
	public Flashcard(String question, String answer, Category category) {
		super();
		this.question = question;
		this.answer = answer;
		this.category = category;
	}

	public Flashcard() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897553647260794654L;

	private int id;

	private String question;
	
	private String answer;
	
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Category getCategory() {
		return this.category;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + ", category=" + category + "]";
	}


}
