package com.dao.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Leaderboard;
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
	public void setTrain(Train t) {
		this.create(t);
		
	}

	@Override
	public Collection<Train> getAllTrains() {
		TypedQuery<Train > mq = getSession().createQuery("Select t From Train t", Train.class);
        Collection<Train> t = mq.getResultList();
        return t;
	}

}
