package com.manager.strategy;


import java.util.Collection;
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
import com.dao.UserDao;
import com.dao.impl.LeaderboardDaoImpl;
import com.dao.impl.TrainDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.AliasDaoImpl;
import com.dao.impl.CountryDaoImpl;
import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.algorithm.Contained;
import com.ChainResponsibility.algorithm.Contains;
import com.ChainResponsibility.algorithm.ContainsPartial;

import com.ChainResponsibility.algorithm.EqualsStandardCS;
import com.ChainResponsibility.algorithm.JaroDistance;
import com.ChainResponsibility.algorithm.Levenshtein;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.User;

/**
 * Strategy that manage all the data and calls from DB
 */

public class StrategyDB implements Strategy{
	static Session session = ConnectionToDB.getSession();
	private AliasDao aliasDao = new AliasDaoImpl();
	private TrainDao trainDao= new TrainDaoImpl();
	private CountryDao countryDao= new CountryDaoImpl();
	private LeaderboardDao leaderboardDao= new LeaderboardDaoImpl();
	private UserDao userDao= new UserDaoImpl();
	private static CheckChain checkStringSingleton;
	
	
	/**
	 * Gets a country from an alias in input
	 */
	public String getAliasCountry(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = session.createSQLQuery(query);
	    return q.getSingleResult();
	}	
	
	/**
	 * Returns the data map of the countries
	 */
	public Map<String,List<String>> dataMap() {
       return countryDao.dataMap();
    }
	
	
	/**
	 * Gets a set of country names
	 */
	@Override
	public Set<String> getCountryNames() {
		// TODO Auto-generated method stub
		return countryDao.dataMap().keySet();
	}

	/**
	 * Gets all the countries
	 */
	@Override
	public Collection<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

	/**
	 * Gets all the unapproved aliases
	 */
	@Override
	public Collection<Alias> getUnapprovedAliases() {
		return aliasDao.getUnapprovedAliases();
	}



	/**
	 * Gets the leadboard data
	 */
	@Override
	public Collection<Leaderboard> getGameData() {
		return leaderboardDao.getGameData();
	}


	/**
	 *  Gets all the builded trains
	 */
	@Override
	public Collection<Train> getAllTrains() {
		return trainDao.getAllTrains();
	}

	/**
	 *  gets the check chain method
	 */
	@Override
	public CheckChain getChain() {
		if (checkStringSingleton == null) {
			CheckChain cp = new ContainsPartial(); 
			CheckChain lev = new Levenshtein(2); lev.setNextChain(cp);
			CheckChain jd = new JaroDistance(0.75); jd.setNextChain(lev);
			CheckChain cd = new Contained(); cd.setNextChain(jd);
			CheckChain cs = new Contains(); cs.setNextChain(cd);
			CheckChain es = new EqualsStandardCS(); es.setNextChain(cs);
			es.setStrategy(this);
			checkStringSingleton = es;
        }
        return checkStringSingleton;
	}

	/**
	 *  recalls the approve and cancel alias
	 */
	@Override
	public void approveAndCancelAlias(String[] checkAlias, String[] checkDelete, String[] newCountry) {
		// TODO Auto-generated method stub
		aliasDao.approveAliasAndCancel(checkAlias, checkDelete, newCountry);
	}

	/**
	 * Gets list of users with specific role
	 */
	@Override
	public List<User> getUsersWithRole(String role) {
		return userDao.getUsersWithRole(role);
	}
	/**
	 * Updates list of users with the new specific role
	 */
	@Override
	public void updateUserRole(String[] email, String[] newRoles) {
		userDao.updateUsers(email, newRoles);
	}
	
	
}