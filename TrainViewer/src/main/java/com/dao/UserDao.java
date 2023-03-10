package com.dao;

import java.util.List;

import com.User.exceptions.UserNotFound;
import com.beans.Login;
import com.beans.User;

/**
 * Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of User
 */

public interface UserDao {
	public void create(User a);
	public User get(String user);
	public void setUser(User user);
	public User getUser(Login login) throws UserNotFound;
	public void updateRole(User user, String role);
	public List<User> getUsersWithRole(String role);
	public void updateUsers(String[] email, String[] cancel);
	
}
