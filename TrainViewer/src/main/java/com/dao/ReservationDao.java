package com.dao;

import java.util.Collection;

import com.beans.Reservation;
import com.beans.Trip;
import com.beans.User;

//Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of Reservation

public interface ReservationDao {
	public void setReservation(Trip trip, User user, int tickets);
	public void create(Reservation reservation);
	public Collection<Reservation> getReservationsForTrip(Trip idTrip);
	public Collection<Reservation> getReservationsForUser(User user);
	public void deleteReservation(Reservation reservation);
}
