package com.dao.impl;

import com.beans.Trip;
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
		return (Trip) super.get(Trip.class, id);
	}

	@Override
	public void setTrip(Trip tr) {
		this.create(tr);
	}
	

	@Override
	public boolean updateSeats(Trip t, int bookedSeats) {
		Trip newTrip = new Trip();
        if(!checkSeats(t,bookedSeats)) {
            return false;
        }
        newTrip.setIdTrip(t.getIdTrip());
        newTrip.setIdTrain(t.getIdTrain());
        newTrip.setArrive(t.getArrive());
        newTrip.setDeparture(t.getDeparture());
        newTrip.setTimeArrive(t.getTimeArrive());
        newTrip.setTimeDeparture(t.getTimeDeparture());
        newTrip.setSeatsAvailable(t.getSeatsAvailable()-bookedSeats);
        super.update(newTrip);
        return true;
    }


	@Override
	public boolean checkSeats(Trip t, int bookedSeats) {
		return (t.getSeatsAvailable()-bookedSeats)>0;
	}
	

}
