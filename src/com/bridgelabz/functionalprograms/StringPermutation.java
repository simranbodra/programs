/******************************************************************************
 *  
 *  Purpose: To print the permutation of the given String
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   19-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class StringPermutation {

	public static void main(String[] args) {
		System.out.println("Enter the String:-");
		String str = Utility.stringInput();
		Utility.permutationFinder(str);
	}

}
