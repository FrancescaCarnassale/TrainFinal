package com.dao.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Leaderboard;
import com.beans.User;
import com.dao.AliasDao;
import com.dao.LeaderboardDao;

public class LeaderboardDaoImpl extends BaseDao implements LeaderboardDao{
	public void create(Leaderboard a) {
		super.create(a);
	}

	@Override
	public Leaderboard get(String leaderboard) {
		return (Leaderboard) super.get(Leaderboard.class, leaderboard);
	}
	
	@Override
	public Collection<Leaderboard> getGameData() {
		Collection<Leaderboard> ca = new LinkedList <Leaderboard>();
		NativeQuery<Object []> mq = getSession().createSQLQuery("Select * from leaderboard ORDER BY user_score Desc");
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
			Leaderboard gs = this.get(s);
			//a.setApproved(true);
			getSession().beginTransaction();
			getSession().update(gs);
			getSession().getTransaction().commit();
		}
		getSession().close();
	}
}
