/******************************************************************************
 *  
 *  Purpose: to print the Eculidean distance from given co-ordinates to (0,0)
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Distance {

	public static void main(String[] args) {
		double distance = Utility.getEuclideanDistance(args[0], args[1]);
		System.out.println("The Eculidean Distance from the given co-ordinates are " + distance);
	}

}
