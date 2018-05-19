/******************************************************************************
 *  
 *  Purpose: To print the elapsed time
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   19-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class ElapsedTime {

	public static void main(String[] args) {
		System.out.println("Enter 1 to choose start the timer");
		int start = Utility.integerInput();
		long startTime = Utility.startTimer(start);
		System.out.println("Enter 2 to stop the timer");
		int stop = Utility.integerInput();
		Utility.stopTimer(stop,startTime);
	}

}
