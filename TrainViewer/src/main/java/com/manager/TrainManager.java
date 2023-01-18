package com.manager;

import com.beans.Train;
import com.dao.TrainDao;
import com.dao.impl.TrainDaoImpl;

public class TrainManager {
	TrainDao trainDao = new TrainDaoImpl();
	public void setTrain(Train t) {
		trainDao.setTrain(t);
	}
}
