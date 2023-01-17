package com.beans;

public class Train implements Bean {
	private int idTrain;
    private String serialNumber;
    private String brand;
    private int seats;
    private boolean isCargo;

    public boolean getIsCargo() {
		return isCargo;
	}
    public void setIsCargo(boolean isCargo) {
		this.isCargo = isCargo;
	}
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
    public int getIdTrain() {
        return idTrain;
    }
    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
