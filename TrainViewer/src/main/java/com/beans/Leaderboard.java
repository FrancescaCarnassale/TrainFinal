package com.beans;

public class Leaderboard implements Bean {
	private int idScore;
    private  User username;
    private int score;
    public User getUsername() {
        return username;
    }
    public void setUsername(User username) {
        this.username = username;
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

}
