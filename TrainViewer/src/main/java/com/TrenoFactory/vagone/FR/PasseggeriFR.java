package com.TrenoFactory.vagone.FR;

import com.TrenoFactory.treno.Passeggeri;

/**
 * 
 * This class represent the passenger wagon made by FrecciaRossa Factory
 *
 */

public class PasseggeriFR implements Passeggeri{
	
	private final int numeroPostiFR = 100, postiDisabiliFR = 10, pesoFR = 250;

	@Override
	public int getNumeroPosti() {
		// TODO Auto-generated method stub
		return numeroPostiFR;
	}

	@Override
	public int getPostiDisabili() {
		// TODO Auto-generated method stub
		return postiDisabiliFR;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoFR;
	}

	@Override
	public String toString() {
		return "PasseggeriFR [numeroPostiFR=" + numeroPostiFR + ", postiDisabiliFR=" + postiDisabiliFR + ", pesoFR="
				+ pesoFR + "]";
	}

	

}
