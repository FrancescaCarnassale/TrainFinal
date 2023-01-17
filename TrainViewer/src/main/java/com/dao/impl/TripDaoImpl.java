package com.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Train;
import com.beans.Trip;
import com.dao.TrainDao;
import com.dao.TripDao;


public class TripDaoImpl extends BaseDao implements TripDao{

	@Override
	public void create(Trip t) {
		// TODO Auto-generated method stub
		super.create(t);
	}

	@Override
	public Trip get(int id) {
		// TODO Auto-generated method stub
		return (Trip) super.get(Trip.class, id);
	}

	@Override
	public void setTrip(int idTrain, String departure, String arrive, Timestamp timeDeparture, Timestamp timeArrive) {
		Trip tr= new Trip();
		TrainDao trainDao = new TrainDaoImpl();
		tr.setArrive(this.getSession().get(Country.class,arrive));
		tr.setDeparture(this.getSession().get(Country.class,departure));
		tr.setIdTrain(this.getSession().get(Train.class,idTrain));
		tr.setTimeArrive(timeArrive);
		tr.setTimeDeparture(timeDeparture);
		tr.setSeats_available(trainDao.get(idTrain).getSeats());
		this.create(tr);
	}
	
	@Override
	public Collection<Country> getArriveCountries() {
		Collection<Country> countryList = new ArrayList <Country>();
		NativeQuery<String> mq = getSession().createSQLQuery("Select arrive from trip");
        
		List<String> trips = mq.list();
		for (String o: trips) {
			Country country = new Country();
			country.setCountryName(o);
			countryList.add(country);
		}
		return countryList;
	}

	@Override
	public Collection<Country> getDepartureCountries() {
		Collection<Country> countryList = new ArrayList <Country>();
		NativeQuery<String> mq = getSession().createSQLQuery("Select departure from trip");
        List<String> trips = mq.list();
		for (String o: trips) {
			Country country = new Country();
			country.setCountryName(o);
			countryList.add(country);
		}
		
		return countryList;
	}

	@Override
	public Collection<Trip> getTrips(Country departure, Country arrive, Timestamp timeDeparture) {
		TrainDao trainDao = new TrainDaoImpl();
		Collection<Trip> trainList = new ArrayList <Trip>();
		TypedQuery<Trip> mq = getSession().createQuery("Select t from Trip t where t.departure = :departure and t.arrive = :arrive and t.timeDeparture > : timeDeparture", Trip.class);
	    mq.setParameter("departure", departure.getCountryName());
	    mq.setParameter("arrive", arrive.getCountryName());
	    mq.setParameter("timeDeparture", timeDeparture);
        List<Trip> trips = mq.getResultList();
        Collection<Trip> c = trips;
		return c;
	}

	@Override
	public void updateSeats(Trip t, int bookedSeats) {
		Trip newTrip = new Trip();
		newTrip.setIdTrip(t.getIdTrip());
		newTrip.setIdTrain(t.getIdTrain());
		newTrip.setArrive(t.getArrive());
		newTrip.setDeparture(t.getDeparture());
		newTrip.setTimeArrive(t.getTimeArrive());
		newTrip.setTimeDeparture(t.getTimeDeparture());
		newTrip.setSeats_available(t.getSeats_available()-bookedSeats);
		super.update(newTrip);
	}
	
	
	

}
