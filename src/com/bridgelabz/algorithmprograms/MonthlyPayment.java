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
		System.out.println(Utility.getMonthlyPayment(principle,year,rate) + "is needed to make over " +year+" years to pay off a args[0] " +principle+ "principal loan amount at " +rate+ " percent interest compounded monthly.");
	}

}
