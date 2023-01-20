package com.dao;

import java.util.Collection;

import com.beans.Leaderboard;
import com.beans.User;

/**
 * Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of Leadboard
 */

public interface LeaderboardDao {
	public void create(Leaderboard a);
	public Leaderboard get(String leaderboard);
	public Collection<Leaderboard> getGameData();
	
	public void updateScore(Leaderboard leaderboardEntry);
	public Leaderboard getOldScore(User u);
}
