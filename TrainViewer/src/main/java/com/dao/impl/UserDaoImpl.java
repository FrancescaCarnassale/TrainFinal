package com.dao.impl;

import org.hibernate.query.NativeQuery;

import com.User.exceptions.UserNotFound;
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
	public String getUser(String email, String password) throws UserNotFound {
		User u = new User();
		NativeQuery<Object []> mq = getSession().createSQLQuery("Select * from user_train where user_mail = :email and user_password = :password");
		mq.setParameter("email", email);
		mq.setParameter("password", password);
		try {
			Object[] o = (Object[]) mq.list().get(0);
			u.setEmail((String) o[0]);
			u.setName((String) o[1]);
			u.setPassword((String) o[2]);
			
		}catch(IndexOutOfBoundsException e){
			 return "L'utente inserito non è stato trovato!";
		}
		return u.getName();
	}
}
