package com.TrenoFactory.treno;

import java.util.List;

/**
 * 
 *	This object represent the Train, with its serial_number and its wagons list. In the DB will be save also the brand 
 *
 */
public class Treno {
	private String sigla;
	private List<Carrozza> carrozze;
	private int numPosti;
	
	public Treno(String sigla, List<Carrozza> carrozze, int numPosti) {
		this.sigla = sigla;
		this.carrozze = carrozze;
		this.numPosti=numPosti;
	}
	
	
	public int getNumPosti() {
		return numPosti;
	}


	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	

	public String getSigla() {
		return sigla;
	}


	public List<Carrozza> getCarrozze() {
		return carrozze;
	}


	@Override
	public String toString() {
		return "Treno sigla=" + sigla + ",\ncarrozze=" + carrozze ;
	}
	
	
	
	
}
