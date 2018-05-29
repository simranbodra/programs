package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utils.Utility;

public class BalancedParenthesis {

	public static void main(String[] args) {
		boolean result = false;
		System.out.println("Enter the Arithmatic Expression:-");
		String expression = Utility.stringInput();
		result = Utility.addParenthesisToStack(expression);
		if(result)
			System.out.println("expression is balanced");
		else 
			System.out.println("expression is not balanced");
	}

}
