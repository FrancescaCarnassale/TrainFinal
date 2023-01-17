package com.dao;

import java.sql.Timestamp;
import java.util.Collection;

import com.beans.Country;
import com.beans.Trip;

public interface TripDao {
	public void create(Trip t);
	public Trip get(int id);
	public void setTrip(Trip Tr);
	public void updateSeats(Trip t, int bookedSeats);

}
