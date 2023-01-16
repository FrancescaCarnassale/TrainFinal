package com.dao;

import java.sql.Timestamp;
import java.util.Collection;

import com.beans.Country;
import com.beans.Trip;

public interface TripDao {
	public void create(Trip t);
	public Trip get(int id);
	public void setTrip(int idTrain, String departure, String arrive, Timestamp timeDeparture, Timestamp timeArrive);
	public Collection<Trip> getTrips(Country departure, Country arrive, Timestamp timeDeparture);
	public Collection<Country> getArriveCountries();
	public Collection<Country> getDepartureCountries();

}
