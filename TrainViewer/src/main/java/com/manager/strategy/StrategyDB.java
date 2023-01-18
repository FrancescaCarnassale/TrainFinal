package com.manager.strategy;

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
	private TrainDao trainDao= new TrainDaoImpl();
	private CountryDao countryDao= new CountryDaoImpl();
	private LeaderboardDao leaderboardDao= new LeaderboardDaoImpl();
	private UserDao userDao= new UserDaoImpl();
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
	public Collection<Leaderboard> getGameData() {
		return leaderboardDao.getGameData();
	}


	


	@Override
	public Collection<Train> getAllTrains() {
		return trainDao.getAllTrains();
	}


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

	@Override
	public void approveAndCancelAlias(String[] checkAlias, String[] checkDelete, String[] newCountry) {
		// TODO Auto-generated method stub
		aliasDao.approveAliasAndCancel(checkAlias, checkDelete, newCountry);
	}

	@Override
	public List<User> getUsersWithRole(String role) {
		return userDao.getUsersWithRole(role);
	}

	@Override
	public void updateUserRole(String[] email, String[] newRoles) {
		userDao.updateUsers(email, newRoles);
	}
	@Override
    public void updateScore(Leaderboard leaderboardEntry) {
        // TODO Auto-generated method stub
        leaderboardDao.updateScore(leaderboardEntry);
    }
	@Override
    public Leaderboard getOldScore(User user) {
        return leaderboardDao.getOldScore(user);

    }
}