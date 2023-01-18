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
	public void updateScore(Leaderboard leaderboardEntry) {
		this.create(leaderboardEntry);
	}

	@Override
	public Leaderboard getOldScore(User u) {
		TypedQuery<Leaderboard > mq = getSession().createQuery("from Leaderboard u where u.user.email = :email ", Leaderboard.class);
		mq.setParameter("email", u.getEmail());
		
		List<Leaderboard> ris = mq.getResultList();
		if (ris  != null && ris.size() > 0) 
			return ris.get(0);
		else
			return null;
		
	}
}
