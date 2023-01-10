package com.dao;

import com.beans.Train;

public interface TrainDao {
	public void create(Train a);
	public Train get(String train);
}
