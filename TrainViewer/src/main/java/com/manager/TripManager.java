package com.manager;

import java.sql.Timestamp;

import com.beans.Trip;
import com.dao.TripDao;
import com.dao.impl.TripDaoImpl;

public class TripManager {
	private TripDao tripDao= new TripDaoImpl();
	public void setTrip(Trip trip) {
		tripDao.setTrip(trip);
	}
	public TripDao getTripDao() {
		return this.tripDao;
	}
}
