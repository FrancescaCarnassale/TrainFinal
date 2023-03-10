package com.manager.strategy;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.ChainResponsibility.CheckChain;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Leaderboard;
import com.beans.Train;
import com.beans.User;

/**
 * Strategy that manage the map data of country list from a file
 */

public class StrategyFile implements Strategy {
	
	private static Set<String> standards;

	@Override
	public String getAliasCountry(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Find the file in csv format. Add element to a map for every country in the list
	
	@Override
	public Map<String, List<String>> dataMap() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		try {
			Scanner sc= new Scanner (new File("./src/main/resources/dataset/data_csv.txt.csv"));
			sc.useDelimiter("\n");
			while(sc.hasNext()) {
				//System.out.println(sc.next());
				String current= sc.next();
				if (current.contains("\"")) {
					String[] dati=current.trim().replaceAll("\"", "").split(",");
					List<String> x= new ArrayList<String>();
					x.add(dati[2]);
					String concatenata= dati[1].concat(" ").concat(dati[0]);
					x.add(concatenata);
					map.put(dati[0], x);
				}
				else {
					String[] dati=current.trim().split(","); 
					List<String> x= new ArrayList<String>();
					x.add(dati[1]);
					map.put(dati[0], x);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setStandards(map.keySet());
		return map;
	}


	@Override
	public String toString() {
		String result = "";
		for(String paese: this.dataMap().keySet()) {
			result += "Paese: "+paese+
					"      Aliases: "+this.dataMap().get(paese).toString()+
					"\n";
		}
		return result;
	}
	public Set<String> getCountryNames() {
		return standards;
	}
	public static void setStandards(Set<String> standards) {
		StrategyFile.standards = standards;
	}
	@Override
	public Collection<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<Alias> getUnapprovedAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Leaderboard> getGameData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public Collection<Train> getAllTrains() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public CheckChain getChain() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void approveAndCancelAlias(String[] checkAlias, String[] checkDelete, String[] newCountry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsersWithRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateUserRole(String[] email, String[] newRoles) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateScore(Leaderboard leaderboardEntry) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Leaderboard getOldScore(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
