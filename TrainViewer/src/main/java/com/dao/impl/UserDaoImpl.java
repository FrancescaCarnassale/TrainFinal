package com.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.User.exceptions.UserNotFound;
import com.beans.Login;
import com.beans.Train;
import com.beans.User;
import com.dao.UserDao;

//Class to manage user manipulation of User database table
public class UserDaoImpl extends BaseDao implements UserDao {
	public void create(User a) {
		super.create(a);
	}

	@Override
	public User get(String user) {
		return (User) super.get(User.class, user);
	}
	public void setUser(User user) {
	
		this.create(user);
	}

	//Method to get the user email and password for a login from database table
	@Override
	public User getUser(Login login){
		TypedQuery<User > mq = getSession().createQuery("from User u where u.email = :email and u.password = :password", User.class);
		mq.setParameter("email", login.getEmail());
		mq.setParameter("password", login.getPassword());
		
		List<User> ris = mq.getResultList();
		if (ris  != null && ris.size() > 0) 
			return ris.get(0);
		else
			return null;
	}

}
