package com.beans;
/** The class Leaderboard refers to the table leaderboard in the DB.
 * It's used in the project as an element of the Database that saves the score from the user
 * after he/she finishes playing the trainGame. It saves the user and the relative score.
 */
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
