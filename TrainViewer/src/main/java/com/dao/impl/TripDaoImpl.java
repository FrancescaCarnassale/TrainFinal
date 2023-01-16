package com.dao.impl;

import java.sql.Timestamp;

import com.beans.Country;
import com.beans.Train;
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

}
