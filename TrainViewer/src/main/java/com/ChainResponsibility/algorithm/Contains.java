package com.ChainResponsibility.algorithm;

import com.ChainResponsibility.CheckChainStandards;

public class Contains extends CheckChainStandards {
	/**
	 * Checks if the input contains the standard.
	 */
	@Override
	protected boolean compare(String input, String standard) {
		return input.contains(standard);
	}

}
