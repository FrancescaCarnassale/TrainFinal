package com.dao.impl;

import java.util.Collection;
import javax.persistence.TypedQuery;
import com.beans.Train;
import com.dao.TrainDao;

/**
 * Class to manage train manipulation of Train DB
 */
public class TrainDaoImpl extends BaseDao implements TrainDao {
	public void create(Train a) {
		super.create(a);
	}

	@Override
	public Train get(int train) {
		return (Train) super.get(Train.class, train);
	}

	@Override
	public void setTrain(Train t) {
		this.create(t);
		
	}
	/**
	 * Retrieves all the trains from DB
	 */
	@Override
	public Collection<Train> getAllTrains() {
		TypedQuery<Train > mq = getSession().createQuery("Select t From Train t", Train.class);
        Collection<Train> t = mq.getResultList();
        return t;
	}

}
