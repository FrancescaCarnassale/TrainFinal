package com.dao;

import com.beans.User;
import com.dao.impl.BaseDao;

//Aggiungi bean

public interface UserDao {
	
	public void create(User u);
	public User get(String userName);
}
