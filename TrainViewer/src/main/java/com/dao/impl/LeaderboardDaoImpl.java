package com.dao.impl;

import com.beans.Alias;
import com.beans.Leaderboard;
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
}
