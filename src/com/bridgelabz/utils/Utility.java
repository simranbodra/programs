package com.bridgelabz.utils;

import java.io.File;
//import java.io.PrintStream;
//import java.lang.reflect.Array;
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
	public static <T extends Comparable<T>> UnorderedLinkedList<T> addWordsToList(T[] array) {
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
	public static <T extends Comparable<T>> boolean addParenthesisToStack(String expression) {
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
	public static <T extends Comparable<T>> Queue<T> addToQueue(int noOfPerson) {
		Queue<T> people = new Queue<T>();
		for(int i=1; i<=noOfPerson; i++) {
			people.enqueue((T)("person" + i));
		}
		return people;
	}

	public static <T extends Comparable<T>>void cashCounter(Queue<T> people) {
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

	public static <T extends Comparable<T>> boolean checkForPalindrom(String string) {
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
		HashSet numberSet = new HashSet(10);
		for(int i=0; i<array.length; i++) {
			numberSet.add(Integer.parseInt(array[i]));
		}
		numberSet.display();
		return numberSet;
	}
	
	/******************************************************************************
	 * Function to search the number on the HashSet
	 * 
	 * @param list which contains the elements
	 * @param searchElement which contains the element to be searched in the list
	 * @return list which contains the modified list of elements
	 ******************************************************************************/
	public static HashSet searchNumberFromSet(HashSet numberSet, int searchElement) {
		System.out.println(numberSet.search(searchElement));
		if(numberSet.search(searchElement)) {
			numberSet.remove(searchElement);
		}
		else {
			numberSet.add(searchElement);
		}
		return numberSet;
	}
	
}
