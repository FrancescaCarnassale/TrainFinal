package com.beans;

public class Reservation implements Bean {
	private int idReservation;
	private Trip idTrip;
	private User usermail;
	private int numberTickets;
	
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public Trip getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(Trip idTrip) {
		this.idTrip = idTrip;
	}
	public User getUsermail() {
		return usermail;
	}
	public void setUsermail(User usermail) {
		this.usermail = usermail;
	}
	public int getNumberTickets() {
		return numberTickets;
	}
	public void setNumberTickets(int numberTickets) {
		this.numberTickets = numberTickets;
	}
	
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", idTrip=" + idTrip + ", usermail=" + usermail
				+ ", numberTickets=" + numberTickets + "]";
	}
		
	
	
	
	
	
	
}
