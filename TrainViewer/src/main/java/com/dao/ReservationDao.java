package com.dao;

import java.util.Collection;

import com.beans.Reservation;
import com.beans.Trip;
import com.beans.User;

public interface ReservationDao {
	public void setReservation(Trip trip, User user, int tickets);
	public void create(Reservation reservation);
	public Collection<Reservation> getReservationsForTrip(Trip trip);
}
