package com.dao.impl;

import com.beans.User;
import com.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
	public void create(User a) {
		super.create(a);
	}

	@Override
	public User get(String user) {
		return (User) super.get(User.class, user);
	}
}
