package com.TrenoFactory.treno;

import java.util.List;
//L'oggetto treno è caratterizzato dalla sigla e dalla lista delle sue carrozze.
//Nel DB sarà presente assieme al tipo di Treno (TN o FR, che infatti decisono il creatore) e alla lista dei passeggeri.
public class Treno {
	private String sigla;
	private List<Carrozza> carrozze;
	private int numPosti;
	
	
	public int getNumPosti() {
		return numPosti;
	}


	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}


	public Treno(String sigla, List<Carrozza> carrozze, int numPosti) {
		this.sigla = sigla;
		this.carrozze = carrozze;
		this.numPosti=numPosti;
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
