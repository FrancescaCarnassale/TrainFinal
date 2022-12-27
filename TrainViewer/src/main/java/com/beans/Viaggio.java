package com.beans;

import java.util.List;
import com.TrenoFactory.treno.Carrozza;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Treno;
//L'oggetto treno è caratterizzato dalla sigla e dalla lista delle sue carrozze.
//Nel DB sarà presente assieme al tipo di Treno (TN o FR, che infatti decisono il creatore) e alla lista dei passeggeri.
public class Viaggio implements Bean {
	private Treno treno;
	private String id;
	private String partenza;
	private String arrivo;
	//private List<Passeggeri> passeggeri;
	public Treno getTreno() {
		return treno;
	}
	public void setTreno(Treno treno) {
		this.treno = treno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPartenza() {
		return partenza;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	public String getArrivo() {
		return arrivo;
	}
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}
	
	
	
	
	
}
