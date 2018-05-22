/******************************************************************************
 *   Purpose: to store all the functions
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   19-05-2018
 ******************************************************************************/
package com.bridgelabz.utils;

import java.util.Scanner;

import java.util.Arrays;

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
	
	
	/*************************************************************************************
	 * Function to take convert integer input from the user to Integer Object
	 **************************************************************************************/
	public static Integer integerObjectInput()
	{
		try
		{
			int input = scanner.nextInt();
			Integer number = new Integer(input);
			return number;
		}
		catch(Exception e)
		{
			scanner.nextLine();
			System.out.println("Invalid input, enter again");
			return integerInput();
		}
	}
	
	/*************************************************************************************
	 * Function to check if the two Strings are anagram or not
	 * 
	 * @param s1 to store first string
	 * @param s2 to store second string
	 * @return boolean true if two strings are anagram or else return false
	 **************************************************************************************/
	public static boolean checkAnagram(String s1, String s2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");
		if(s1.length() == s2.length()) {
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			char[] str1 = s1.toCharArray();
			char[] str2 = s2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			for(int i=0;i<str1.length;i++)
			{
				string1.append(str1[i]);
				string2.append(str2[i]);
			}
			if(string1.toString().equals(string2.toString())) {
				return true;
			}
			else
				return false;
		}
		else 
			return false;
		
	}
	
	
	/******************************************************************************
	 * Function to print the prime number between 0 to 1000
	 * 
	 ******************************************************************************/
	public static void printPrimeNumber() {
		for(int i=0; i<=1000; i++) {
			if(primeChecker(i)) {
				System.out.println(i);
			}
		}
	}
	
	/******************************************************************************
	 * Function to check if the given number is prime or not 
	 * 
	 * @param n to store the number which is to be checked
	 * @return true if the number is prime and return false if the number is not prime
	 ******************************************************************************/
	public static boolean primeChecker(int n) {
		if(n==0 || n==1) {
			return false;
		}
		else {
			for(int i=2;i*i<=n;i++) {
				if(n%i==0) {
					return false;
				}
			}
			return true;
		}
	}
	

	/******************************************************************************
	 * Function to check if the given number is palindrom or not
	 * 
	 * @param number to store the number to be checked if palindrom or not 
	 * @return true if the number is palindrom and return false if the number is not palindrom
	 ******************************************************************************/
	public static boolean palindromChecker(int number) {
		int num = number;
		int reverseNumber = 0;
		while(num>0) {
			reverseNumber = reverseNumber*10 + num%10;
			num = num/10;
		}
		if(number == reverseNumber)
			return true;
		else
			return false;
	}
	

	/******************************************************************************
	 * Function to print number which is prime and palindrom or not between 0 to 1000
	 * and print Anagram pairs
	 * 
	 ******************************************************************************/
	public static void checkNumber( ) {
		System.out.println("Prime numbers which are palindrom:-");
		for(int i=0; i<=1000; i++) {
			if(primeChecker(i) && palindromChecker(i) ) {
					System.out.println(i);
			}
		} 
		System.out.println("Prime numbers which are Anagram");
		int count = 0;
		for(int i=0;i<=1000;i++) {
			if(primeChecker(i))
				count++;
		}
		String[] primeNumbers = new String[count];
		int index = 0;
		for(int i=0;i<=1000;i++) {
			if(primeChecker(i))
				primeNumbers[index++] = i+"";
		} 
		for(int i=0;i<primeNumbers.length-1;i++) {
			for(int j=i+1;j<primeNumbers.length;j++) {
				if(checkAnagram(primeNumbers[i],primeNumbers[j]))
					System.out.println("[" + primeNumbers[i] + "," + primeNumbers[j] + "]");
			}
		}
	}
	
	/*************************************************************************
	 * Function to get the current time in milliseconds
	 * 
	 * @param startTime to store the current time
	 * @return long value with current time in milliseconds
	 **********************************************************************/
	public static long startTimer() {
		long startTime = 0;
			startTime = System.nanoTime();
			return startTime;
	}
	
	/*************************************************************************
	 * Function to print the elapsed time 
	 * 
	 * @param stopTime to store the current time
	 * @param elapsedTime to store the difference between the start time and stop time
	 **********************************************************************/
	public static long stopTimer() {
		long stopTime = 0;
			stopTime = System.nanoTime();
		return stopTime;
	}

	/******************************************************************************
	 * Function to create integer object array
	 * 
	 * @param noOfElements to store the length of the array to be created
	 * @return array created
	 ******************************************************************************/
	public static Comparable[] createObjectArray(int noOfElements) {
		Comparable[] array = new Comparable[noOfElements];
		System.out.println("Enter the elements");
		for(int i=0;i<noOfElements;i++) {
			array[i] = integerObjectInput();
		}
		return array;
	}
	

	/******************************************************************************
	 * Function to create string array
	 * 
	 * @param noOfElements to store the length of the array to be created
	 * @return array created
	 ******************************************************************************/
	public static String[] createStringArray(String string) {
		String[] array = string.split(" ");
		return array;
	}
	
	
	/******************************************************************************
	 * Function to perform Bubble sort for an generic array
	 * 
	 * @param array to store the integer array to be sorted
	 ******************************************************************************/
	public static <T extends Comparable <T>> void bubbleSort(T[] array) {
		
		long startTime = startTimer();
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length-1-i;j++) {
				if(array[j].compareTo(array[j+1])>0) {
					T temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(T n : array) {
			System.out.println(n);
		}
	}
	/******************************************************************************
	 * Function to perform insertion sort for an generic array
	 * 
	 * @param array to store the integer array to be sorted
	 ******************************************************************************/
	public static <T extends Comparable <T>> void insertionSort(T[] array) {
		long startTime = startTimer();
		for(int i=1; i<array.length; i++) {
			T key = array[i];
			int j = i-1;
			while(j>=0 && array[j].compareTo(key)>0) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(T n : array) {
			System.out.println(n);
		}
	}

	/******************************************************************************
	 * Function to recursively call binary search function
	 * 
	 * @param array which stores the elements
	 ******************************************************************************/
	public static <T extends Comparable <T>> void binarySearchChecker(T[] array) {
		System.out.println("Enter the word to be searched:-");
		T searchElement = new T(integerInput());
		Arrays.sort(array);
		long startTime = startTimer();
		int index = binarySearch(array,searchElement,0,array.length-1);
		long stopTime = stopTimer();
		System.out.println("Time taken for searching is " + (stopTime - startTime) + " nano seconds");
		if(index == -1) 
			System.out.println("Word not present");
		else
			System.out.println("Word " + searchElement + " found at position " + (index+1));
	}
	/******************************************************************************
	 * Function to perform the word  or character binary search
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static <T extends Comparable <T>> int binarySearch(T[] array, T searchElement, int start, int end) {
		int mid = (start + end)/2;
		if(array[mid].compareTo(searchElement) == 0)
			return mid;
		else {
			if(searchElement.compareTo(array[mid]) > 0) 
				return binarySearch(array, searchElement, mid+1,end);
			else
				return binarySearch(array, searchElement, start, mid-1);
		}
	}

}
