package com.dao;

import com.User.exceptions.UserNotFound;
import com.beans.User;

public interface UserDao {
	public void create(User a);
	public User get(String user);
	public String getUser(String email, String password) throws UserNotFound;
	
}
