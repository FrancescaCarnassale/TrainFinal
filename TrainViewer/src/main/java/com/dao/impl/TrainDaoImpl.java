package com.dao.impl;

import com.beans.Alias;
import com.beans.Train;
import com.dao.AliasDao;
import com.dao.TrainDao;

public class TrainDaoImpl extends BaseDao implements TrainDao {
	public void create(Train a) {
		super.create(a);
	}

	@Override
	public Train get(String train) {
		return (Train) super.get(Train.class, train);
	}
}
