/******************************************************************************
 *  
 *  Purpose: to print the table of power of two
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class PowerTable {

	public static void main(String[] args) {
		int times = Integer.parseInt(args[0]);
		if(times<=31)
			Utility.powerOfTwo(times);

	}

}