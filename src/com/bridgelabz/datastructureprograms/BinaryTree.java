package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utils.Utility;

public class BinaryTree {

	public static void main(String[] args) {
		System.out.println("Enter the number of elements to be stored:-");
		int noOfNodes = Utility.integerInput();
		System.out.println("Number of possible binary trees " + Utility.getNoOfPossibleBinaryTrees(noOfNodes));
	}

}
