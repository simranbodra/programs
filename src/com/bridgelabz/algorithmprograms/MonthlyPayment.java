/******************************************************************************
 *  
 *  Purpose: To get the monthly payment needed to pay off the loan amount
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class MonthlyPayment {

	public static void main(String[] args) {
		double principle = Double.parseDouble(args[0]);
		int year = Integer.parseInt(args[1]);
		double rate = Double.parseDouble(args[2]);
		System.out.println("Monthly payment of " + Utility.getMonthlyPayment(principle,year,rate) + " rs is needed ");
	}

}
