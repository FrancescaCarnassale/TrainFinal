package com.dao.impl;

import com.dao.AliasDao;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Country;

public class AliasDaoImpl extends BaseDao implements AliasDao {
	
	public void create(Alias a) {
		super.create(a);
	}

	@Override
	public Alias get(String aliasCountry) {
		return (Alias) super.get(Alias.class, aliasCountry);
	}
	
	@Override
	public Collection<Alias> getUnapprovedAliases() {
		Collection<Alias> ca = new LinkedList <Alias>();
		NativeQuery<Object []> mq = getSession().createSQLQuery("Select * from alias where approved = 0");
        List<Object[]> aliases = mq.list();
        
		for (Object[] o: aliases) {
			Alias a = new Alias();
			a.setAlias((String) o[0]);
			Country c = new Country();
			c.setCountryName((String) o[1]);
			a.setCountry(c);
			ca.add(a);
		}
		return ca;
	}
	
	@Override
	public void approveAlias(String[] list) {
		for(String s : list)
		{
			Alias a = this.get(s);
			a.setApproved(true);
			getSession().beginTransaction();
			getSession().update(a);
			getSession().getTransaction().commit();
		}
		getSession().close();
	}
	@Override
	public String getAliasCountry(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = getSession().createSQLQuery(query);
	    return q.getSingleResult();
	}

	@Override
	public void cancelAlias(String[] list) {
		// TODO Auto-generated method stub
		System.out.println("Ciao");
		for(String s : list)
		{
			Alias a = this.get(s);
			getSession().beginTransaction();
			getSession().delete(a);
			getSession().getTransaction().commit();
		}
		getSession().close();
	}
}
