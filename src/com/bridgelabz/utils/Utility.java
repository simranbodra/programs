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
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

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
			System.out.println("Element " + searchElement + " is present");
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
			for(int j=0;j<array.length-1-i; j++) {
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
		return stringArray;
	}

	/******************************************************************************
	 * Function to print the index of the searched character if present in the array
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static void characterWordBinarySearchChecker(String[] array) {
		System.out.println("Enter the word or character to be searched:-");
		String searchElement = stringInput();
		Arrays.sort(array);
		long startTime = startTimer();
		int index = characterWordBinarySearch(array,searchElement,0,array.length-1);
		long stopTime = stopTimer();
		System.out.println("Time taken for searching is " + (stopTime - startTime) + " nano seconds");
		if(index == -1) 
			System.out.println("Word not present");
		else
			System.out.println("Word " + searchElement + " is present");
	}
	
	/******************************************************************************
	 * Function to perform the word  or character binary search
	 * 
	 * @param 
	 * @return 
	 ******************************************************************************/
	public static int characterWordBinarySearch(String[] array, String searchElement, int start, int end) {
		int mid = (start + end)/2;
		if(array[mid].compareToIgnoreCase(searchElement) == 0)
			return mid;
		else {
			if(searchElement.compareToIgnoreCase(array[mid]) > 0) 
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
			String[] charArray = string.split("");
			characterWordBinarySearchChecker(charArray);
		}
		else {
			characterWordBinarySearchChecker(stringArray);
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
			while(j>=0 && array[j].compareToIgnoreCase(key)>0) {
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
			String[] charArray = string.split("");
			wordInsertionSort(charArray);
		}
		else {
			wordInsertionSort(stringArray);
		}
	}
	
	/******************************************************************************
	 * Function to perform Bubble sort for an String array
	 * 
	 * @param array to store the integer array to be sorted
	 ******************************************************************************/
	public static void wordBubbleSort(String[] array) {
		long startTime = startTimer();
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j].compareToIgnoreCase(array[j+1])>0) {
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
	 * @param input to store the string to be sorted
	 ******************************************************************************/
	public static void stringBubbleSort(String input) {
		String[] stringArray = splitString(input);
		if(stringArray.length == 1) {
			String string = stringArray[0];
			String[] charArray = string.split("");
			wordBubbleSort(charArray);
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
	
	/******************************************************************************
	 * Function to read a text file 
	 *
	 ******************************************************************************/
	public static String[] readWordListFile() {
		String[] array = new String[5];
		try {
			Scanner input = new Scanner(new File("wordList.text"));
			while(input.hasNextLine()) {
				String words = input.nextLine();
				array = words.split(";");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for(String n : array)
			System.out.println(n);
		return array;
	}
	
	/******************************************************************************
	 * Function to read a text file 
	 *
	 ******************************************************************************/
	public static void searchWord(String searchElement) {
		String[] array = readWordListFile();
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
	 * Function to sort the string using merge sort
	 * 
	 * @param input to store the string to be sorted
	 ******************************************************************************/
	public static void stringMergeSort(String input) {
		String[] stringArray = splitString(input);
		if(stringArray.length == 1) {
			String string = stringArray[0];
			String[] charArray = string.split("");
			long startTime = startTimer();
			String[] array = wordMergeSort(charArray,0,charArray.length-1);
			long stopTime = stopTimer();
			System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
			System.out.println("Sorted array :-");
			for(String n : array)
				System.out.println(n);
		}
		else {
			long startTime = startTimer();
			String[] array = wordMergeSort(stringArray,0,stringArray.length-1);
			long stopTime = stopTimer();
			System.out.println("Time taken for sorting the array by using insertion sort technique " + (stopTime-startTime) + " nano seconds");
			System.out.println("Sorted array :-");
			for(String n : array)
				System.out.println(n);
		}
	}
	
	/******************************************************************************
	 * Function to perform merge sort for an String array
	 * 
	 * @param array to store the string array to be sorted
	 * @param start to store the starting index of the array
	 * @param end to store the ending index of the array
	 ******************************************************************************/
	public static String[] wordMergeSort(String[] array, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			wordMergeSort(array,start,mid);
			wordMergeSort(array,mid+1,end);
			merge(array,start,mid,end);
		}
		return array;
	}

	/******************************************************************************
	* Function to perform merging of the String array for merge sort
	* 
	* @param array to store the string array to be sorted
	* @param start to store the starting index of the array
	* @param end to store the ending index of the array
	******************************************************************************/
	public static void merge(String[] array, int start, int mid, int end) {
		// Find sizes of two subarrays to be merged
		int length1 = mid-start+1;
		int length2 = end-mid;
		//create temporary arrays
		String[] leftArray = new String[length1];
		String[] rightArray = new String[length2];
		//copy data to temporary array
		for(int i=0;i<length1;i++)
			leftArray[i] = array[start+i];
		for(int j=0;j<length2;j++)
			rightArray[j] = array[mid+1+j];
		int i=0,j=0,k=start;
		while(i<length1 && j<length2) {
			if(leftArray[i].compareToIgnoreCase(rightArray[j])<0) {
				array[k] = leftArray[i];
				i++;
			}
			else {
				array[k] = rightArray[j];
				j++;
				}
				k++;
			}
			while(i<length1) {
				array[k] = leftArray[i];
				i++;
				k++;
			}
			while(j<length2) {
				array[k] = rightArray[j];
				j++;
				k++;
			}
	}
	/******************************************************************************
	* Function to get the noOfNotes 
	* 
	* @param amount stores the value entered by the user
	* @param i stores the index value to get the type of notes from notes array
	******************************************************************************/
	public static void noOfNotes(int amount, int i) {
		while(amount>0) {
			if(amount>=getNotes(i)) {
				System.out.println(getNotes(i) + " RS Notes " + amount/getNotes(i));
				amount = amount%getNotes(i);
				System.out.println(amount);
				noOfNotes(amount,i);
			}
			else
				noOfNotes(amount,++i);
		}
	}
	
	/******************************************************************************
	* Function to return the types of notes
	* 
	* @param index to get the value at the particular index
	* @return value at the index passed
	******************************************************************************/
	public static int getNotes(int index) {
		int[] notes = {1000,500,100,50,10,2,1};
		return notes[index];
	}
	
	/******************************************************************************
	* Function to print the week day of the particular date
	* 
	* @param month to store the value of the month
	* @param day to store the value of the day
	* @param year to store the value of the year
	******************************************************************************/
	public static void printWeekDay(int month, int day, int year) {
		int y = year-(14-month)/12;
		int x = y+(y/4)-y/100+y/400;
		int m = month+12*((14-month)/12)-2;
		int d = (day+x+(31*m)/12)%7;
		switch(d){
			case 0:
				System.out.println("Sunday");
				break;
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
		}
	}
	
	/******************************************************************************
	* Function to perform the temperature conversion from fahrenheit to celcius 
	* and vice versa
	* 
	* @param choice to perform the switch case task accordingly
	******************************************************************************/
	public static void convertTemperature(int choice) {
		switch(choice) {
		case 1:
			System.out.println("Enter temperature");
			double fahrenheit = integerInput();
			double celcius = (fahrenheit-32)*(5.0/9.0);
			System.out.println(fahrenheit + " Fahrenheit = " + celcius + " Celcius");
			break;
		case 2:
			System.out.println("Enter temperature");
			double celciusTemp = integerInput();
			double fahrenheitTemp = celciusTemp*(9.0/5.0)+32;
			System.out.println(celciusTemp + " Celcius = " + fahrenheitTemp + " Fahrenheit");
			break;
		default :
			System.out.println("Invalid choice");
		}
	}
	
	/******************************************************************************
	* Function to get the monthly payment needed to pay off the loan in given year
	* with given principle amount with given rate
	* 
	* @param principle to store the principle value 
	* @param year to store the year value given by the user
	* @param rate to store the rate entered by the user
	* @return payment need to pay off loan
	******************************************************************************/
	public static double getMonthlyPayment(double principle, int year, double rate) {
		int n = 12*year;
		double r = rate/(12*100);
		double payment = (principle*r)/(1-Math.pow((1+r), -n));
		return payment;
	}
	
	/******************************************************************************
	* Function to find the square root of the given number using Newton's method 
	* 
	* @param c stores the number which square root is to be found
	* @return the square root of the number
	******************************************************************************/
	public static double sqrt(int c) {
		double t=c;
		double epsilon = 1e-15;
		while(Math.abs(t-c/t)>epsilon*t) {
			t = (c/t+t)/2;
		}
		return t;
	}
	
	/******************************************************************************
	* Function to convert from decimal to binary 
	* 
	* @param number to convert it to binary
	* @return string with binary value
	******************************************************************************/
	public static String toBinary(int number) {
		StringBuffer binaryValue = new StringBuffer();
		int binary = 0;
		while(number>1) {
			binary = number%2;
			number = number/2;
			binaryValue.append(binary);
		}
		binaryValue.append("1");
		return binaryValue.reverse().toString();
	}
	
	/******************************************************************************
	* Function to split an octate into two half
	* 
	* @param string which contains the binary value
	* @return string which contains the binary value which decimal is to be found
	******************************************************************************/
	public static String halfAnOctate(String string) {
		StringBuffer octate = new StringBuffer(string);
		String stringOctate = "";
		String nibble1 = "";
		String nibble2 = "";
		String nibble = "";
		if(octate.length()<8) {
			octate = octate.reverse();
			for(int i=0;i<(8-octate.length());i++) {
				octate.append("0");
			}
		}
		octate = octate.reverse();
		stringOctate = octate.toString();
		for(int i=0;i<4;i++)
			nibble1 += stringOctate.charAt(i);
		for(int i=4;i<8;i++)
			nibble2 += stringOctate.charAt(i);
		nibble = nibble2 + nibble1;
		return nibble;
	}
	
	/******************************************************************************
	* Function to convert binary to decimal
	* 
	* @param binary store the binary value in string
	* @return decimal value obtained
	******************************************************************************/
	public static int getDecimalValue(String binary) {
		int decimal = 0;
		int powerOfTwo = 0;
		for(int i=binary.length()-1;i>=0;i--) {
			int binaryValue = Integer.parseInt(binary.charAt(i)+"");
			decimal += binaryValue*Math.pow(2,powerOfTwo);
			powerOfTwo++;
		}
		return decimal;
	}
	
	/******************************************************************************
	* Function to check if the number is power of two
	* 
	* @param number to be checked
	* @return true if number is power of two else return false
	******************************************************************************/
	public static boolean checkForPowOfTwo(int number) {
		boolean divisible = true;
		while(number>0) {
			if(number%2 == 0) {
				number = number/2;
			}
			else {
				divisible =false;
				return divisible;
			}
		}
		return divisible;
	}

	/******************************************************************************
	* Function to convert from decimal to binary, swap the nibbles and 
	* check if the returned number is power of two
	* 
	* @param c stores the number which square root is to be found
	* @return the square root of the number
	******************************************************************************/
	public static void toDecimal(int decimal) {
		String binaryValue = toBinary(decimal);
		System.out.println(binaryValue);
		String nibble = halfAnOctate(binaryValue);
		System.out.println(nibble);
		int decimalValue = getDecimalValue(nibble);
		System.out.println(decimalValue);
		if(checkForPowOfTwo(decimalValue))
			System.out.println(decimalValue + " is power of two ");
		else
			System.out.println(decimalValue + " is not power of Two ");
	}
}



















