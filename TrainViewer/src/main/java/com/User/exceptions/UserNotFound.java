package com.User.exceptions;

public class UserNotFound extends IndexOutOfBoundsException {
	/**
	 * This exception is for explain that the user searched doesn't exists.
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public UserNotFound() {
		this.message ="L'utente inserito non è stato trovato!";
	}
	
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
	
}
