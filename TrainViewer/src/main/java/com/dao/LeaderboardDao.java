package com.dao;

import com.beans.Leaderboard;

public interface LeaderboardDao {
	public void create(Leaderboard a);
	public Leaderboard get(String leaderboard);
}
