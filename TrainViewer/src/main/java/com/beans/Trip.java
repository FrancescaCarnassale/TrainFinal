package com.beans;

public class Trip implements Bean {
	Train train;
	Country departure, arrive;
	
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
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
	
	
}
