package com.beans;

public class Leaderboard implements Bean {
    private int idScore;
	private  User user;
    private int score;
  
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getIdScore() {
		return idScore;
	}
	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}
}
