package com.beans;
/** The class Alias refers to the table alias in the DB.
 * It is used to provide new Countries. 
 * If a train is created using an arrival/departure that isn't found to be connected to a Country 
 * using the CheckChain, the arrival/departure is saved as an Alias.
 * If approved by the admin, the alias becomes a new word that can be used to refer to the relative Country.
 * example: arrival=RPC -> CheckChain fails -> data saved as Alias with approved=0 and country=null ->
 * admin sets country=China and approved=1 -> RPC is now a new recognizable word and will return China!**/
public class Alias implements Bean {
	private String alias;
	private Country country;
	private boolean approved;

	public boolean isApproved() {
		return approved;
	}
	
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String aliasCountry) {
		this.alias = aliasCountry;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
}
