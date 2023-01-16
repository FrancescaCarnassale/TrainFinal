package com.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import com.beans.Reservation;
import com.beans.Trip;
import com.beans.User;
import com.dao.ReservationDao;

public class ReservationDaoImpl extends BaseDao implements ReservationDao {

	

	@Override
	public void create(Reservation reservation) {
		super.create(reservation);
	}

	@Override
	public void setReservation(Trip trip, User user, int tickets) {
		Reservation reservation = new Reservation();
		reservation.setIdTrip(trip);
		reservation.setUsermail(user);
		reservation.setNumberTickets(tickets);
		this.create(reservation);
	}

	@Override
	public Collection<Reservation> getReservationsForTrip(Trip trip) {
		TypedQuery<Reservation> mq = getSession().createQuery("SELECT r FROM Reservation r WHERE r.idTrip = :idTrip", Reservation.class);
	    mq.setParameter("idTrip", trip.getIdTrip());
        List<Reservation> reservations = mq.getResultList();
        Collection<Reservation> c = reservations;
        return c;
	}

		

}
