package com.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.beans.Country;

//Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of Country

public interface CountryDao {
	public void create(Country c);
	public Country get(String countryName);
	public Map<String,List<String>> dataMap();
	public Collection<Country> getAllCountries();
}
