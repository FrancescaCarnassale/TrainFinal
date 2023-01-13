package com.dao;

import com.User.exceptions.UserNotFound;
import com.beans.Login;
import com.beans.User;

public interface UserDao {
	public void create(User a);
	public User get(String user);
	public void setUser(String name, String password, String email, String admin);
	public User getUser(Login login) throws UserNotFound;
	
}
