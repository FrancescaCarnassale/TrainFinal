package com.strategy;

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
import com.dao.AliasUnknownDao;
import com.dao.LeaderboardDao;
import com.dao.impl.LeaderboardDaoImpl;
import com.dao.impl.TrainDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.AliasDaoImpl;
import com.dao.impl.AliasUnknownDaoImpl;
import com.User.exceptions.UserNotFound;
import com.beans.Alias;
import com.beans.AliasUnknown;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.User;

public class StrategyDB implements Strategy{
	//WIP serve l'RMI
	static Session session = ConnectionToDB.getSession();
	private AliasUnknownDao unknownDao = new AliasUnknownDaoImpl();
	private AliasDaoImpl aliasDao = new AliasDaoImpl();
	private UserDaoImpl userDao = new UserDaoImpl();
	private LeaderboardDaoImpl LeaderboardDao = new LeaderboardDaoImpl();
	private TrainDaoImpl trainDao= new TrainDaoImpl();
	private Map<String,List<String>> dataMap;
	
	public String getAliasCountry(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = session.createSQLQuery(query);
	    return q.getSingleResult();
	}	

	
	public Map<String,List<String>> dataMap() {
        NativeQuery<String> q = session.createSQLQuery("Select country_name From country");
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: q.getResultList()) {
            map.put(s.toLowerCase(), new ArrayList<String>());
        }
        NativeQuery<Object []> mq = session.createSQLQuery("Select alias_country, country_name from alias");
        List<Object[]>  l =mq.list();
        System.out.println(l.size());
        for(Object[] o: l) { 
	        List<String> temp = map.get(((String)o[1]).toLowerCase());
	        temp.add((String) o[0]);
	        map.put((String) o[1], temp);            
        }
        dataMap=map;
        return map;
    }
	
	public void addAliasUnknown(String input) {
		AliasUnknown au = new AliasUnknown();
		au.setUnknown(input);
		unknownDao.create(au);
	}
	
	@Override
	public Set<String> getCountryNames() {
		// TODO Auto-generated method stub
		return dataMap.keySet();
	}


	@Override
	public Collection<Country> getAllCountries() {

		Collection<Country> cc = new LinkedList <Country>();
		NativeQuery<Object []> mq = session.createSQLQuery("Select * from country");
        List<Object[]> countries = mq.list();
        
		for (Object[] o: countries) {
			Country c = new Country();
			c.setCountryName((String) o[0]);
			c.setAlpha2code((String) o[1]);
			cc.add(c);
		}
		return cc;
	}


	@Override
	public Collection<Alias> getUnapprovedAliases() {
		Collection<Alias> ca = new LinkedList <Alias>();
		NativeQuery<Object []> mq = session.createSQLQuery("Select * from alias where approved = 0");
        List<Object[]> aliases = mq.list();
        
		for (Object[] o: aliases) {
			Alias a = new Alias();
			a.setAlias((String) o[0]);
			Country c = new Country();
			c.setCountryName((String) o[1]);
			a.setCountry(c);
			ca.add(a);
		}
		return ca;
	}


	@Override
	public void approveAlias(String[] list) {
		for(String s : list)
		{
			Alias a = aliasDao.get(s);
			a.setApproved(true);
			aliasDao.getSession().beginTransaction();
			aliasDao.getSession().update(a);
			aliasDao.getSession().getTransaction().commit();
		}
		aliasDao.getSession().close();
	}


	@Override
	public Collection<Leaderboard> getGameData() {
		Collection<Leaderboard> ca = new LinkedList <Leaderboard>();
		NativeQuery<Object []> mq = session.createSQLQuery("Select * from leaderboard ORDER BY user_score Desc");
        List<Object[]> scores = mq.list();
        
		for (Object[] o: scores) {
			Leaderboard a = new Leaderboard();
			a.setIdScore((int) o[2]);
			User u = new User();
			u.setName((String) o[1]);
			a.setUser(u);
			
			a.setScore((int) o[2]);
			
			ca.add(a);
		}
		return ca;
	}


	@Override
	public void updateGameData(String[] list) {
		// TODO Auto-generated method stub
		for(String s : list)
		{
			Leaderboard gs = LeaderboardDao.get(s);
			//a.setApproved(true);
			aliasDao.getSession().beginTransaction();
			aliasDao.getSession().update(gs);
			aliasDao.getSession().getTransaction().commit();
		}
		aliasDao.getSession().close();
	}


	@Override
	public void setUser(String name, String password, String email, boolean admin) {
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setAdmin(admin);
		userDao.create(u);
	}


	@Override
	public String getUser(String email, String password) throws UserNotFound {
		User u = new User();
		NativeQuery<Object []> mq = session.createSQLQuery("Select * from user_train where user_mail = :email and user_password = :password");
		mq.setParameter("email", email);
		mq.setParameter("password", password);
		try {
			Object[] o = (Object[]) mq.list().get(0);
			u.setEmail((String) o[0]);
			u.setName((String) o[1]);
			u.setPassword((String) o[2]);
			
		}catch(IndexOutOfBoundsException e){
			 return "L'utente inserito non è stato trovato!";
		}
		return u.getName();
	}


	@Override
	public void setTrain(String brand, String serialNumber) {
		// TODO Auto-generated method stub
		Train t = new Train();
		t.setBrand(brand);
		t.setSerialNumber(serialNumber);
		trainDao.create(t);
	}


	@Override
	public Collection<Train> getAllTrains() {
		Collection<Train> cc = new LinkedList <Train>();
		NativeQuery<Object []> mq = session.createSQLQuery("Select * from train");
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