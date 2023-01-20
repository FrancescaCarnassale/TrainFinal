package com.TrenoFactory.builder;

import com.TrenoFactory.factory.VagoneFactory;
import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;

/**
 * 
 * As requested by the builder pattern, there is a concrete builder that extend the main builder, that use the factory for create trains
 *
 */

public class ConcreteBuilder extends TrenoBuilder{
	private VagoneFactory factory;
	
	public ConcreteBuilder(VagoneFactory vagoneFactory) {
		this.factory = vagoneFactory;
	}

	@Override
	public Locomotiva getLocomotiva() {
		// TODO Auto-generated method stub
		return factory.getLocomotiva();

	}

	@Override
	protected Passeggeri getPasseggeri() {
		// TODO Auto-generated method stub
		return factory.getPasseggeri();
	}

	@Override
	protected Ristorante getRistorante() {
		// TODO Auto-generated method stub
		return factory.getRistorante();
	}

	@Override
	protected int getMassimoPosti() {
		// TODO Auto-generated method stub
		return factory.getMassimoPosti();
	}

		
	
	 
}
