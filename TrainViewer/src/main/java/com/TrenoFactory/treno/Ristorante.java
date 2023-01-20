package com.TrenoFactory.treno;

import java.util.List;

/**
 * 
 *Interface that give the methods useful for the Restaurant Wagons 
 *
 */

public interface Ristorante extends Carrozza{

	public int getNumeroTavoli();
	public int getMaxNumeroPersone();
	public List<String> getMenu();
	public int getPeso();
}
