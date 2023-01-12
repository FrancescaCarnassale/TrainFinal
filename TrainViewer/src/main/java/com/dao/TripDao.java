package com.dao;

import java.sql.Timestamp;

import com.beans.Trip;

public interface TripDao {
	public void create(Trip t);
	public Trip get(int id);
	public void setTrip(int idTrain, String departure, String arrive, Timestamp timeDeparture, Timestamp timeArrive);
	
}
