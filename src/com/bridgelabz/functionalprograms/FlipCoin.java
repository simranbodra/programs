/******************************************************************************
 *  
 *  Purpose: TI flip a coin number of times and get the percentage of head and tail
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class FlipCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of time to flip coin:-");
		int noOfTimes = Utility.integerInput();
		Utility.flipCoinPercentage(noOfTimes);

	}

}
