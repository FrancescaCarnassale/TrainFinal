package com.beans;

import java.sql.Timestamp;
import java.util.List;
import com.TrenoFactory.treno.Carrozza;
import com.TrenoFactory.treno.Passeggeri;
import com.TrenoFactory.treno.Treno;
//L'oggetto treno è caratterizzato dalla sigla e dalla lista delle sue carrozze.
//Nel DB sarà presente assieme al tipo di Treno (TN o FR, che infatti decisono il creatore) e alla lista dei passeggeri.
	public class Trip implements Bean {
		private int idTrip;
		private Train idTrain;
		private Country departure;
		private Country arrive;
		private Timestamp timeDeparture;
		private Timestamp timeArrive;
		private int seatsAvailable;

		public int getIdTrip() {
			return idTrip;
		}
		public void setIdTrip(int idTrip) {
			this.idTrip = idTrip;
		}
		public Train getIdTrain() {
			return idTrain;
		}
		public void setIdTrain(Train idTrain) {
			this.idTrain = idTrain;
		}
		public Country getDeparture() {
			return departure;
		}
		public void setDeparture(Country departure) {
			this.departure = departure;
		}
		public Country getArrive() {
			return arrive;
		}
		public void setArrive(Country arrive) {
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
		@Override
		public String toString() {
			return "Trip [idTrip=" + idTrip + ", idTrain=" + idTrain + ", departure=" + departure + ", arrive=" + arrive
					+ ", timeDeparture=" + timeDeparture + ", timeArrive=" + timeArrive + "]";
		}
		public int getSeatsAvailable() {
			return seatsAvailable;
		}
		public void setSeatsAvailable(int seatsAvailable) {
			this.seatsAvailable = seatsAvailable;
		}

		
	
	
	
}
