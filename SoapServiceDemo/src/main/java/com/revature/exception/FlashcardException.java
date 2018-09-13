package com.revature.exception;

public class FlashcardException extends Exception {

	public FlashcardException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public FlashcardException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public FlashcardException(String message) {
		super(message);
	}

	public FlashcardException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FlashcardException() {
		// TODO Auto-generated constructor stub
	}
	
	private String message = "not a valid flashcard";

}
