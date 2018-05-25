/******************************************************************************
 *  
 *  Purpose: contains all methods
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.utils;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.time.LocalTime;

public class Utility {

	/*
	 * Static Variable is declared to create static object of Scanner class
	 */
	static Scanner scanner = new Scanner(System.in);

	/****************************************************************************************
	 * Function to take String input from the user
	 ****************************************************************************************/
	public static String stringInput() {
		String n = scanner.nextLine();
		return n;
	}
	
	/*************************************************************************************
	 * Function to take valid integer input from the user
	 **************************************************************************************/
	public static int integerInput()
	{
		try
		{
			int number = scanner.nextInt();
			return number;
		}
		catch(Exception e)
		{
			scanner.nextLine();
			System.out.println("Invalid input, enter again");
			return integerInput();
		}
	}

	/**************************************************************************************
	 * Function to take replace the template
	 * 
	 * @param string username which contains the username entered by the user
	 * @return String containing replaced template with proper name
	 ***************************************************************************************/
	public static String replaceTemplate(String username) {
		String template = "Hello <<username>>, How are you?";
		// to ensure username has minimum 3 characters
		if (username.length() >= 3) {
			template = template.replace("<<username>>", username);
		} else
			System.out.println("invalid input");
		return template;

	}

	/*******************************************************************************************
	 * Function to get the percentage of head and tail after flipping coin given
	 * number of times
	 * 
	 * @param noOfTimes the coin to be flipped 
	 *******************************************************************************************/
	public static void flipCoinPercentage(int noOfTimes) {
		int head = 0, tail = 0;
		for (int i = 1; i <= noOfTimes; i++) {
			if (Math.random() < 0.5)
				tail++;
			else
				head++;
		}
		System.out.println("Percentage of head after flipping coin " + noOfTimes + " = " + (head * 100) / noOfTimes);
		System.out.println("Percentage of tail after flipping coin " + noOfTimes + " = " + (tail * 100) / noOfTimes);
	}

	/*************************************************************************
	 * Function to check the given year is leap year or not
	 * 
	 * @param integer year to store the year to be checked
	 *************************************************************************/
	public static void leapYearChecker(int year) {
		int count=0;
		int validYear = year;
		while (validYear>0) {
			validYear = validYear/10;
			count++;
		}
		if(count == 4) {
			
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				System.out.println(year + " is a leap year");
			else
				System.out.println(year + "is not a leap year");
		}
		else {
			scanner.nextLine();
			leapYearChecker(integerInput());
		}
	}

	/****************************************************************************
	 * Function to print the value of two power the given number of times.
	 * 
	 * @param times to get the value of two power
	 ****************************************************************************/
	public static void powerOfTwo(int times) {
		for (int i = 0; i <= times; i++) {
			System.out.println("2 power " + i + " =" + Math.pow(2, i));
		}
	}

	/*****************************************************************************
	 * Function to get the value of Nth harmonic number
	 * 
	 * @param value to store the value of Nth harmonic number
	 *****************************************************************************/
	public static void harmonicValue(int n) {
		double value = 0.0;
		if(n>0) {
			for (int i = 1; i <= n; i++)
				value += (double) 1 / i;
				System.out.println("The " + n + "th harmonic value is " + value);
		}
		else {
			System.out.println("Invalid input, enter a positive number");
			harmonicValue(integerInput());
		}
	}

	/******************************************************************************
	 * Function to get the prime factors of the given number
	 * 
	 * @param number to store the number which prime factor is needed
	 ******************************************************************************/
	public static void primeFactorsOfNumber(int number) {
		int i = 2;
		while (number > 1) {
			if (number % i == 0) {
				System.out.println(i);
				number = number / i;
			} else
				i++;
		}
	}

	/*************************************************************************
	 * Function to generate random coupon numbers
	 * 
	 * @param noOfCoupons to store the number of distinct coupons to generate
	 **************************************************************************/
	public static void couponGenerator(int noOfCoupons) {
		Random random = new Random(); 
		List<Integer> array = new ArrayList<>();
		int coupons = 0;
		int count = 0;
		do {
			coupons = random.nextInt(noOfCoupons);
			count++;
			if(!array.contains(coupons)) {
				array.add(coupons);
			}
		}
		while(array.size() < noOfCoupons);
		for(int n : array)
			System.out.println(array.get(n));
		System.out.println("count = " + count);
	}

	/*****************************************************************************
	 * Function to get the percentage value of bet won and lost
	 * 
	 * @param stack stores the amount players currently has
	 * @param goal stores the amount is to be made after all the bets
	 * @param noOfGoal store the number of time players bets
	 **************************************************************************/

	public static void winLossPercentage(int stack, int goal, int noOfBets) {
		int win = 0, loss = 0;
		Random random = new Random();
		for (int i = 0; i < noOfBets; i++) {
			if (random.nextInt(10) > 5) {
				win++;
				stack++;
				System.out.println("bet won");
			} else {
				loss++;
				stack--;
				System.out.println("bet lost");
			}
		}
		if (stack == goal) {
			System.out.println("Won the game");
		} else {
			System.out.println("Lost the game");
		}
		System.out.println("Win percentage = " + (win * 100 / noOfBets));
		System.out.println("loose percentage = " + (loss * 100 / noOfBets));
	}

	/*************************************************************************
	 * Function to print a 2D array of users choice
	 * 
	 * @param rows to store the number of rows an array can have
	 * @param columns to stores the number of columns an array can have
	 **********************************************************************/
	public static void printAarray(int rows, int columns) {
		Object[][] array = new Object[rows][columns];
		PrintWriter writer = new PrintWriter(System.out); //creating an instance of PrintWriter class
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = stringInput();
			}
		}
		for(Object[] arr : array) {
			for(Object a : arr) {
				writer.print(a.toString()+ "  ");
				writer.flush();
			}
			writer.println();
		}
	}
	
	/*************************************************************************
	 * Function to find distinct triplets which gives the sum as 0 
	 * 
	 * @param noOfElements to get the number of elements to be stored
	 **********************************************************************/
	public static void getDistinctTriplets(int noOfElements) {
		int[] array = new int[noOfElements];
		int count = 0;
		System.out.println("Enter the elements:-");
		for(int i=0; i<noOfElements; i++) {
			array[i] = integerInput();
		}
		for(int i=0;i<noOfElements-2;i++) {
			for(int j=i+1;j<noOfElements-1;j++) {
				for(int k=j+1;k<noOfElements;k++) {
					if(array[i]+array[j]+array[k] == 0) {
						System.out.print("[" + array[i] + ",");
						System.out.print(array[j] + ",");
						System.out.println(array[k] + "]");
						count++;
					}
				}
			}
		}
		if(count == 0) {
			System.out.println("No such triplet exits");
		}
		else {
			System.out.println("There are " + count + " number of triplets ");
		}
	}
	
	
	/*************************************************************************
	 * Function to find the Euclidean Distance from the given (x,y) co-ordinates
	 * 
	 * @param xCoordinate to store the value of x co-ordinate
	 * @param yCoordinate to store the value of y co-ordinate
	 **********************************************************************/
	public static double getEuclideanDistance(String xCoordinate, String yCoordinate) {
		int x = Integer.parseInt(xCoordinate);
		int y = Integer.parseInt(yCoordinate);
		double distance = Math.pow(Math.pow(x, 2) + Math.pow(y, 2),0.5);
		return distance;
	}
	
	/*************************************************************************
	 * Function to call recursive permutation method
	 * 
	 **********************************************************************/
	public static void permutationFinder(String str) {
		permutation("",str);
	}

	/*************************************************************************
	 * Function to print the String permutation 
	 * 
	 * @param str to store the current string after each permutation call
	 * @param prefix to store the String permutation formed
	 **********************************************************************/
	public static void permutation(String prefix, String str) {
		
		int n = str.length();
		if(n == 0) {
			System.out.println(prefix);
		}
		else {
			for(int i=0; i<n; i++) {
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
	
	/*************************************************************************
	 * Function to get the current time in milliseconds
	 * 
	 * @param start to check if the timer is to be started
	 * @return long value with current time in milliseconds
	 **********************************************************************/
	public static long startTimer(int start) {
		long startTime = 0;
		if(start == 1) {
			startTime = System.currentTimeMillis();
			return startTime;
		}
		else 
			return 0;
	}
	
	/*************************************************************************
	 * Function to print the elapsed time 
	 * 
	 * @param stop to check if the timer is to be stopped
	 * @param startTime to store the time when the timer was started
	 **********************************************************************/
	public static void stopTimer(int stop, long startTime) {
		long stopTime = 0;
		if(stop == 2) {
			stopTime = System.currentTimeMillis();
		}
		long elapsedTime = stopTime - startTime;
		long seconds = elapsedTime/1000;
		System.out.println(seconds);
	}
	
	/*************************************************************************
	 * Function to print the effective temperature  
	 * 
	 * @param string temperature to store the given temperature
	 * @param string velocity to store the velocity of the wind
	 **********************************************************************/
	public static void effectiveTemperature(String temperature, String velocity) {
		double temp = Double.parseDouble(temperature);
		double v = Double.parseDouble(velocity);
		if(temp<=50 && v<=120 && v>=3) {
			double effTemp = 35.74 + (0.6215 * temp) + (((0.4275 * temp) - 35.75) * Math.pow(v, 0.16));
			System.out.println("Measured wind chill is " + effTemp);
		}
		else {
			System.out.println("Enter temperature below 50 and velocity within range 3 to 120");
			effectiveTemperature(stringInput(), stringInput());
		}
	}	
	
	/*************************************************************************
	 * Function to find the roots of the given quadratic equation  
	 * 
	 **********************************************************************/
	public static void getRoots(int a, int b, int c) {
		double discriminant = Math.pow(b, 2) - 4*a*c;
		double root1 = (-b + Math.pow(discriminant, 0.5))/(2*a);
		double root2 = (-b - Math.pow(discriminant, 0.5))/(2*a);
		System.out.println("First root for " + a + "x*x" + b + "x" + c + " is " + root1);
		System.out.println("Second root for " + a + "x*x" + b + "x" + c + " is " + root2);

		
	}
	
}