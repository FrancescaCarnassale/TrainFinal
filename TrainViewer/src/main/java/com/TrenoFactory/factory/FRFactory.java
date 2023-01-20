package com.TrenoFactory.factory;

import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.vagone.FR.LocomotivaFR;
import com.TrenoFactory.vagone.FR.PasseggeriFR;
import com.TrenoFactory.vagone.FR.RistoranteFR;


/**
 * 
 *This class, used for apply the factory pattern in the creation wagons process.
 *This factory is specified for the FrecciaRossa brand
 *
 *
 */

public class FRFactory implements VagoneFactory {
	
	private int massimoPostiFR=500;
	
	/**
	 * There are two constructor for two use-cases. One for the seats setted by default and onther one for the seats setted by the user.
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
