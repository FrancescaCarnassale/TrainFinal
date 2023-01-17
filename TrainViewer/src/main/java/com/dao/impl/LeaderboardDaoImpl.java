package com.dao.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Country;
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
	
		TypedQuery<Leaderboard > mq = getSession().createQuery("Select l From Leaderboard l ORDER BY l.score Desc", Leaderboard.class);
        Collection<Leaderboard> ld = mq.getResultList();
        return ld;
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
