package com.bridegelabz.objectorientedprograms;

import com.bridgelabz.utils.Utility;

public class RegularExpressionDemo {

	public static void main(String[] args) {
		String message = "Hello <<name>>,\n" + "We have your full name as <<full name>> in our system. Your contact number is 91­-XXXXXXXXXX. Please,let us know in case of any clarification.\n" + "Thank you\n" + "BridgeLabz\n" + "XX/XX/XXXX";
		Utility.messageReplace(message);
	}

}
