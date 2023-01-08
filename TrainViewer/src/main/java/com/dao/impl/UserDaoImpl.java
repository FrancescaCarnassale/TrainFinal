package com.dao.impl;

import com.beans.User;
import com.dao.UserDao;

public class UserDaoImpl  extends BaseDao implements UserDao {

	@Override
	public void create(User u) {
		super.create(u);
		
	}
	
	@Override
	public User get(String userName) {
		return (User) super.get(User.class, userName);
	}



}
