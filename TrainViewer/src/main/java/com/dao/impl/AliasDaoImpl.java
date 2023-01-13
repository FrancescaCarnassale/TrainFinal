package com.dao.impl;

import com.dao.AliasDao;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;

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
		
		TypedQuery<Alias > mq = getSession().createQuery("Select a From Alias a where a.approved = 0", Alias.class);
        Collection<Alias> a = mq.getResultList();
        return a;
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
}
