package com.dao;

import java.util.Collection;

import com.beans.Leaderboard;

public interface LeaderboardDao {
	public void create(Leaderboard a);
	public Leaderboard get(String leaderboard);
	public Collection<Leaderboard> getGameData();
	public void updateGameData(String[] list);
}
