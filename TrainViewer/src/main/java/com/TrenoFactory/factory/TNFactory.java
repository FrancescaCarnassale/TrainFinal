package com.TrenoFactory.factory;

import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.vagone.TN.LocomotivaTN;
import com.TrenoFactory.vagone.TN.PasseggeriTN;
import com.TrenoFactory.vagone.TN.RistoranteTN;
/**
 * 
 *This class, used for apply the factory pattern in the creation wagons process.
 *This factory is specified for the TreNord brand
 *
 *
 */
public class TNFactory implements VagoneFactory {
	
private int massimoPostiTN=1000;
/**
 * There are two constructor for two use-cases. One for the seats setted by default and onther one for the seats setted by the user.
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
