package com.dao.impl;

import com.dao.AliasDao;
import java.util.Collection;
import javax.persistence.TypedQuery;
import org.hibernate.query.NativeQuery;
import com.beans.Alias;
import com.beans.Country;

/**
 * Class to manage alias manipulation of Alias database table
 */
public class AliasDaoImpl extends BaseDao implements AliasDao {
	
	public void create(Alias a) {
		super.create(a);
	}

	@Override
	public Alias get(String aliasCountry) {
		return (Alias) super.get(Alias.class, aliasCountry);
	}
	
	/**
	 * Gets unapproved aliases from DB
	 */
	@Override
	public Collection<Alias> getUnapprovedAliases() {
	
		TypedQuery<Alias > mq = getSession().createQuery("Select a From Alias a where a.approved = 0", Alias.class);
        Collection<Alias> a = mq.getResultList();
        return a;
	}
	
	/**
	 * Updates the alias status or delete it from the alias DB
	 */
	@Override
	public void approveAliasAndCancel(String[] approve, String[] cancel, String[] newCountries) {
		    getSession().beginTransaction();
		    if(approve!=null) {
		    	//l'alias è stato approvato, viene salvato come alias
			    for(int i=0;i<approve.length;i++)
			    {
					Alias b =this.getSession().get(Alias.class, approve[i]);
			        b.setApproved(true);
			        b.setCountry(this.getSession().get(Country.class, newCountries[i]));
			        getSession().update(b);
			    }
		    }
		    if(cancel!=null) {
		    	//l'alias viene cancellato dal db
			    for(String s : cancel)
			    {
					Alias b =this.getSession().get(Alias.class, s);
			        getSession().delete(b);
			    }
		    }
		    getSession().getTransaction().commit();
		    getSession().close();
		    
	}
	
	/**
	 * Gets the country of respective input alias from DB
	 */
	@Override
	public String getAliasCountry(String input) {
	    String query = "select nome_paese from alias where alias_paese = " + input;
	    NativeQuery<String> q = getSession().createSQLQuery(query);
	    return q.getSingleResult();
	}


}
