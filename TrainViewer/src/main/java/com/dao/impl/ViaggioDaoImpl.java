package com.dao.impl;

import com.beans.Country;
import com.beans.Trip;
import com.dao.ViaggioDao;

public class ViaggioDaoImpl extends BaseDao implements ViaggioDao{

	@Override
	public void create(Trip t) {
		// TODO Auto-generated method stub
		super.create(t);
	}

	@Override
	public Trip get(String id) {
		// TODO Auto-generated method stub
		return (Trip) super.get(Trip.class, id);
	}

}
