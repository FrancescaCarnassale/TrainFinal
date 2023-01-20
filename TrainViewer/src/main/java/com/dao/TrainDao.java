package com.dao;

import java.util.Collection;

import com.beans.Train;

/**
 * Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of Train
 */

public interface TrainDao {
	public void create(Train a);
	public Train get(int train);
	public void setTrain(Train train);

	public Collection<Train> getAllTrains();
}
