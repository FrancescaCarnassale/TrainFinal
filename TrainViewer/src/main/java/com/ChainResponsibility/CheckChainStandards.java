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
		input=input.toLowerCase();
		for (String standard : getStrategy().dataMap().keySet()) {
			standard=standard.toLowerCase();
			if(compare(input, standard)) {
				return standard;
			}
			if(getStrategy().dataMap().get(standard)!= null){
				for(String aliases: getStrategy().dataMap().get(standard)) {
					if(compare(input, aliases)) {
						return standard;
					}
				}
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
