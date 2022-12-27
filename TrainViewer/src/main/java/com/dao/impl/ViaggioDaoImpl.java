package com.dao.impl;

import com.beans.Country;
import com.beans.Viaggio;
import com.dao.ViaggioDao;

public class ViaggioDaoImpl extends BaseDao implements ViaggioDao{

	@Override
	public void create(Viaggio t) {
		// TODO Auto-generated method stub
		super.create(t);
	}

	@Override
	public Viaggio get(String id) {
		// TODO Auto-generated method stub
		return (Viaggio) super.get(Viaggio.class, id);
	}

}
