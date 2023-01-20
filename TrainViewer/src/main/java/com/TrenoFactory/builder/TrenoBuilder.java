package com.TrenoFactory.builder;

import java.util.ArrayList;
import java.util.List;
import com.TrenoFactory.exceptions.NumeroPostiInEccesso;
import com.TrenoFactory.treno.Carrozza;
import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.treno.Treno;

/**
 * The class follow the builder pattern
 *
 */

public abstract class TrenoBuilder {
	
	/**
	 * @param String sigla, describe all the elements of the train.
	 * 
	 * The string can be any, entered by user and is to be checked: 
		String checks: 
		1- Overhead locomotive is mandatory
		2- Maximum of one dining car
		3- Must have at least two elements
		4- a maximum limit to the seat capacity for the overall train
		5- if it is two locomotives the other must be in the rear
		6- cargo and passengers never together (incompatible cars)
		7- restaurant and cargo never together (incompatible cars)
		8- nonexistent carriage or unsuitable character
		9- train must be able to start weightTrainable weight > train weight
	 * @throws NumeroPostiInEccesso if there are too many Passengers Wagons
	 * @return the train object builded from the input
		
	 */

	public final Treno buildTreno(String sigla) throws NumeroPostiInEccesso {
		int ristoranti=0;
		int passeggeri=0;
		int teste=1;
		int maxPersone=0;
		
		
		maxPersone = getMassimoPosti();
		
		
		if (sigla==null)
			throw new NullPointerException("Stringa nulla!"); //null element
		
		if (sigla.length()<2)
			throw new IllegalArgumentException("Troppi pochi componenti!"); //3- Must have at least two elements
		
		if (!sigla.startsWith("H"))
			throw new IllegalArgumentException("Manca la locomotiva all'inizio!"); //1- Overhead locomotive is mandatory
		
		for(int i=1;i<sigla.length();i++) {
			switch(sigla.charAt(i)){
				case 'H':
					if(i!=sigla.length()-1)
						throw new IllegalArgumentException("Troppe locomotive!"); //5- if it is two locomotives the other must be in the rear
					
					teste++;
					break;
				case 'R':
					ristoranti++;
					break;
				case 'P':
					passeggeri++;
					break;
				default:
					throw new IllegalArgumentException("Carattere non idoneo!"); //8- nonexistent carriage or unsuitable character
					
			}
		}
		if(ristoranti>1)
			throw new IllegalArgumentException("Troppi ristoranti!"); //2- Maximum of one dining car
		int postiTreno=0;
		
		if(postiTreno>maxPersone)
			throw new IllegalArgumentException("Troppi passeggeri!"); //4- a maximum limit to the seat capacity for the overall train
		
		
		//After all checks, the train will be created

		List<Carrozza> lista = new ArrayList<Carrozza>();
		lista.add(getLocomotiva());
		
		if(ristoranti==1)
			lista.add(getRistorante());
		if(teste>1)
			lista.add(getLocomotiva());
		
		int numPosti = 0;
		int postiVagone = 0;
		
		for(int i=0;i<passeggeri;i++) {
			Passeggeri p = getPasseggeri();
			numPosti = numPosti+p.getNumeroPosti();
			lista.add(p);
		}
		
		if(numPosti >= getMassimoPosti())
			throw new NumeroPostiInEccesso(sigla, postiVagone, numPosti, getMassimoPosti()); //4- a maximum limit to the seat capacity for the overall train
		
		int pesoTotale=0;
		
		for(Carrozza c : lista)
			pesoTotale+=c.getPeso();
		
		pesoTotale+=getLocomotiva().getPeso();
		
		if(pesoTotale>getLocomotiva().getPesoTrainabile())
			throw new IllegalArgumentException("Peso eccessivo!"); //9- train must be able to start weightTrainable weight > train weight
		
		Treno t = new Treno(sigla, lista, numPosti);
		return t;
	}
	
	

	protected abstract Passeggeri getPasseggeri();

	protected abstract Ristorante getRistorante();

	protected abstract int getMassimoPosti();

	public abstract Locomotiva getLocomotiva();
	
	

	
}
