/******************************************************************************
 *  
 *  Purpose: to print the harmonic value of Nth number
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Harmonic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the value of N to get Nth harmonic number:-");
		String n = Utility.input();
		int times = Integer.parseInt(n);
		System.out.println("Nth Harmonic number is " + Utility.harmonicValue(times));
		

	}

}
