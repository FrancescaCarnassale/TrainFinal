package com.TrenoFactory.exceptions;

public class NumeroPostiInEccesso extends TrenoException {

	/**
	 * This exception is throwed when there are too much passengers wagons, checked out with the max seats the train can have 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public NumeroPostiInEccesso(String sigla, int postiVagone, int postiTreno, int postiTrenoMax) {
		super(sigla);
		this.message = "Numero di posti " + postiTreno + " supera il limite " + postiTrenoMax;
	}
	
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}

}
