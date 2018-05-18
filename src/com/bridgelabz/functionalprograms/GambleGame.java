/******************************************************************************
 *  
 *  Purpose: to get the win and loss percentage for the game
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class GambleGame {

	public static void main(String[] args) {
		System.out.println("Enter the stake:-");
		int stake = Utility.integerInput();
		System.out.println("Enter Goal:-");
		int goal = Utility.integerInput();
		System.out.println("Enter the number of times you want to bet:-");
		int noOfBets = Utility.integerInput();
		Utility.winLossPercentage(stake,goal,noOfBets);

	}

}
