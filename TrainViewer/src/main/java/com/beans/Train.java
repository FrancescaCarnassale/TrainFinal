package com.beans;

public class Train implements Bean {
	private int idTrain;
	private String serialNumber;
	private String brand;
	
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
	public int getId() {
		return idTrain;
	}
	
}
