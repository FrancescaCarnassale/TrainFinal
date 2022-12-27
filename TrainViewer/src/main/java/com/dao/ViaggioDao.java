package com.dao;

import com.beans.Viaggio;

public interface ViaggioDao {
	public void create(Viaggio t);
	public Viaggio get(String id);
	
}
