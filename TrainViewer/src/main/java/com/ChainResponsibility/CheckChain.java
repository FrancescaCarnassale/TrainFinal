package com.ChainResponsibility;

import com.manager.strategy.Strategy;
/** The class CheckChain is used to create the final chain that will be used as a word-finder in the project.
 * Its use is to find the most-similar word to the one inserted by the user using different algorithms.
 * Every chain is composed of multiple chains that are connected through the nextChain field. 
 * If an algorithm can't find the corresponding Country, it goes to the next chain (and next algorithm). 
 *  **/
public abstract class CheckChain {
	private CheckChain nextChain;
	private static Strategy strategy;
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	
	/**
	 * Finds the string closer to the input
	 * @param input
	 * 		The word we are trying to connect to a Country
	 * @return 
	 * 		String corresponding to the result found by the checkInternal(input). null if nothing was found
	 */
	public final String check(String input) {
		String result = checkInternal(input);
		if(result != null) {
			return result;
		}
		//non ho trovato la soluzione, procedo col successivo se c'è
		if (nextChain!= null)
			return this.nextChain.check(input);
		else {
        	return null;
			}
		}
	/**
	 * Returns the result of the singular algorithm.
	 * @param 
	 * 		String input
	 * @return
	 * 		the closest string to the input using the algorithm. null if nothing was found.
	 */
	protected abstract String checkInternal(String input);
	
	
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		CheckChain.strategy = strategy;
	}
	
}
