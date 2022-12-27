package com.TrenoFactory.factory;

import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.vagone.TN.LocomotivaTN;
import com.TrenoFactory.vagone.TN.PasseggeriTN;
import com.TrenoFactory.vagone.TN.RistoranteTN;

public class TNFactory implements VagoneFactory {
	
private int massimoPostiTN=1000;
	/*
	 * SONO STATI USATI DUE COSTRUTTORI IN MODO DA AVERE UN CASO DI MASSIMO POSTI GIà DEFINITO E UNO DEFINIBILE DALL'UTENTE
	 */
	public TNFactory() {
	}

	public TNFactory(int massimoPosti) {
		this.massimoPostiTN = massimoPosti;
	}


	@Override
	public Locomotiva getLocomotiva() {
		return new LocomotivaTN();
	}

	@Override
	public Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return new PasseggeriTN();
	}

	@Override
	public Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return new RistoranteTN();
	}
	
	public int getMassimoPosti() {
		return this.massimoPostiTN;
	}
	
	

}
