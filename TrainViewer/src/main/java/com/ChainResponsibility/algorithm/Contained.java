package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class Contained extends CheckChainStandards{
	/**
	 * Checks if the standard contains the input.
	 */
	@Override
	protected boolean compare(String input, String standard) {
		return standard.contains(input);
	}

}
