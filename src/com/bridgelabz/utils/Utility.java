/******************************************************************************
 *  
 *  Purpose: to store all the functions
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   19-05-2018
 *
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
	 * Function to check if the two Strings are anagram or not
	 * 
	 * @param s1
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
	 * @param 
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
	 * @return true if the number is prime and return false if the number is not prime
	 ******************************************************************************/
	@SuppressWarnings("unused")
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
	 * Function to print number which is prime,anagram and palindrom or not between 0 to 1000
	 * 
	 * @return true if the number is prime and return false if the number is not prime
	 ******************************************************************************/
	public static void numberChecker( ) {
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
	

	/******************************************************************************
	 * Function to print number which is prime,anagram and palindrom or not between 0 to 1000
	 * 
	 * @param num to store the given number and check for palindrom
	 * @param reverseNumber to store the reversed number  
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
	 * Function to create the array of user's choice
	 * 
	 * @param noOfElements to store the array length to be created
	 * @param array to store the elements in the array
	 * @return the integer array created
	 ******************************************************************************/
	public static int[] createIntegerArray() {
		System.out.println("Enter the number of elements you want to store:-");
		int noOfElements = Utility.integerInput();
		System.out.println("Enter the elements to be stored:-");
		int[] array = new int[noOfElements];
		for(int i=0; i<noOfElements; i++) {
			array[i] = Utility.integerInput();
		}
		return array;
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
	 * Function to track the time taken by binary search technique to 
	 * 
	 * @param searchElement to store the element to be searched in the array
	 * @param startTime to store the time when the execution starts
	 * @param to store the index value at which element is present
	 ******************************************************************************/
	public static void integerBinarySearchChecker(int[] array) {
		System.out.println("Enter the element to be searched:-");
		int searchElement = integerInput();
		Arrays.sort(array);
		long startTime = startTimer();
		int index = integerBinarySearch(array,searchElement,0,array.length-1);
		long stopTime = stopTimer();
		System.out.println("Time taken for searching is " + (stopTime - startTime) + " nano seconds");
		if(index == -1) 
			System.out.println("Elements not present");
		else
			System.out.println("Element " + searchElement + " found at position " + (index+1));
	}
	
	/******************************************************************************
	 * Function to search for integer using binary search technique
	 * 
	 * @param mid to get the middle index of the array
	 * @param start to store the starting index of the array
	 * @param end to store the last index of the array
	 * @return index value if the element is found or else returns -1 if the element not found
	 ******************************************************************************/
	public static int integerBinarySearch(int[] array, int searchElement, int start, int end) {
		int mid = (start + end)/2;
		if(array[mid] == searchElement)
			return mid;
		else {
			if(searchElement > array[mid]) 
				return integerBinarySearch(array, searchElement, mid+1,end);
			else
				return integerBinarySearch(array, searchElement, start, mid-1);
		}
		
	} 
	
	/******************************************************************************
	 * Function to perform insertion sort for an integer array
	 * 
	 * @param array to store the integer array to be sorted
	 * @param key to store the element to be compared
	 ******************************************************************************/
	public static void integerInsertionSort() {
		int[] array = createIntegerArray();
		long startTime = startTimer();
		for(int i=1; i<array.length; i++) {
			int key = array[i];
			int j = i-1;
			while(j>=0 && array[j]>key) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(int n : array) {
			System.out.println(n);
		}
	}
	
	/******************************************************************************
	 * Function to perform bubble sort for an integer array
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void integerBubbleSort() {
		int[] array = createIntegerArray();
		long startTime = startTimer();
		for(int i=0; i<array.length-1; i++) {
			for(int j=1;j<array.length-1-i; j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array using bubble sort technique " + (stopTime-startTime) + " nano seconds");
		for(int n:array)
			System.out.println(n);
	}
	

	/******************************************************************************
	 * Function to split the given string by spaces
	 * 
	 * @param stringArray to store the splited string elements in the array
	 * @return array of string type
	 ******************************************************************************/
	public static String[] splitString(String string) {
		String[] stringArray = string.split(" ");
		for(int i=0; i<stringArray.length; i++) {
			stringArray[i] = stringArray[i].toLowerCase();
		}
		return stringArray;
	}
	
	/******************************************************************************
	 * Function to search for character using binary search technique
	 * 
	 * @param mid to get the middle index of the array
	 * @param start to store the starting index of the array
	 * @param end to store the last index of the array
	 * @return index value if the element is found or else returns -1 if the element not found
	 ******************************************************************************/
	public static int characterBinarySearch(char[] array, char searchElement, int start, int end) {
		int mid = (start + end)/2;
		if(array[mid] == searchElement)
			return mid;
		else {
			if(searchElement > array[mid]) 
				return characterBinarySearch(array, searchElement, mid+1,end);
			else
				return characterBinarySearch(array, searchElement, start, mid-1);
		}
		
	} 

	
	/******************************************************************************
	 * Function to print the index of the searched character if present in the array
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void characterBinarySearchChecker(char[] array) {
		System.out.println("Enter the character to be searched:-");
		String searchElement= stringInput();
		Arrays.sort(array);
		String[] arr = new String[array.length];
		for(int i=0; i<array.length; i++)
			arr[i] = array[i] + "";
		long startTime = startTimer();
		int index = characterWordBinarySearch(arr,searchElement,0,array.length-1);
		long stopTime = stopTimer();
		System.out.println("Time taken for searching is " + (stopTime - startTime) + " nano seconds");
		if(index == -1) 
			System.out.println("Elements not present");
		else
			System.out.println("Element " + searchElement + " found at position " + (index+1));
	}
	
	/******************************************************************************
	 * Function to print the index of the searched character if present in the array
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void wordBinarySearchChecker(String[] array) {
		System.out.println("Enter the word to be searched:-");
		String searchElement = stringInput();
		Arrays.sort(array);
		long startTime = startTimer();
		int index = characterWordBinarySearch(array,searchElement,0,array.length-1);
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
	public static int characterWordBinarySearch(String[] array, String searchElement, int start, int end) {
		int mid = (start + end)/2;
		if(array[mid].compareTo(searchElement) == 0)
			return mid;
		else {
			if(searchElement.compareTo(array[mid]) > 0) 
				return characterWordBinarySearch(array, searchElement, mid+1,end);
			else
				return characterWordBinarySearch(array, searchElement, start, mid-1);
		}
	}

	/******************************************************************************
	 * Function to perform the string binary search
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void stringBinarySearch(String input) {
		String[] stringArray = splitString(input);
		if(stringArray.length == 1) {
			String string = stringArray[0];
			char[] charArray = string.toCharArray();
			characterBinarySearchChecker(charArray);
		}
		else {
			wordBinarySearchChecker(stringArray);
		}
	}
	
	/******************************************************************************
	 * Function to perform insertion sort for an character array
	 * 
	 * @param array to store the integer array to be sorted
	 * @param key to store the element to be compared
	 ******************************************************************************/
	public static void characterInsertionSort(char[] array) {
		long startTime = startTimer();
		for(int i=1; i<array.length; i++) {
			char key = array[i];
			int j = i-1;
			while(j>=0 && array[j]>key) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(char n : array) {
			System.out.println(n);
		}
	}
	
	/******************************************************************************
	 * Function to perform insertion sort for an String array
	 * 
	 * @param array to store the integer array to be sorted
	 * @param key to store the element to be compared
	 ******************************************************************************/
	public static void wordInsertionSort(String[] array) {
		long startTime = startTimer();
		for(int i=1; i<array.length; i++) {
			String key = array[i];
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
		for(String n : array) {
			System.out.println(n);
		}
	}

	
	/******************************************************************************
	 * Function to sort the string using insertion sort
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void stringInsertionSort(String input) {
		String[] stringArray = splitString(input);
		if(stringArray.length == 1) {
			String string = stringArray[0];
			char[] charArray = string.toCharArray();
			characterInsertionSort(charArray);
		}
		else {
			wordInsertionSort(stringArray);
		}
	}
	
	/******************************************************************************
	 * Function to perform Bubble sort for an character array
	 * 
	 * @param array to store the integer array to be sorted
	 * @param key to store the element to be compared
	 ******************************************************************************/
	public static void characterBubbleSort(char[] array) {
		long startTime = startTimer();
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					char temp = array[j];
					array[j] =  array[j+1];
					array[j+1] = temp;
				}
			}
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(char n : array) {
			System.out.println(n);
		}
	}
	
	/******************************************************************************
	 * Function to perform Bubble sort for an String array
	 * 
	 * @param array to store the integer array to be sorted
	 * @param key to store the element to be compared
	 ******************************************************************************/
	public static void wordBubbleSort(String[] array) {
		long startTime = startTimer();
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length-1-i;j++) {
				if(array[j].compareTo(array[j+1])>0) {
					String temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		long stopTime = stopTimer();
		System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
		System.out.println("Sorted array :-");
		for(String n : array) {
			System.out.println(n);
		}
	}

	
	/******************************************************************************
	 * Function to sort the string using bubble sort
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void stringBubbleSort(String input) {
		String[] stringArray = splitString(input);
		if(stringArray.length == 1) {
			String string = stringArray[0];
			char[] charArray = string.toCharArray();
			characterBubbleSort(charArray);
		}
		else {
			wordBubbleSort(stringArray);
		}
	}
	

	/******************************************************************************
	 * Function to sort the string using bubble sort
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void getGuessNumber(int range) {
		int[] array = new int[range+1];
		for(int i=0;i<=range;i++) {
			array[i] = i;
		}
		int number = guessedNumber(array, 0,array.length-1);
		if(number == -1) {
			System.out.println("Number out of range");
		}
		else
			System.out.println("Number is " + number);
	}
	
	/******************************************************************************
	 * Function to sort the string using bubble sort
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static int guessedNumber(int[] array, int start, int end) {

		int mid = (start + end)/2;
		System.out.println("Is " + array[mid] + " the number?");
		System.out.println("If yes, enter 1 or else enter 0");
		System.out.println("Enter your choice:-");
		int answer = integerInput();
		if(answer == 1)
			return array[mid];
		else {
			System.out.println("Is number greater than the printed number?");
			System.out.println("If yes, enter 1 or else enter 0");
			int reply = integerInput();
			if(reply == 1) 
				return guessedNumber(array,mid+1,end);
			else
				return guessedNumber(array,start, mid-1);
		}
		
	
	}
}
