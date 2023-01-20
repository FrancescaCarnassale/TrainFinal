package com.TrenoFactory.exceptions;

public class TrenoException extends Exception {
	/**
	 * This is a superclass, that will be extendend by all exceptions related to trains
	 */
	private static final long serialVersionUID = 1L;
	public TrenoException(String sigla) {
		super("Errore nella costruzione del treno con sigla: " + sigla);
	}
	
}
