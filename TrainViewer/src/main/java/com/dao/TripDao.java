package com.dao;

import com.beans.Trip;

public interface TripDao {
	public void create(Trip t);
	public Trip get(int id);
	public void setTrip(Trip Tr);
	public boolean updateSeats(Trip t, int bookedSeats);
	public boolean checkSeats(Trip t, int bookedSeats);


}
