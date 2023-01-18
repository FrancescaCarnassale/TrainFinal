package com.dao.impl;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Train;
import com.beans.Trip;
import com.dao.TrainDao;
import com.dao.TripDao;

//Class to manage trip manipulation of Trip database table
public class TripDaoImpl extends BaseDao implements TripDao{

	@Override
	public void create(Trip t) {
		// TODO Auto-generated method stub
		super.create(t);
	}

	@Override
	public Trip get(int id) {
		// TODO Auto-generated method stub
		return (Trip) super.get(Trip.class, id);
	}
	//Method to create trip
	@Override
	public void setTrip(Trip tr) {
		this.create(tr);
	}
	
	//Method to update the number of seats of a trip from database talbe
	@Override
	public void updateSeats(Trip t, int bookedSeats) {
		Trip newTrip = new Trip();
		newTrip.setIdTrip(t.getIdTrip());
		newTrip.setIdTrain(t.getIdTrain());
		newTrip.setArrive(t.getArrive());
		newTrip.setDeparture(t.getDeparture());
		newTrip.setTimeArrive(t.getTimeArrive());
		newTrip.setTimeDeparture(t.getTimeDeparture());
		newTrip.setSeatsAvailable(t.getSeatsAvailable()-bookedSeats);
		super.update(newTrip);
	}
	

}
