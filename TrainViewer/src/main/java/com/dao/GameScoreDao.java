package com.dao;

import com.beans.GameScore;

public interface GameScoreDao {
	public void create(GameScore gs);
	public GameScore get(String gameScore);
}
