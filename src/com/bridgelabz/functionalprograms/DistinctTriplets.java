/******************************************************************************
 *  
 *  Purpose: to print the distinct triplets which gives the sum zero
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class DistinctTriplets {

	public static void main(String[] args) {
		System.out.println("Enter the number of integers:-");
		int noOfElements = Utility.integerInput();
		Utility.getDistinctTriplets(noOfElements);

	}

}
