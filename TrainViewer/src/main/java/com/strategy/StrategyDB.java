package com.strategy;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import com.connectionDB.ConnectionToDB;
import com.dao.AliasDao;
import com.dao.CountryDao;
import com.dao.LeaderboardDao;
import com.dao.TrainDao;
import com.dao.TripDao;
import com.dao.UserDao;
import com.dao.impl.LeaderboardDaoImpl;
import com.dao.impl.TrainDaoImpl;
import com.dao.impl.TripDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.AliasDaoImpl;
import com.User.exceptions.UserNotFound;
import com.dao.impl.CountryDaoImpl;
import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.algorithm.Contained;
import com.ChainResponsibility.algorithm.Contains;
import com.ChainResponsibility.algorithm.ContainsPartial;
import com.ChainResponsibility.algorithm.EqualsInputCS;
import com.ChainResponsibility.algorithm.EqualsStandardCS;
import com.ChainResponsibility.algorithm.JaroDistance;
import com.ChainResponsibility.algorithm.Levenshtein;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.Trip;
import com.beans.User;

public class StrategyDB implements Strategy{
	//WIP serve l'RMI
	static Session session = ConnectionToDB.getSession();
	private AliasDao aliasDao = new AliasDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private LeaderboardDao LeaderboardDao = new LeaderboardDaoImpl();
	private TrainDao trainDao= new TrainDaoImpl();
	private TripDao tripDao= new TripDaoImpl();
	private CountryDao countryDao= new CountryDaoImpl();
	private LeaderboardDao leaderboardDao= new LeaderboardDaoImpl();
	private static CheckChain checkStringSingleton;
	
	public String getAliasCountry(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = session.createSQLQuery(query);
	    return q.getSingleResult();
	}	
	
	public Map<String,List<String>> dataMap() {
       return countryDao.dataMap();
    }
	
	
	@Override
	public Set<String> getCountryNames() {
		// TODO Auto-generated method stub
		return countryDao.dataMap().keySet();
	}


	@Override
	public Collection<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}


	@Override
	public Collection<Alias> getUnapprovedAliases() {
		return aliasDao.getUnapprovedAliases();
	}


	@Override
	public void approveAlias(String[] list) {
		aliasDao.approveAlias(list);
	}


	@Override
	public Collection<Leaderboard> getGameData() {
		return leaderboardDao.getGameData();
	}


	@Override
	public void updateGameData(String[] list) {
		leaderboardDao.updateGameData(list);
	}


	@Override
	public void setUser(String name, String password, String email, String admin) {
		userDao.setUser(name, password, email, admin);
	}


	@Override
	public String getUser(String email, String password) throws UserNotFound {
		return userDao.getUser(email, password);
	}


	@Override
	public void setTrain(String brand, String serialNumber, boolean isCargo) {
		// TODO Auto-generated method stub
		trainDao.setTrain(brand, serialNumber, isCargo);
	}


	@Override
	public Collection<Train> getAllTrains() {
		return trainDao.getAllTrains();
	}


	@Override
	public CheckChain getChain() {
		if (checkStringSingleton == null) {
			CheckChain es = new EqualsStandardCS();
			CheckChain cd = new Contained(); cd.setNextChain(es);
			CheckChain cs = new Contains(); cs.setNextChain(cd);
			CheckChain cp = new ContainsPartial(); cp.setNextChain(cs);
			CheckChain lev = new Levenshtein(2); lev.setNextChain(cp);
			CheckChain jd = new JaroDistance(0.8); jd.setNextChain(lev);
			CheckChain ei = new EqualsInputCS(); ei.setNextChain(jd);
			ei.setStrategy(this);
			checkStringSingleton = ei;
        }
        return checkStringSingleton;
	}


	public void setTrip(int idTrain, String departure, String arrive, Timestamp timeDeparture, Timestamp timeArrive) {
		tripDao.setTrip(idTrain, departure, arrive, timeDeparture, timeArrive);
	}

	@Override
	public Collection<Trip> getTrips(Country departure, Country arrive, Timestamp timeDeparture) {
		return tripDao.getTrips(departure, arrive, timeDeparture);
	}

	@Override
	public Collection<Country> getAllDepartures() {
		return tripDao.getDepartureCountries();
	}

	@Override
	public Collection<Country> getAllArrives() {
		return tripDao.getArriveCountries();
	}
	
	
	
}