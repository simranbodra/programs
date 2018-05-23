/******************************************************************************
 *  
 *  Purpose: To convert temperature from clecius to fahrenheit
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class TemperatureConversion {

	public static void main(String[] args) {
		System.out.println("Enter 1 to convert Fahrenheit to Celcius");
		System.out.println("Enter 2 to convert Celcuis to Fahrenheit");
		System.out.println("Enter choice:-");
		int choice = Utility.integerInput();
		Utility.convertTemperature(choice);
	}

}
