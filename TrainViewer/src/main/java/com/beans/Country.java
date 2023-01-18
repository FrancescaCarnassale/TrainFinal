package com.beans;
/** The class Country refers to the table country in the DB.
 * It's used for every known word at the start.
 * Every country is defined by its name and alpha2code.
 * The list of the countries was found at:
 */
public class Country implements Bean {
	private String countryName;
	private String alpha2code;
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getAlpha2code() {
		return alpha2code;
	}

	public void setAlpha2code(String alpha2code) {
		this.alpha2code = alpha2code;
	}

	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", alpha2code=" + alpha2code + "]";
	}
	
	
}
