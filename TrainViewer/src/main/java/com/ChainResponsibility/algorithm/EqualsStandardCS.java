package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class EqualsStandardCS extends CheckChainStandards{
	/**
	 * Checks if the words are equal on a String level.
	 */
	@Override
	protected boolean compare(String input, String standard) {
		return input.equals(standard);
	}

}
