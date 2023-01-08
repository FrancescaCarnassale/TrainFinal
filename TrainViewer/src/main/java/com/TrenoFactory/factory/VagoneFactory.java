package com.TrenoFactory.factory;

import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;

public interface VagoneFactory {
	
	public abstract Locomotiva getLocomotiva();
	public abstract Passeggeri getPasseggeri();
	public abstract Ristorante getRistorante();
	public abstract int getMassimoPosti();

}
