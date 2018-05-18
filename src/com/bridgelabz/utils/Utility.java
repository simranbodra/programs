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
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Utility {
	
	/*
	 * Static Variable is declared to create static object of Scanner class
	 */
	static Scanner scn = new Scanner(System.in);

	   /**
	    * Function to take input from the user
	    */
	public static String input()
	{
		String n = scn.nextLine();
		return n;
	}
	
	
	
	
	/**
	    * Function to take replace the template
	    * @return String containing replaced template with proper name
	    */
	public static String replaceTemplate(String username)
	{
		String template = "Hello " + username + ", How are you?";
		// to ensure username has minimum  3 characters
		if(username.length()>=3)
		{
			String propername = getPropername(username);
			template = template.replace(username, propername);
		}
		else 
			System.out.println("invalid input");
		return template;
			
	}
	
	
	
	
	/**
	    * Function to get proper name from provided username
	    * @return String containing proper name of the user
	    */
	
	public static String getPropername(String username)
	{
		// @param string name to store the valid username
		String name = "";
		for(int i=0;i<username.length();i++)
		{
			if((username.charAt(i)>=65 && username.charAt(i)<=90) || (username.charAt(i)>=97 && username.charAt(i)<=122))
				name+=username.charAt(i);
		}
		return name;
	}
	
	/**
	    * Function to get the percentage of head and tail after flipping coin given number of times
	    * @param head to keep the count of number of times head comes
	    * @param tail to keep the count of number of times tail comes
	    */
	public static void flipCoinPercentage(int noOfTimes)
	{
		int head=0, tail=0;
		for(int i=1;i<=noOfTimes;i++)
		{
			if(Math.random()<0.5)
				tail++;
			else
				head++;
		}
		System.out.println("Percentage of head after flipping coin " + noOfTimes + " = " +(head*100)/noOfTimes);
		System.out.println("Percentage of head after flipping coin " + noOfTimes + " = " +(tail*100)/noOfTimes);
	}
	
	
	/**
	    * Function to check the given year is leap year or not
	    * @param validyear to get the valid year
	    * @return true for leap year and false for not a leap year
	    */
	public static void leapYearChecker(String year)
	{
		while(year.length()!=4)
		{
			System.out.println("Invalid input");
		}
		int validYear = Integer.parseInt(year);
		if(validYear%4==0 || (validYear%400==0 && validYear%100==0))
			System.out.println(validYear + " is a leap year");
			else 
				System.out.println(validYear + "is not a leap year");
	}
	
	
	
	/**
	    * Function to print the value of two power the given number of times.
	    * @param times to get the value of two power 
	    */
	public static void powerOfTwo(int times)
	{
		for(int i=0;i<=times;i++)
		{
			System.out.println("2 power " + i + " =" + Math.pow(2,i));
		}
	}
	
	
	/**
	    * Function to get the value of Nth harmonic number
	    * @param value to store the value of Nth harmonic number
	    * @return double value containing harmonic number
	    */
	public static double harmonicValue(int n)
	{
		double value = 0.0;
		for(int i=1;i<=n;i++)
			value += (double)1/i;
		return value;
	}
	
	
	/**
	    * Function to get the prime factors of the given number
	    * @param  primeFactors to store the factors of the given number
	    * @return Object[] containing all the prime factors of the given number
	    */
	public static void primeFactorsOfNumber(int number)
	{
		HashSet<Integer> primeFactors = new HashSet<Integer>();
		int i = 2;
		while(number>1)
		{
			if(number%i==0)
			{
				primeFactors.add(i);
				number = number/i;
			}
			else
				i++;
		}
		Iterator<Integer> itr=primeFactors.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
	}
	
	/**
	    * Function to generate random coupon numbers
	    * @param  arr to store the provided string in array
	    * @param c to get the random character from the character array
	    */
	public static void couponGenerator(int noOfCoupons)
	{
		Random random = new Random(); // creating an instance of Random class;
		while(noOfCoupons>0)
		{
			StringBuilder randomValue = new StringBuilder(); // creating an instance of StringBUffer class;
			char[] arr = "12345ABCDE".toCharArray();	
			for(int i=0;i<8;i++)
			{
				char c = arr[random.nextInt(arr.length)];
				randomValue.append(c);
			}
			System.out.println(randomValue);
			noOfCoupons--;
		}
	}
		

	/**
	    * Function to generate random coupon numbers
	    * @param  arr to store the provided string in array
	    * @param c to get the random character from the character array
	    */

	public static void winLossPercentage(int stack, int goal, int noOfBets)
	{
		int win = 0, loss = 0;
		Random random = new Random();
		for(int i=0;i<noOfBets;i++)
		{
			if(random.nextInt(10)>5)
			{
				win++;
				stack++;
				System.out.println("bet won");
			}
			else
			{
				loss++;
				stack--;
				System.out.println("bet lost");
			}
		}
		if(stack == goal)
		{
			System.out.println("Won the game");
		}
		else
		{
			System.out.println("Lost the game");
		}
		System.out.println("Win percentage = " + ((win*100/noOfBets)));
		System.out.println("loose percentage = " + ((loss*100/noOfBets)));
	}
	
		  
}