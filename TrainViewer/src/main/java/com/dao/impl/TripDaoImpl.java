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
	public void setTrip(int idTrain, String departure, String arrive, Timestamp timeDeparture, Timestamp timeArrive) {
		Trip tr= new Trip();
		tr.setArrive((Country)super.get(Country.class,arrive));
		tr.setDeparture((Country)super.get(Country.class,departure));
		tr.setIdTrain((Train)super.get(Train.class,idTrain));
		tr.setTimeArrive(timeArrive);
		tr.setTimeDeparture(timeDeparture);
		this.create(tr);
	}

}
