package com.dao;

import com.beans.Trip;

public interface TripDao {
	public void create(Trip t);
	public Trip get(int id);
	
}
