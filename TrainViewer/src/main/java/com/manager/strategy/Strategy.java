package com.manager.strategy;

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
	public Collection<Leaderboard> getGameData();
	public void updateGameData(String[] list);
	public void approveAndCancelAlias(String[] checkAlias, String[] checkDelete, String[] newCountry);
	public Collection<Train> getAllTrains();
	public CheckChain getChain();
	public List<User> getUsersWithRole(String role);
	public void updateUserRole(String[] email, String[] newRoles);
}
