/******************************************************************************
 *  
 *  Purpose: to guess the number within the given range 
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class GuessGame {

	public static void main(String[] args) {
		int range = Integer.parseInt(args[0]);
		System.out.println("Think of a number in between 0 to " + range);
		System.out.println("Let's start the game......");
		Utility.getGuessNumber(range);
	}

}
