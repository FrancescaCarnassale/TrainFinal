package com.strategy;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beans.Alias;
import com.beans.Country;
import com.beans.GameScore;
import com.beans.User;

public interface Strategy {
	public String getAliasCountry(String alias);
	public Map<String,List<String>> dataMap();
	public void addAliasUnknown(String input);
	public Set<String> getCountryNames();
	public Collection<Country> getAllCountries();
	public Collection<Alias> getUnapprovedAliases();
	public void approveAlias(String[] list);
	public Collection<GameScore> getGameData();
	public void updateGameData(String[] list);
	public User getUser(User user);
	public void setUser(String name, String password, String email);
	public void setTrain(String brand, String serialNumber);
}
