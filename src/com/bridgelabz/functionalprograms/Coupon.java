/******************************************************************************
 *  
 *  Purpose: to generate a coupon number with the given number of digits
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Coupon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of coupon number to be generated:-");
		int noOfCoupons = Integer.parseInt(Utility.input());
		Utility.couponGenerator(noOfCoupons);

	}

}
