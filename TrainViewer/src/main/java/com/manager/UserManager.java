package com.manager;
import com.beans.Login;
import com.beans.User;
import com.dao.*;
import com.dao.impl.UserDaoImpl;

//Class used to create an user manager to manage comunication with dao
public class UserManager {
	UserDao userDao = new UserDaoImpl();
	public User getUser(Login login) {
		return userDao.getUser(login);
	}
	
	public void setUser(User newUser) {
		userDao.setUser(newUser);
	}
}
