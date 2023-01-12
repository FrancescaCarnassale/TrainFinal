package com.dao;

import java.util.Collection;

import com.beans.Alias;

public interface AliasDao {
	
	public void create(Alias a);
	public Alias get(String aliasCountry);
	public Collection<Alias> getUnapprovedAliases();
	public void approveAlias(String[] list);
}
