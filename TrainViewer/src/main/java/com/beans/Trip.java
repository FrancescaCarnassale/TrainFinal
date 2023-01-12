package com.beans;

import java.sql.Timestamp;
import java.util.List;
import com.TrenoFactory.treno.Carrozza;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Treno;
//L'oggetto treno è caratterizzato dalla sigla e dalla lista delle sue carrozze.
//Nel DB sarà presente assieme al tipo di Treno (TN o FR, che infatti decisono il creatore) e alla lista dei passeggeri.
	public class Trip implements Bean {
		private String idTrain;
		private String idTrip;
		private String departure;
		private String arrive;
		private Timestamp timeDeparture;
		private Timestamp timeArrive;
		//private List<Passeggeri> passeggeri;
		public String getIdTrain() {
			return idTrain;
		}
		public void setIdTrain(String idTrain) {
			this.idTrain = idTrain;
		}
		public String getIdTrip() {
			return idTrip;
		}
		public void setIdTrip(String idTrip) {
			this.idTrip = idTrip;
		}
		public String getDeparture() {
			return departure;
		}
		public void setDeparture(String departure) {
			this.departure = departure;
		}
		public String getArrive() {
			return arrive;
		}
		public void setArrive(String arrive) {
			this.arrive = arrive;
		}
		public Timestamp getTimeDeparture() {
			return timeDeparture;
		}
		public void setTimeDeparture(Timestamp timeDeparture) {
			this.timeDeparture = timeDeparture;
		}
		public Timestamp getTimeArrive() {
			return timeArrive;
		}
		public void setTimeArrive(Timestamp timeArrive) {
			this.timeArrive = timeArrive;
		}

	
	
	
}
