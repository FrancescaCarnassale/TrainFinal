package com.dao.impl;

import com.beans.Trip;
import com.dao.TripDao;

/**
 * Class to manage trip manipulation of Trip DB
 * @author CARNASSALEF
 *
 */
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
	/** 
	 * The function updates the number of seats when the user buys tickets 
	 * for the relative Trip. If the number of seats the user wish to buy is > 
	 * than the ones available, the function returns true. If not, returns false. 
	 * **/
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
