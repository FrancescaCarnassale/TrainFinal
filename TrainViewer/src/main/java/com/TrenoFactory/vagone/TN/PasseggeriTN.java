package com.TrenoFactory.vagone.TN;

import com.TrenoFactory.treno.Passeggeri;

/**
 * 
 * This class represent the passenger wagon made by TreNord Factory
 *
 */
public class PasseggeriTN implements Passeggeri{
	
	private final int numeroPostiTN = 100, postiDisabiliTN = 10, pesoTN = 250;

	@Override
	public int getNumeroPosti() {
		// TODO Auto-generated method stub
		return numeroPostiTN;
	}

	@Override
	public int getPostiDisabili() {
		// TODO Auto-generated method stub
		return postiDisabiliTN;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoTN;
	}

	@Override
	public String toString() {
		return "PasseggeriTN [numeroPostiTN=" + numeroPostiTN + ", postiDisabiliTN=" + postiDisabiliTN + ", pesoTN="
				+ pesoTN + "]";
	}

	

}
