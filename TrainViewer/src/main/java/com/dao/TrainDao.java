package com.dao;

import java.util.Collection;

import com.beans.Train;

public interface TrainDao {
	public void create(Train a);
	public Train get(int train);
	public void setTrain(Train train);

	public Collection<Train> getAllTrains();
}
