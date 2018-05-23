/******************************************************************************
 *  
 *  Purpose: to return the minimum number of notes for the change entered by the user
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class VendingMachine {

	public static void main(String[] args) {
		System.out.println("Enter the amount you want");
		int amount = Utility.integerInput();
		Utility.noOfNotes(amount,0);
	}

}
