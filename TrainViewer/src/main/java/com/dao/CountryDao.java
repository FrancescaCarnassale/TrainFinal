package com.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.beans.Country;

public interface CountryDao {
	public void create(Country c);
	public Country get(String countryName);
	public Map<String,List<String>> dataMap();
	public Collection<Country> getAllCountries();
}
