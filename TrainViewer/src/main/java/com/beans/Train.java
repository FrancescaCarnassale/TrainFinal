package com.beans;

public class Train implements Bean {
	String serialNumber;
	String brand;
	Country departure, arrive;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
