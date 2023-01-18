package com.manager;
import com.beans.Login;
import com.beans.User;
import com.dao.*;
import com.dao.impl.UserDaoImpl;
public class UserManager {
	UserDao userDao = new UserDaoImpl();
	public User getUser(Login login) {
		return userDao.getUser(login);
	}
	public User getUserFromEmail(String email) {
		return userDao.get(email);
	}
	
	public void setUser(User newUser) {
		userDao.setUser(newUser);
	}
	
	public void updateRole(User user, String role) {
		userDao.updateRole(user, role);
	}
}
