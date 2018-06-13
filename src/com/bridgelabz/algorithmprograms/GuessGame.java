package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class GuessGame {

	public static void main(String[] args) {
		int range = Integer.parseInt(args[0]);
		System.out.println("Think of a number between 0 to " + (range - 1));
		Utility.guessedNumber(0, range-1);
	}

}
