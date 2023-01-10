package com.dao;

import com.beans.User;

public interface UserDao {
	public void create(User a);
	public User get(String user);
}
