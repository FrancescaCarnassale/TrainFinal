package com.strategy;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.User;

public interface Strategy {
	public String getAliasCountry(String alias);
	public Map<String,List<String>> dataMap();
	public void addAliasUnknown(String input);
	public Set<String> getCountryNames();
	public Collection<Country> getAllCountries();
	public Collection<Alias> getUnapprovedAliases();
	public void approveAlias(String[] list);
	public Collection<Leaderboard> getGameData();
	public void updateGameData(String[] list);
	public String getUser(String email, String password);
	public void setUser(String name, String password, String email, boolean admin);
	public void setTrain(String brand, String serialNumber);
	public Collection<Train> getAllTrains();
}
