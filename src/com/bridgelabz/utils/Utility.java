package com.bridgelabz.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.datastructures.Deque;
import com.bridgelabz.datastructures.HashSet;
import com.bridgelabz.datastructures.Node;
import com.bridgelabz.datastructures.OrderedLinkedList;
import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.datastructures.Stack;
import com.bridgelabz.datastructures.UnorderedLinkedList;

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

	/******************************************************************************
	 * Function to read a text file 
	 *
	 ******************************************************************************/
	public static String readListFile(String fileName) {
		String words = "";
		try {
			Scanner input = new Scanner(new File(fileName));
			while(input.hasNextLine()) {
				words = input.nextLine();
				input.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return words;
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
	 * Function to convert from string array to integer array
	 * 
	 * @param stringArray which contains string type elements
	 * @return IntegerArray which contains integer type elements
	 ******************************************************************************/
	public static Integer[] toIntegerArray(String[] stringArray) {
		Integer[] integerArray = new Integer[stringArray.length];
		for(int i=0; i<stringArray.length; i++) {
			integerArray[i] = Integer.parseInt(stringArray[i]);
		}
		return integerArray;
	}
	
	/******************************************************************************
	 * Function to add words to the list 
	 * 
	 * @param array which elements is to be stored in the list which is comparable type
	 * @return SinglyLinkedList which return the list of the elements
	 ******************************************************************************/
	public static <T> UnorderedLinkedList<T> addWordsToList(T[] array) {
		UnorderedLinkedList<T> list = new UnorderedLinkedList<T>();
		for(int i=0; i<array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
	
	/******************************************************************************
	 * Function to search the word on the list
	 * @param <T>
	 * 
	 * @param list which contains the elements
	 * @param searchElement which contains the element to be searched in the list
	 * @return list which contains the modified list of elements
	 ******************************************************************************/
	public static <T extends Comparable<T>> UnorderedLinkedList<T> searchWord(UnorderedLinkedList<T> list, T searchElement) {
		if( list.search(searchElement)){
			list.remove(searchElement);
		}
		else {
			list.append(searchElement);
		}
		return list;
	}
	
	/******************************************************************************
	 * Function to add numbers to the list 
	 * 
	 * @param array which elements is to be stored in the list which is comparable type
	 * @return SinglyLinkedList which return the list of the elements
	 ******************************************************************************/
	public static <T extends Comparable<T>> OrderedLinkedList<T> addNumbersToList(T[] array) {
		OrderedLinkedList<T> list = new OrderedLinkedList<T>();
		for(int i=0; i<array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
	
	/******************************************************************************
	 * Function to search the number on the list
	 * 
	 * @param list which contains the elements
	 * @param searchElement which contains the element to be searched in the list
	 * @return list which contains the modified list of elements
	 ******************************************************************************/
	public static <T extends Comparable<T>> OrderedLinkedList<T> searchNumber(OrderedLinkedList<T> list, T searchElement) {
		System.out.println(list.search(searchElement));
		if(list.search(searchElement)) {
			list.remove(searchElement);
		}
		else {
			list.append(searchElement);
		}
		return list;
	}
	
	/******************************************************************************
	 * Function to add parenthesis to the list 
	 * 
	 * @param array which elements is to be stored in the list which is comparable type
	 * @return Stack which return the list of the elements
	 ******************************************************************************/
	public static <T> boolean addParenthesisToStack(String expression) {
		int popCount = 0;
		int pushCount = 0;
		Stack<T> parenthesisStack = new Stack<T>();
		String[] array = expression.split("");
		for(int i=0; i<array.length; i++) {
			if(array[i].equals("(")) {
				parenthesisStack.push((T)array[i]);
				pushCount++;
			}
			else if(array[i].equals(")")) {
					parenthesisStack.pop();
					popCount++;
				}
			}
		if(parenthesisStack.isEmpty() && pushCount == popCount) {
			return true;
		}
		else
			return false;
	}
	
	/******************************************************************************
	 * Function to add parenthesis to the list 
	 * 
	 * @param array which elements is to be stored in the list which is comparable type
	 * @return Stack which return the list of the elements
	 ******************************************************************************/
	public static <T> Queue<T> addToQueue(int noOfPerson) {
		Queue<T> people = new Queue<T>();
		for(int i=1; i<=noOfPerson; i++) {
			people.enqueue((T)("person" + i));
		}
		return people;
	}

	public static <T>void cashCounter(Queue<T> people) {
		int amount = (people.size()+1)*10000;
		while(people.size() > 0) {
			System.out.println("Enter 1 for Cash Deposit");
			System.out.println("Enter 2 for cash withdraw");
			int choice = integerInput();
			switch(choice) {
			case 1:
				System.out.println("Enter the amount to deposit:-");
				int depositAmount = integerInput();
				amount = amount + depositAmount;
				people.dequeue();
				break;
			
			case 2:
				System.out.println("At max 10000 rs can be withdrawn at a time");
				System.out.println("Enter the amount to be withdrawn:-");
				int withdrawAmount = integerInput();
				while(withdrawAmount > 10000) {
					System.out.println("more than 10000 rs cannot be withdrawn at a time");
					withdrawAmount = integerInput();
				}
				amount = amount - withdrawAmount;
				people.dequeue();
				break;
			default:
				System.out.println("Invalid choice");
				choice = integerInput();
				continue;
			}
		}
		if(people.size() == 0)
			System.out.println("No person in the queue");
		else
			System.out.println("people left in the queue");
	}

	public static <T> boolean checkForPalindrom(String string) {
		Deque<T> characters = new Deque<T>();
		String reverseString = "";
		for(int i=0; i< string.length(); i++) {
			characters.addFront((T)(string.charAt(i) + ""));
		}
		while(characters.size() > 0) {
			reverseString += characters.removeFront();
		}
		System.out.println(reverseString);
		if(string.compareTo(reverseString) == 0)
			return true;
		else
			return false;
	}
	
	/******************************************************************************
	 * Function to add numbers to the HashSet 
	 * 
	 * @param array which elements is to be stored in the list which is comparable type
	 * @return SinglyLinkedList which return the list of the elements
	 ******************************************************************************/
	public static HashSet addNumbersToSet(String[] array) {
		HashSet numberSet = new HashSet(11);
		for(int i=0; i<array.length; i++) {
			numberSet.add(Integer.parseInt(array[i]));
		}
		numberSet.display();
		return numberSet;
	}
	
	/******************************************************************************
	 * Function to search the number on the HashSet
	 * 
	 * @param numberSet which contains the elements
	 * @param searchElement which contains the element to be searched in the list
	 * @return numberSet which contains the modified list of elements
	 ******************************************************************************/
	public static HashSet searchNumberFromSet(HashSet numberSet, int searchElement) {
		if(numberSet.search(searchElement)) {
			numberSet.remove(searchElement);
		}
		else {
			numberSet.add(searchElement);
		}
		numberSet.display();
		return numberSet;
	}

	public static void addToFile(String fileName, HashSet numberSet) {
		try{    
	           FileWriter fw=new FileWriter(fileName);  
	           fw.write(numberSet.displayElements());    
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");        
	}
	
	public static boolean validateYear(String year) {
		if(year.length() == 4)
			return true;
		else
			return false;
	}
	
	public static boolean validateMonth(String month) {
		int mon = Integer.parseInt(month);
		for(int i=1; i<=12; i++) {
			if(mon == i)
				return true;
		}
		return false;
	}
	
	/******************************************************************************
	* Function to print the week day of the particular date
	* 
	* @param month to store the value of the month
	* @param year to store the value of the year
	* @return week day code
	******************************************************************************/
	public static int getWeekDay(int month, int year) {
		int day = 1;
		int y = year-(14-month)/12;
		int x = y+(y/4)-y/100+y/400;
		int m = month+12*((14-month)/12)-2;
		int d = (day+x+(31*m)/12)%7;
		return d;
	}
	
	/******************************************************************************
	* Function to check if the given year is leap year or not
	* 
	* @param year to store the value of the year
	* @return true if the year is leap year or return false
	******************************************************************************/
	public static boolean checkLeapYear(int year) {
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		else 
			return false;
	}
	
	/******************************************************************************
	* Function to get number of days in a month of a year
	* 
	* @param year to store the value of the year
	* @param month to store the value of the month
	* @return no of the days in the given month
	******************************************************************************/
	public static int getNoOfDays(int month, int year) {
		if(month == 2) {
			if(checkLeapYear(year))
				return 29;
			else
				return 28;
		}
		else if(month == 4 || month == 6 || month == 9 | month == 11)
			return 30;
		else
			return 31;
	}
	
	/******************************************************************************
	* Function to get the month in the string form
	* 
	* @param month to store the value of the month
	* @return month as string
	******************************************************************************/
	public static String getMonth(int month) {
		switch(month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Invalid";
		}
	}
	
	/******************************************************************************
	* Function to print the calender of the given month and the year
	* 
	* @param dayCode which store from which week day is the month starting
	* @param month to store the value of the month
	* @param year to store the given year
	******************************************************************************/
	public static void printCalender(int dayCode, int month, int year) {
		String[][] calenderArray = new String[7][7];
		int noOfDays = getNoOfDays(month, year);
		System.out.println(getMonth(month));
		System.out.println(year);
		int date = 1;
		calenderArray[0][0] = "Sun ";
		calenderArray[0][1] = "mon ";
		calenderArray[0][2] = "tue ";
		calenderArray[0][3] = "wed ";
		calenderArray[0][4] = "thu ";
		calenderArray[0][5] = "fri ";
		calenderArray[0][6] = "sat ";
		for(int i=1; i<7; i++) {
			for(int j=dayCode; j<7; j++) {
				if(date <= noOfDays) {
					calenderArray[i][j] = date + "";
					date++;
				}
			}
			dayCode = 0;
		}
		for(int i=0; i<=0; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(calenderArray[i][j]);
			}
			System.out.println();
		}
		for(int i=1; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(calenderArray[i][j] != null && calenderArray[i][j].length() == 1) 
					System.out.print(" " + calenderArray[i][j] + "  ");
				else if(calenderArray[i][j] != null)
					System.out.print(" " + calenderArray[i][j] + " ");
				else
					System.out.print("    ");
			}
			System.out.println();
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
	 * Function to add prime number in 2D array list
	 * 
	 * @return 2D array list of the prime numbers
	 ******************************************************************************/
	public static UnorderedLinkedList<UnorderedLinkedList<Integer>> addPrimeNumbersToSet() {
		UnorderedLinkedList<UnorderedLinkedList<Integer>> array = new UnorderedLinkedList<>();
		for(int i=0; i < 10; i++) {
			UnorderedLinkedList<Integer> list = new UnorderedLinkedList<>();
			for(int j=0; j<= 100; j++) {
				int number = i * 100 + j;
				if(primeChecker(number)) {
					list.add(number);
				}
			}
			array.add(list);
		}
		return array;
	}
	
	/******************************************************************************
	 * Function to print the prime number store in the 2D array list
	 * 
	 * @param primeNumberSet to store the list of the prime numbers
	 ******************************************************************************/
	public static void printPrimeNumbers(UnorderedLinkedList<UnorderedLinkedList<Integer>> primeNumberSet) {
		int size=primeNumberSet.size();
		for(int i=0; i<size; i++) {
			UnorderedLinkedList<Integer> list = primeNumberSet.getDataAtIndex(i);
			System.out.println(list.displayElements());
		}
	}
	
	/******************************************************************************
	 * Function to add prime number in a list
	 * 
	 * @return list of the prime numbers
	 ******************************************************************************/
	public static UnorderedLinkedList<Integer> getPrimeNumberList(){
		UnorderedLinkedList<Integer> list = new UnorderedLinkedList<>();
		for(int i=0; i<1000; i++) {
			if(primeChecker(i))
				list.add(i);
		}
		return list;
	}
	
	/*************************************************************************************
	 * Function to check if the two Strings are anagram or not
	 * 
	 * @param s1 to store the first string
	 * @param s2 to store the second string
	 * @return true if the two strings are anagram or else false
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
	 * Function to get Anagram pairs of number
	 * 
	 * @return 2D array list of the prime numbers
	 ******************************************************************************/
	public static void getAnagramPairs () {
		UnorderedLinkedList<UnorderedLinkedList<String>> anagramSet = new UnorderedLinkedList<>();
		int lowerRange = 0;
		int upperRange = 100;
		//UnorderedLinkedList<UnorderedLinkedList<String>> notAnagramSet = new UnorderedLinkedList<>();
		for(int i=0; i < 10; i++) {
			UnorderedLinkedList<String> anagramList = new UnorderedLinkedList<>();
			//UnorderedLinkedList<String> notAnagramList = new UnorderedLinkedList<>();
			for(int j=lowerRange; j<= upperRange; j++) {
				if(j > 10) {
				if(primeChecker(j)) {
					for(int k=j; k<upperRange; k++)
						if(primeChecker(k)) {
							if(checkAnagram(j+"", k+""))
								anagramList.add("["+j+","+k+"]");
						}
				}
			}
				}
			anagramSet.add(anagramList);
				lowerRange = lowerRange + 100;
				upperRange = upperRange + 100;
		}
		int size=anagramSet.size();
		for(int i=0; i<size; i++) {
			UnorderedLinkedList<String> list = anagramSet.getDataAtIndex(i);
			System.out.println(list.displayElements());
		}
	}
	
	public static void getAnagram() {
		UnorderedLinkedList<UnorderedLinkedList<Integer>> primeNumberSet = addPrimeNumbersToSet();
		//System.out.println(primeNumberSet.size());
		UnorderedLinkedList<UnorderedLinkedList<String>> anagramSet = new UnorderedLinkedList<>();
		int size=primeNumberSet.size();
		for(int i=0; i<size; i++) {
			UnorderedLinkedList<Integer> list = primeNumberSet.getDataAtIndex(i);
			UnorderedLinkedList<String> anagramList = new UnorderedLinkedList<>();
			for(int j=0; j<list.size()-1; j++) {
				String string1 = list.getDataAtIndex(j) + "";
				for(int k=j+1; k<list.size(); k++) {
					String string2 = list.getDataAtIndex(k) + "";
					if(checkAnagram(string1, string2))
						anagramList.add("["+string1+","+string2+"]");
				}
			}
		}
		int anagramSize=anagramSet.size();
		System.out.println(anagramSize);
		for(int i=0; i<anagramSize; i++) {
			UnorderedLinkedList<String> list = anagramSet.getDataAtIndex(i);
			System.out.println(list.displayElements());
		}
	}
	
}










