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

public class UserDaoImpl extends BaseDao implements UserDao {
	public void create(User a) {
		super.create(a);
	}

	@Override
	public User get(String user) {
		return (User) super.get(User.class, user);
	}

	@Override
	public void setUser(String name, String password, String email, String admin) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		u.setAdmin(admin);
		this.create(u);
	}

	@Override
	public User getUser(Login login){
		//User u = getSession().get(User.class, login.getEmail());
		//controllare la pwd
		//User u = null;
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
