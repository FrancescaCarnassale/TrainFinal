package com.TrenoFactory.vagone.TN;

import com.TrenoFactory.treno.Locomotiva;
/**
 * 
 * This class represent the locomotive made by TreNord Factory
 *
 */
public class LocomotivaTN implements Locomotiva {
	
	private final int potenzaTN=1000;
	private final int pesoTN=100, pesoTrainabileTN=3000;
	

	@Override
	public int getPotenza() {
		// TODO Auto-generated method stub
		return potenzaTN;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return pesoTN;
	}

	@Override
	public int getPesoTrainabile() {
		// TODO Auto-generated method stub
		return pesoTrainabileTN;
	}

	@Override
	public String toString() {
		return "LocomotivaTN [potenzaTN=" + potenzaTN + ", pesoTN=" + pesoTN + ", pesoTrainabileTN=" + pesoTrainabileTN
				+ "]";
	}
	
	
}
