package com.manager;

import com.beans.Train;
import com.dao.TrainDao;
import com.dao.impl.TrainDaoImpl;

//Class used to create a train manager to manage comunication with dao
public class TrainManager {
	TrainDao trainDao = new TrainDaoImpl();
	public void setTrain(Train t) {
	
		trainDao.setTrain(t);
	}
}
