/******************************************************************************
 *  
 *  Purpose: to check whether the given year is leap year or not 
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the year to check whether leap year or not:- ");
		int year = Utility.integerInput();
		Utility.leapYearChecker(year);
		

	}

}
