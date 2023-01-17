package com.dao;

import java.util.Collection;

import com.beans.Alias;

public interface AliasDao {
	
	public void create(Alias a);
	public Alias get(String aliasCountry);
	public Collection<Alias> getUnapprovedAliases();
	public void approveAliasAndCancel(String[] approve, String[] cancel, String[] newCountries);
	public String getAliasCountry(String input);
}
