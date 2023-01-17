package com.dao.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Train;
import com.dao.AliasDao;
import com.dao.TrainDao;

public class TrainDaoImpl extends BaseDao implements TrainDao {
	public void create(Train a) {
		super.create(a);
	}

	@Override
	public Train get(int train) {
		return (Train) super.get(Train.class, train);
	}

	@Override
	public void setTrain(String brand, String serialNumber, int seats, boolean isCargo) {
		Train t = new Train();
		t.setBrand(brand);
		t.setSerialNumber(serialNumber);
		t.setIsCargo(isCargo);
		t.setSeats(seats);
		this.create(t);
		
	}

	@Override
	public Collection<Train> getAllTrains() {
		Collection<Train> cc = new LinkedList <Train>();
		NativeQuery<Object []> mq = getSession().createSQLQuery("Select * from train");
        List<Object[]> trains = mq.list();
        
		for (Object[] o: trains) {
			Train c = new Train();
			c.setIdTrain((int) o[0]);
			c.setSerialNumber((String) o[1]);
			c.setBrand((String) o[2]);
			cc.add(c);
		}
		return cc;
	}
}
