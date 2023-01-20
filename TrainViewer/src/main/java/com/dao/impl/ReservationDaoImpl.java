package com.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import com.beans.Reservation;
import com.beans.Trip;
import com.beans.User;
import com.dao.ReservationDao;
import com.dao.TripDao;

/**
 * Class to manage reservation manipulation of Reservation DB
 */
public class ReservationDaoImpl extends BaseDao implements ReservationDao {

	

	@Override
	public void create(Reservation reservation) {
		super.create(reservation);
	}
	
	/**
	 * Creates a reservation of a trip for a user and a number of tickets from DB
	 */
	@Override
	public void setReservation(Trip trip, User user, int tickets) {
		TripDao tripDao = new TripDaoImpl();
		Reservation reservation = new Reservation();
		reservation.setIdTrip(trip);
		reservation.setUser(user);
		reservation.setNumberTickets(tickets);
		tripDao.updateSeats(trip, tickets);
		this.create(reservation);
	}
	
	/**
	 * Gets reservations from a trip from a DB
	 */
	@Override
	public Collection<Reservation> getReservationsForTrip(Trip trip) {
		
		TypedQuery<Reservation> mq = getSession().createQuery("SELECT r FROM Reservation r WHERE r.idTrip.idTrip = :idTrip", Reservation.class);
	    mq.setParameter("idTrip", trip.getIdTrip());
        List<Reservation> reservations = mq.getResultList();
        Collection<Reservation> c = reservations;
        return c;
	}

	/**
	 * Gets reservations from a user from a DB
	 */
	@Override
	public Collection<Reservation> getReservationsForUser(User user) {
		TypedQuery<Reservation> mq = getSession().createQuery("SELECT r FROM Reservation r WHERE r.usermail.email = :usermail", Reservation.class);
	    mq.setParameter("usermail", user.getEmail());
        List<Reservation> reservations = mq.getResultList();
        System.out.println("ho ottenuto la lista");
        Collection<Reservation> c = reservations;
        return c;
	}
	
	@Override
	public void deleteReservation(Reservation reservation) {
		super.delete(reservation);
	}
	

		

}
