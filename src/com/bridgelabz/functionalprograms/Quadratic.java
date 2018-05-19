/******************************************************************************
 *  
 *  Purpose: to find the roots of the given quadratic equation
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   19-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Quadratic {

	public static void main(String[] args) {
		System.out.println("To find the roots of the quadratic equation a*x*x+b*x+c");
		System.out.println("Enter the value of a-");
		int a = Utility.integerInput();
		System.out.println("Enter the value of b:-");
		int b = Utility.integerInput();
		System.out.println("Enter the value of c:-");
		int c = Utility.integerInput();
		Utility.getRoots(a, b, c);
	}
}
