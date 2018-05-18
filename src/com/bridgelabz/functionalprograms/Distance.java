package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Distance {

	public static void main(String[] args) {
		double distance = Utility.getEculideanDistance(args[0], args[1]);
		System.out.println("The Eculidean Distance from the given co-ordinates are " + distance);
	}

}
