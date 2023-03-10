package com.dao.impl;

import com.dao.CountryDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;

import com.beans.Country;

/**
 * Class to manage country manipulation of Country DB
 */
public class CountryDaoImpl extends BaseDao implements CountryDao {
	public void create(Country c) {
		super.create(c);
	}

	@Override
	public Country get(String countryName) {
		return (Country) super.get(Country.class, countryName);
	}
	/**
	 * Gets all the countries in the list and set it in a Map from DB
	 */
	@Override
	public Map<String, List<String>> dataMap() {
		 	NativeQuery<String> q = getSession().createSQLQuery("Select country_name From country");
	        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	        for (String s: q.getResultList()) {
	            map.put(s.toLowerCase(), new ArrayList<String>());
	        }
	        NativeQuery<Object []> mq = getSession().createSQLQuery("Select alias_country, country_name from alias where approved=1");
	        List<Object[]>  l =mq.list();
	        System.out.println(l.size());
	        for(Object[] o: l) { 
		        List<String> temp = map.get(((String)o[1]).toLowerCase());
		        temp.add(((String) o[0]).toLowerCase());
		        map.put((String) o[1], temp);            
	        }
	        return map;
	}
	
	/**
	 * Gets all the countries in a collection from DB
	 */
	@Override
	public Collection<Country> getAllCountries() {
		
		TypedQuery<Country > mq = getSession().createQuery("Select country From Country country", Country.class);
        Collection<Country> countries = mq.getResultList();
        return countries;
		
	}

}
