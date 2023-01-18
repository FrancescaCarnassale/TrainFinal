package com.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import com.beans.Login;
import com.beans.User;
import com.dao.UserDao;

/**
 * Class to manage user manipulation of User database table
 */
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

	/**
	 * Gets the user email and password for a login from database table
	 */
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

	@Override
	public void updateRole(User user, String role) {
		user.setRole(role);
		super.update(user);
		
	}
	/**
	 * Retrieves all the users with set role
	 */
	@Override
	public List<User> getUsersWithRole(String role) {
		TypedQuery<User > mq = getSession().createQuery("from User u where u.role = :role", User.class);
		mq.setParameter("role", role);
		return mq.getResultList();
	}
	
	
	/**
	 * Changes the user's role.
	 */
	@Override
	public void updateUsers(String[] email, String[] newRoles) {
		getSession().beginTransaction();
	    if(email!=null) {
		    for(int i=0;i<email.length;i++)
		    {
				User b =this.getSession().get(User.class, email[i]);
		        b.setRole(newRoles[i]);
		        getSession().update(b);
	    }
	    getSession().getTransaction().commit();
	    getSession().close();
	    }  		
	}
	
}
