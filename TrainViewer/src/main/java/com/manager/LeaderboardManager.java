package com.manager;

import com.beans.Leaderboard;
import com.beans.User;
import com.dao.LeaderboardDao;
import com.dao.impl.LeaderboardDaoImpl;

public class LeaderboardManager {
	private LeaderboardDao leaderboardDao= new LeaderboardDaoImpl();
	/**
	 * Updates score
	 */

    public void updateScore(Leaderboard leaderboardEntry) {
        // TODO Auto-generated method stub
        leaderboardDao.updateScore(leaderboardEntry);
    }
	
	/**
	 * Retrieves old score
	 */
	
    public Leaderboard getOldScore(User user) {
        return leaderboardDao.getOldScore(user);

    }

	public void createScore(Leaderboard leaderboardEntry) {
		// TODO Auto-generated method stub
		 leaderboardDao.create(leaderboardEntry);
	}
}
