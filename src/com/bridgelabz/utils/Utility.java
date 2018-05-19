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
	 * @return String containing replaced template with proper name
	 ***************************************************************************************/
	public static String replaceTemplate(String username) {
		String template = "Hello " + username + ", How are you?";
		// to ensure username has minimum 3 characters
		if (username.length() >= 3) {
			String propername = getPropername(username);
			template = template.replace(username, propername);
		} else
			System.out.println("invalid input");
		return template;

	}

	/*****************************************************************************************
	 * Function to get proper name from provided username
	 * 
	 * @return String containing proper name of the user
	 *****************************************************************************************/

	public static String getPropername(String username) {
		// @param string name to store the valid username
		String name = "";
		for (int i = 0; i < username.length(); i++) {
			if ((username.charAt(i) >= 65 && username.charAt(i) <= 90)
					|| (username.charAt(i) >= 97 && username.charAt(i) <= 122))
				name += username.charAt(i);
		}
		return name;
	}

	/*******************************************************************************************
	 * Function to get the percentage of head and tail after flipping coin given
	 * number of times
	 * 
	 * @param head
	 *            to keep the count of number of times head comes
	 * @param tail
	 *            to keep the count of number of times tail comes
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
		System.out.println("Percentage of head after flipping coin " + noOfTimes + " = " + (tail * 100) / noOfTimes);
	}

	/*************************************************************************
	 * Function to check the given year is leap year or not
	 * 
	 * @param validyear to get the valid year
	 * @param count to count the number of digits
	 * @return true for leap year and false for not a leap year
	 *************************************************************************/
	public static void leapYearChecker(int year) {
		int count=0;
		int validYear = year;
		while (validYear>0) {
			validYear = validYear/10;
			count++;
		}
		if(count == 4) {
			
			if (year % 4 == 0 || (year % 400 == 0 && year % 100 == 0))
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
	 * @return double value containing harmonic number
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
			scanner.nextLine();
			harmonicValue(integerInput());
		}
	}

	/******************************************************************************
	 * Function to get the prime factors of the given number
	 * 
	 * @param primeFactors to store the factors of the given number
	 * @return Object[] containing all the prime factors of the given number
	 ******************************************************************************/
	public static void primeFactorsOfNumber(int number) {
		HashSet<Integer> primeFactors = new HashSet<Integer>();
		int i = 2;
		while (number > 1) {
			if (number % i == 0) {
				primeFactors.add(i);
				number = number / i;
			} else
				i++;
		}
		Iterator<Integer> itr = primeFactors.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	/*************************************************************************
	 * Function to generate random coupon numbers
	 * 
	 * @param arr to store the provided string in array
	 * @param c to get the random character from the character array
	 **************************************************************************/
	public static void couponGenerator(int noOfCoupons) {
		Random random = new Random(); // creating an instance of Random class;
		while (noOfCoupons > 0) {
			StringBuilder randomValue = new StringBuilder(); // creating an instance of StringBUffer class;
			char[] arr = "12345ABCDE".toCharArray();
			for (int i = 0; i < 8; i++) {
				char c = arr[random.nextInt(arr.length)];
				randomValue.append(c);
			}
			System.out.println(randomValue);
			noOfCoupons--;
		}
	}

	/*****************************************************************************
	 * Function to get the percentage value of bet won and lost
	 * 
	 * @param win to keep the count of winning the bet
	 * @param loss to keep the count of the losing the bet
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
	 * @param array to store the elements in 2D array
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
	 * @param array to store the elements in an array
	 * @param count to keep the count of such triplets
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
	 * Function to find the Eculidean Distance from the given (x,y) co-ordinates
	 * 
	 * @param x to store the value of x co-ordinate
	 * @param y to store the value of y co-ordinate
	 **********************************************************************/
	public static double getEculideanDistance(String xCoordinate, String yCoordinate) {
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
	 * @param n to store the length of the String
	 * @param prefix to store the STring permutation formed
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
	 * @param startTime to store the current time
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
	 * @param stopTime to store the current time
	 * @param elapsedTime to store the difference between the start time and stop time
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
	 * @param temp to store the given temperature
	 * @param v to store the given velocity
	 * @param effTemperature to store the calculated effective temperature
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
	 * @param discriminant to store the discriminate for the given equation
	 * @param root1 to store the first root of the equation
	 * @param root2 to store the second root of the equation
	 **********************************************************************/
	public static void getRoots(int a, int b, int c) {
		double discriminant = Math.pow(b, 2) - 4*a*c;
		double root1 = (-b + Math.pow(discriminant, 0.5))/(2*a);
		double root2 = (-b - Math.pow(discriminant, 0.5))/(2*a);
		System.out.println("First root for " + a + "x*x" + b + "x" + c + " is " + root1);
		System.out.println("Second root for " + a + "x*x" + b + "x" + c + " is " + root2);

		
	}
	
	/*************************************************************************
	 * Function to find the roots of the given quadratic equation  
	 * 
	 * @param 
	 **********************************************************************/
	public static void displayBoard() {
		String[][] matrix = new String[3][3];
		for(int i=0;i<3;i++) {
			
		}
	}
	
}