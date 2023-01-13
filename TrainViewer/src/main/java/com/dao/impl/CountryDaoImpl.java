package com.dao.impl;

import com.dao.CountryDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.NativeQuery;

import com.beans.Country;

public class CountryDaoImpl extends BaseDao implements CountryDao {
	public void create(Country c) {
		super.create(c);
	}

	@Override
	public Country get(String countryName) {
		return (Country) super.get(Country.class, countryName);
	}

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
		        temp.add((String) o[0]);
		        map.put((String) o[1], temp);            
	        }
	        return map;
	}

	@Override
	public Collection<Country> getAllCountries() {
		Collection<Country> cc = new LinkedList <Country>();
		NativeQuery<Object []> mq = getSession().createSQLQuery("Select * from country");
        List<Object[]> countries = mq.list();
        
		for (Object[] o: countries) {
			Country c = new Country();
			c.setCountryName((String) o[0]);
			c.setAlpha2code((String) o[1]);
			cc.add(c);
		}
		return cc;
	}
}
