package com.beans;
/** The class Reservation refers to the table reservation in the DB.
 * It is used in the Database to serve the reservation of a ticket the user bought.
 * It saves the trip the user bought, the user itself and how many tickets were bought.
 */
public class Reservation implements Bean {
	private int idReservation;
	private Trip idTrip;
	private User user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User usermail) {
		this.user = usermail;
	}
	public int getNumberTickets() {
		return numberTickets;
	}
	public void setNumberTickets(int numberTickets) {
		this.numberTickets = numberTickets;
	}
	
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", usermail=" + user
				+ ", numberTickets=" + numberTickets + "]";
	}
		
	
	
	
	
	
	
}
