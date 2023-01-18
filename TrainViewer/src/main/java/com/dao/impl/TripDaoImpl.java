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


public class TripDaoImpl extends BaseDao implements TripDao{

	@Override
	public void create(Trip t) {
		// TODO Auto-generated method stub
		super.create(t);
	}

	@Override
	public Trip get(int id) {
		// TODO Auto-generated method stub
		return (Trip) super.getSession().get(Trip.class, id);
	}

	@Override
	public void setTrip(Trip tr) {
		this.create(tr);
	}
	
	/** The function updates the number of seats when the user buys tickets 
	 * for the relative Trip. If the number of seats the user wish to buy is > 
	 * than the ones available, the function returns true. If not, returns false. **/
	@Override
	public boolean updateSeats(Trip t, int bookedSeats) {
		if(!checkSeats(t,bookedSeats)) {
			return false;
		}
		t.setSeatsAvailable(t.getSeatsAvailable()-bookedSeats);
		super.getSession().beginTransaction();
		super.getSession().update(t);
		super.getSession().getTransaction().commit();
		return true;
	}
	
	/** Checks that there are at least a number of seats available for booking. **/
	@Override
	public boolean checkSeats(Trip t, int bookedSeats) {
	    return  t.getSeatsAvailable()>=bookedSeats;
	  }
	

}
