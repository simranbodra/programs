package com.bridgelabz.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.datastructures.Deque;
import com.bridgelabz.datastructures.HashSet;
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
		if(parenthesisStack.size() == 0 && pushCount == popCount) {
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
		int amount = 1000000;
		while(people.size() > 0) {
			System.out.println("Enter 1 for Cash Deposit");
			System.out.println("Enter 2 for cash withdraw");
			int choice = integerInput();
			switch(choice) {
			case 1:
				System.out.println("Enter the amount to deposit:-");
				int depositAmount = integerInput();
				amount = amount + depositAmount;
				System.out.println("Current money in the bank:-" + amount);
				people.dequeue();
				System.out.println("People in the queue:- " + people.size());
				break;
			
			case 2:
				System.out.println("Enter the amount to be withdrawn:-");
				int withdrawAmount = integerInput();
				if(withdrawAmount > 1000000) {
					System.out.println("Not enought money in the bank");
					System.out.println("Current money in the bank:-" + amount);
					people.dequeue();
					System.out.println("People in the queue:- " + people.size());
				}
				else {
					amount = amount - withdrawAmount;
					System.out.println("Current money in the bank:-" + amount);
					people.dequeue();
					System.out.println("People in the queue:- " + people.size());
				}
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
		else if(month == 4 || month == 6 || month == 9 || month == 11)
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
	* Function to print the calendar of the given month and the year
	* 
	* @param dayCode which store from which week day is the month starting
	* @param month to store the value of the month
	* @param year to store the given year
	******************************************************************************/
	public static void printCalendar(int dayCode, int month, int year) {
		String[][] calendarArray = new String[7][7];
		int noOfDays = getNoOfDays(month, year);
		System.out.println(getMonth(month));
		System.out.println(year);
		int date = 1;
		calendarArray[0][0] = "Sun ";
		calendarArray[0][1] = "Mon ";
		calendarArray[0][2] = "Tue ";
		calendarArray[0][3] = "Wed ";
		calendarArray[0][4] = "Thu ";
		calendarArray[0][5] = "Fri ";
		calendarArray[0][6] = "Sat ";
		for(int i=1; i<7; i++) {
			for(int j=dayCode; j<7; j++) {
				if(date <= noOfDays) {
					calendarArray[i][j] = date + "";
					date++;
				}
			}
			dayCode = 0;
		}
		for(int i=0; i<=0; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(calendarArray[i][j]);
			}
			System.out.println();
		}
		for(int i=1; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(calendarArray[i][j] != null && calendarArray[i][j].length() == 1) 
					System.out.print(" " + calendarArray[i][j] + "  ");
				else if(calendarArray[i][j] != null)
					System.out.print(" " + calendarArray[i][j] + " ");
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
			int listSize = list.size();
			for(int j=0; j<listSize; j++) {
				System.out.printf("%03d%n",(int)list.getDataAtIndex(j));
			}
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
		UnorderedLinkedList<UnorderedLinkedList<String>> notAnagramSet = new UnorderedLinkedList<>();
		for(int i=0; i < 10; i++) {
			UnorderedLinkedList<String> anagramList = new UnorderedLinkedList<>();
			UnorderedLinkedList<String> notAnagramList = new UnorderedLinkedList<>();
			for(int j=lowerRange; j<= upperRange; j++) {
				if(primeChecker(j)) {
					for(int k=0; k<=1000; k++)
						if(primeChecker(k)) {
							if(checkAnagram(j+"", k+"")) {
								if(j != k) {
									anagramList.add("["+j+","+k+"]");
									//System.out.println(j + " " + k);
								}
								
							}
							else
								notAnagramList.add("["+j+","+k+"]");
							}
					}
				}
			anagramSet.add(anagramList);
			notAnagramSet.add(notAnagramList);
				lowerRange = lowerRange + 100;
				upperRange = upperRange + 100;
		}
		System.out.println("Anagram Pairs:-");
		int anagramSize=anagramSet.size();
		for(int i=0; i<anagramSize -1; i++) {
			UnorderedLinkedList<String> list = anagramSet.getDataAtIndex(i);
			System.out.println(list.displayElements());
		}
		System.out.println();
		System.out.println("Non Anagram Pairs");
		int notAnagramSize=anagramSet.size();
		for(int i=0; i<notAnagramSize; i++) {
			UnorderedLinkedList<String> list = notAnagramSet.getDataAtIndex(i);
			System.out.println(list.displayElements());
		}
	}
	
	/******************************************************************************
	 * Function to get Anagram pairs of number using Stack
	 * 
	 * @return 2D array list of the prime numbers
	 ******************************************************************************/
	public static void getAnagramPairsStack() {
		Stack<Stack<String>> anagramSet = new Stack<>();
		int lowerRange = 0;
		int upperRange = 100;
		Stack<Stack<String>> notAnagramSet = new Stack<>();
		for(int i=0; i < 10; i++) {
			Stack<String> anagramList = new Stack<>();
			Stack<String> notAnagramList = new Stack<>();
			for(int j=lowerRange; j<= upperRange; j++) {
				if(j > 10 && primeChecker(j)) {
					for(int k=0; k<=1000; k++)
					if(primeChecker(k)) {
						if(checkAnagram(j+"", k+"")) {
							if(j != k) {
								anagramList.push("["+j+","+k+"]");
								System.out.println(j + " " + k);
							}
						}
						else
							notAnagramList.push("["+j+","+k+"]");
						}
				}
			}
			anagramSet.push(anagramList);
			notAnagramSet.push(notAnagramList);
				lowerRange = lowerRange + 100;
				upperRange = upperRange + 100;
		}
		System.out.println("Anagram Pairs:-");
		int anagramSize=anagramSet.size();
		for(int i=0; i<anagramSize; i++) {
			Stack<String> list = anagramSet.pop();
			int size = list.size();
			for(int j=0; j<size; j++) {
				//System.out.print(list.pop() + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Non Anagram Pairs:-");
		int notAnagramSize=notAnagramSet.size();
		for(int i=0; i<notAnagramSize; i++) {
			Stack<String> list = notAnagramSet.pop();
			int size = list.size();
			for(int j=0; j<size; j++) {
				//System.out.print(list.pop() + " ");
			}
			System.out.println();
		}
	}	
	
	/******************************************************************************
	 * Function to get Anagram pairs of number using Queue
	 * 
	 * @return 2D array list of the prime numbers
	 ******************************************************************************/
	public static void getAnagramPairsQueue() {
		Queue<Queue<String>> anagramSet = new Queue<>();
		int lowerRange = 0;
		int upperRange = 100;
		Queue<Queue<String>> notAnagramSet = new Queue<>();
		for(int i=0; i < 10; i++) {
			Queue<String> anagramList = new Queue<>();
			Queue<String> notAnagramList = new Queue<>();
			for(int j=lowerRange; j<= upperRange; j++) {
				if(j > 10 && primeChecker(j)) {
					for(int k=j; k<upperRange; k++)
						if(primeChecker(k)) {
							if(checkAnagram(j+"", k+""))
								anagramList.enqueue("["+j+","+k+"]");
							else
								notAnagramList.enqueue("["+j+","+k+"]");
						}
					}
			}
			anagramSet.enqueue(anagramList);
			notAnagramSet.enqueue(notAnagramList);
				lowerRange = lowerRange + 100;
				upperRange = upperRange + 100;
		}
		System.out.println("Anagram Pairs:-");
		int anagramSize=anagramSet.size();
		for(int i=0; i<anagramSize; i++) {
			Queue<String> list = anagramSet.dequeue();
			int size = list.size();
			for(int j=0; j<size; j++) {
				System.out.print(list.dequeue() + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Non Anagram Pairs:-");
		int notAnagramSize=notAnagramSet.size();
		for(int i=0; i<notAnagramSize; i++) {
			Queue<String> list = notAnagramSet.dequeue();
			int size = list.size();
			for(int j=0; j<size; j++) {
				System.out.print(list.dequeue() + " ");
			}
			System.out.println();
		}
	}
	
	/******************************************************************************
	* Function to print the calender of the given month and the year using Queue
	* 
	* @param dayCode which store from which week day is the month starting
	* @param month to store the value of the month
	* @param year to store the given year
	******************************************************************************/
	public static void printCalenderQueue(int dayCode, int month, int year) {
		Queue<Queue<String>>calendarQueue = new Queue<>();
		String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		int noOfDays = getNoOfDays(month, year);
		System.out.println(getMonth(month));
		System.out.println(year);
		int date = 1;
		for(int i=0; i<7; i++) {
			if(date <= noOfDays) {
				Queue<String> dateList = new Queue<>();
				if(i==0) {
					for(int k=0; k<7; k++) {
						dateList.enqueue(weekDays[k]);
					}
				}
				else {
					if(i == 1) {
						for(int l=0; l<7; l++) {
							if(l < dayCode) {
								dateList.enqueue("   ");
							}
							else {
								dateList.enqueue(" " + date + " ");
								date++;
							}
						}	
					}
					else {
						for(int j=0; j<7; j++) {
							if(date < 10) {
								dateList.enqueue(" " + date + " ");
								date++;
							}
							else {
								if(date <= noOfDays) {
									dateList.enqueue(date + " ");
									date++;
								}
							}
						}
					}
				}
				calendarQueue.enqueue(dateList);
			}
		}
		int size=calendarQueue.size();
		for(int i=0; i<size; i++) {
			Queue<String> list = calendarQueue.dequeue();
			int s = list.size();
			for(int j=0; j<s; j++) {
				System.out.print(list.dequeue() + " ");
			}
			System.out.println();
		}
	}
	
	/******************************************************************************
	* Function to print the calendar of the given month and the year using Stack
	* 
	* @param dayCode which store from which week day is the month starting
	* @param month to store the value of the month
	* @param year to store the given year
	******************************************************************************/
	public static void printCalenderStack(int dayCode, int month, int year) {
		Stack<Stack<String>> reverseCalendar = new Stack<>();
		Stack<Stack<String>> calendar = new Stack<>();
		String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		int noOfDays = getNoOfDays(month, year);
		System.out.println(getMonth(month));
		System.out.println(year);
		int date = 1;
		for(int i=0; i<7; i++) {
			if(date <= noOfDays) {
				Stack<String> dateList = new Stack<>();
				if(i==0) {
					for(int k=0; k<7; k++) {
						dateList.push(weekDays[k]);
					}
				}
				else {
					if(i == 1) {
						for(int l=0; l<7; l++) {
							if(l < dayCode) {
								dateList.push("   ");
							}
							else {
								dateList.push(" " + date + " ");
								date++;
							}
						}	
					}
					else {
						for(int j=0; j<7; j++) {
							if(date < 10) {
								dateList.push(" " + date + " ");
								date++;
							}
							else {
								if(date <= noOfDays) {
									dateList.push(date + " ");
									date++;
								}
							}
						}
					}
				}
				reverseCalendar.push(dateList);
			}
		}
		int reverseSize= reverseCalendar.size();
		for(int i=0; i<reverseSize; i++) {
			Stack<String> list = reverseCalendar.pop();
			int s = list.size();
			Stack<String> dateStack = new Stack<>();
			for(int j=0; j<s; j++) {
				dateStack.push(list.pop());
			}
			calendar.push(dateStack);
		}
		int size = calendar.size();
		for(int i=0; i<size; i++) {
			Stack<String> list = calendar.pop();
			int s = list.size();
			for(int j=0; j<s; j++) {
				System.out.print(list.pop() + " ");
			}
			System.out.println();
		}
	}
	
	/******************************************************************************
	* Function to find the factorial of the number
	* 
	* @param number of elements
	******************************************************************************/
	public static int factorial(int number) {
		if(number == 1)
			return 1;
		else 
			return number*factorial(number -1);
	}

	/******************************************************************************
	* Function to print the no. of possible binary trees
	* 
	* @param number of elements
	******************************************************************************/
	public static long getNoOfPossibleBinaryTrees(int noOfNodes) {
		long possibleTrees = 0;
		possibleTrees = factorial(2*noOfNodes)/(factorial(noOfNodes+1)*(factorial(noOfNodes)));
		return possibleTrees;
	}
	
}










