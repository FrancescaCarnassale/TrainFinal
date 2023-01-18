package com.dao;

import java.util.Collection;

import com.beans.Leaderboard;
import com.beans.User;

public interface LeaderboardDao {
	public void create(Leaderboard a);
	public Leaderboard get(String leaderboard);
	public Collection<Leaderboard> getGameData();
	public void updateGameData(String[] list);
	public void updateScore(Leaderboard leaderboardEntry);
	public Leaderboard getOldScore(User u);
}
