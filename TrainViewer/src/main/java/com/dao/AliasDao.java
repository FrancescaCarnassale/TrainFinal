package com.dao;

import java.util.Collection;

import com.beans.Alias;

/**
 *  Pattern Dao used to isolate the application layer from the persistence layer and communicate with the database of Alias
 */
public interface AliasDao {
	
	public void create(Alias a);
	public Alias get(String aliasCountry);
	public Collection<Alias> getUnapprovedAliases();
	public void approveAliasAndCancel(String[] approve, String[] cancel, String[] newCountries);
	public String getAliasCountry(String input);
}
