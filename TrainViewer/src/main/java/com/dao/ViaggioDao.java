package com.dao;

import com.beans.Trip;

public interface ViaggioDao {
	public void create(Trip t);
	public Trip get(String id);
	
}
