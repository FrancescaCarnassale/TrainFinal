package com.TrenoFactory.exceptions;

public class NumeroPostiInEccesso extends TrenoException {

	private int postiTreno, postiTrenoMax, postiVagone;
	private String message;
	
	public NumeroPostiInEccesso(String sigla, int postiVagone, int postiTreno, int postiTrenoMax) {
		super(sigla);
		this.message = "Numero di posti " + postiTreno + " supera il limite " + postiTrenoMax;
		this.postiTreno = postiTreno;
		this.postiTrenoMax = postiTrenoMax;
		this.postiVagone = postiVagone;
		
	}
	
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}

}
