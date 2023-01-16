package com.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import com.beans.Country;
import com.beans.Trip;
import com.dao.CountryDao;
import com.dao.TripDao;
import com.dao.impl.CountryDaoImpl;
import com.dao.impl.TrainDaoImpl;
import com.dao.impl.TripDaoImpl;

public class TripManager {
	private TripDaoImpl tripDao= new TripDaoImpl();
	public void setTrip(Trip trip) {
		tripDao.setTrip(trip);
	}
	public TripDao getTripDao() {
		return this.tripDao;
	}
	public Collection<Trip> getTripsWithDate(String departure, String arrive, Timestamp departureTime) {
        TypedQuery<Trip> mq = tripDao.getSession().createQuery("Select t from Trip t where t.departure = :departure and t.arrive = :arrive and t.timeDeparture > : timeDeparture", Trip.class); 
        CountryDaoImpl countryDao= new CountryDaoImpl();
        mq.setParameter("departure", countryDao.getSession().get(Country.class,departure));
        mq.setParameter("arrive", countryDao.getSession().get(Country.class,arrive));
        mq.setParameter("timeDeparture", departureTime);
        List<Trip> trips = mq.getResultList();
        Collection<Trip> c = trips;
        return c;
	}
}
