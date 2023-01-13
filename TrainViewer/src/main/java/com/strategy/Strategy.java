package com.strategy;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.User.exceptions.UserNotFound;
import com.ChainResponsibility.CheckChain;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.User;

public interface Strategy {
	public String getAliasCountry(String alias);
	public Map<String,List<String>> dataMap();
	public Set<String> getCountryNames();
	public Collection<Country> getAllCountries();
	public Collection<Alias> getUnapprovedAliases();
	public void approveAlias(String[] list);
	public Collection<Leaderboard> getGameData();
	public void updateGameData(String[] list);
	public String getUser(String email, String password) throws UserNotFound;
	public void setUser(String name, String password, String email, String admin);
	public void setTrain(String brand, String serialNumber, boolean isCargo);
	public Collection<Train> getAllTrains();
	public CheckChain getChain();
	public void cancelAlias(String[] list);
}
