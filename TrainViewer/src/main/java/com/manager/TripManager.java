package com.manager;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import javax.persistence.TypedQuery;
import com.beans.Country;
import com.beans.Trip;
import com.dao.TripDao;
import com.dao.impl.CountryDaoImpl;
import com.dao.impl.TripDaoImpl;

/**
 * Class used to create a trip manager to manage comunication with dao

 */
public class TripManager {
	private TripDaoImpl tripDao= new TripDaoImpl();
	public void setTrip(Trip trip) {
		tripDao.setTrip(trip);
	}
	public TripDao getTripDao() {
		return this.tripDao;
	}
	/**
	 * Gets all trips with seats available that departure from the param departure, arrive at the param departure
	 * after the param departureTime.
	 * @param departure: Country name of departure
	 * @param arrive: Country name of arrival
	 * @param departureTime: Timestamp of the starting departureTime after which we retrieve the trips
	 * @return collection of Trips corresponding to the query.
	 */
	public Collection<Trip> getTripsWithDate(String departure, String arrive, Timestamp departureTime) {
        TypedQuery<Trip> mq = tripDao.getSession().createQuery("Select t from Trip t where t.departure = :departure and t.arrive = :arrive and t.timeDeparture > : timeDeparture and t.seatsAvailable > 0", Trip.class); 
        CountryDaoImpl countryDao= new CountryDaoImpl();
        mq.setParameter("departure", countryDao.getSession().get(Country.class,departure));
        mq.setParameter("arrive", countryDao.getSession().get(Country.class,arrive));
        mq.setParameter("timeDeparture", departureTime);
        List<Trip> trips = mq.getResultList();
        Collection<Trip> c = trips;
        return c;
	}
	
	public boolean updateSeats(Trip trip, int seatsTaken) {
		return tripDao.updateSeats(trip, seatsTaken);
	}
}
