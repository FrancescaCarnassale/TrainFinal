package com.TrenoFactory.builder;

import java.util.ArrayList;
import java.util.List;
import com.TrenoFactory.exceptions.NumeroPostiInEccesso;
import com.TrenoFactory.treno.Carrozza;
import com.TrenoFactory.treno.Locomotiva;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Ristorante;
import com.TrenoFactory.treno.Treno;


public abstract class TrenoBuilder {
	
	/**
	 * La stringa può essere qualsiasi, inserita da utente ed è da controllare: 
		Controlli sulla stringa: 
		1- La locomotiva in testa è obbligatoria
		2- massimo un vagone ristorante
		3- Deve avere almeno due elementi
		4- un limite massimo alla capienza dei posti per il treno complessivo
		5- se sono due locomotive l’altra deve essere in coda
		6- cargo e passeggeri mai insieme (vagoni incompatibili)
		7- ristorante e cargo mai insieme (vagoni incompatibili)
		8- vagone inesistente o carattere non idoneo
		9- il treno deve poter partire pesoTrainabile > peso del treno
	 * @throws NumeroPostiInEccesso 
		
	 */

	public final Treno buildTreno(String sigla) throws NumeroPostiInEccesso {
		int ristoranti=0;
		int passeggeri=0;
		int teste=1;
		int maxPersone=0;
		/*if(vagoneFactory instanceof FRFactory) { 
			FRFactory concreteFactory = (FRFactory) vagoneFactory;
			maxPersone=concreteFactory.getMassimoPosti();
		}
		if(vagoneFactory instanceof TNFactory) { 
			TNFactory concreteFactory = (TNFactory) vagoneFactory;
			maxPersone=concreteFactory.getMassimoPosti();
		}*/
		
		maxPersone = getMassimoPosti();
		
		
		if (sigla==null)
			throw new NullPointerException("Stringa nulla!");
		if (sigla.length()<2)
			throw new IllegalArgumentException("Troppi pochi componenti!");
		if (!sigla.startsWith("H"))
			throw new IllegalArgumentException("Manca la locomotiva all'inizio!");
		for(int i=1;i<sigla.length();i++) {
			switch(sigla.charAt(i)){
				case 'H':
					if(i!=sigla.length()-1)
						throw new IllegalArgumentException("Troppe locomotive!");
					teste++;
					break;
				case 'R':
					ristoranti++;
					break;
				case 'P':
					passeggeri++;
					break;
				default:
					throw new IllegalArgumentException("Carattere non idoneo!");
					
			}
		}
		if(ristoranti>1)
			throw new IllegalArgumentException("Troppi ristoranti!");
		int postiTreno=0;
		
		if(postiTreno>maxPersone)
			throw new IllegalArgumentException("Troppi passeggeri!");
		
		
		//Creazione treno

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
		if(numPosti >= getMassimoPosti()) { 
			throw new NumeroPostiInEccesso(sigla, postiVagone, numPosti, getMassimoPosti());
		}
		int pesoTotale=0;
		for(Carrozza c : lista) {
			pesoTotale+=c.getPeso();
		}
		pesoTotale+=getLocomotiva().getPeso();
		if(pesoTotale>getLocomotiva().getPesoTrainabile())
			throw new IllegalArgumentException("Peso eccessivo!");
		Treno t = new Treno(sigla, lista);
		return t;
	}
	
	

	protected abstract Passeggeri getPasseggeri();

	protected abstract Ristorante getRistorante();

	protected abstract int getMassimoPosti();

	public abstract Locomotiva getLocomotiva();
	
	

	
}
