package com.dao.impl;


import com.beans.GameScore;
import com.dao.GameScoreDao;

public class GameScoreDaoImpl extends BaseDao implements GameScoreDao{


	public void create(GameScore gs) {
		super.create(gs);
	}

	@Override
	public GameScore get(String gameScore) {
		return (GameScore) super.get(GameScore.class, gameScore);
	}

}
