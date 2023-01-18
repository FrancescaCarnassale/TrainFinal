package com.ChainResponsibility;

/**
 * 
 */
public abstract class CheckChainStandards extends CheckChain {
	
	/**
	 * Returns the string corresponding to the input using different algorithms.
	 * Returns null if nothing was found.
	 */
	public final String checkInternal(String input) {
		for (String standard : getStrategy().getCountryNames()) {
			if(compare(input, standard)) {
				return standard;
			}
		}
		return null;
	};
	/**
	 * 
	 * @param 
	 * 		input=word that has to be compared to the standard
	 * @param standard
	 * @return
	 * 		true-> words are comparable using the algorithm
	 * 		false->words aren't comparable
	 */
	protected abstract boolean compare(String input, String standard);
	
}
