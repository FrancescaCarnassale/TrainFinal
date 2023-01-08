package com.TrenoFactory.factory;

import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.vagone.FR.LocomotivaFR;
import com.TrenoFactory.vagone.FR.PasseggeriFR;
import com.TrenoFactory.vagone.FR.RistoranteFR;

public class FRFactory implements VagoneFactory {
	
	private int massimoPostiFR=500;
	
	/*
	 * SONO STATI USATI DUE COSTRUTTORI IN MODO DA AVERE UN CASO DI MASSIMO POSTI GIà DEFINITO E UNO DEFINIBILE DALL'UTENTE
	 */
	
	public FRFactory() {
	}

	public FRFactory(int massimoPostiFR) {
		this.massimoPostiFR = massimoPostiFR;
	}

	@Override
	public Locomotiva getLocomotiva() {
		return new LocomotivaFR();
	}


	@Override
	public Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return new PasseggeriFR();
	}

	@Override
	public Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return new RistoranteFR();
	}

	public int getMassimoPosti() {
		return this.massimoPostiFR;
	}


}
