package com.beans;

//è possibile fare interfaccia gameScore e GameScoreImpl

public class GameScore {
	private String username;
	private int score;
	
	public GameScore() {
	
	}
	public GameScore(String username, int score) {
		this.username = username;
		this.score = score;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
