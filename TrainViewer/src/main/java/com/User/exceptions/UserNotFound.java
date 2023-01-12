package com.User.exceptions;

public class UserNotFound extends IndexOutOfBoundsException {
	private String message;
	public UserNotFound() {
		this.message ="L'utente inserito non è stato trovato!";
	}
	
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
	
}
