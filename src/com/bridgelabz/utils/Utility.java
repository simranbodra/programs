/******************************************************************************
 *  
 *  Purpose: to store all the functions
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.utils;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.datastructures.UnorderedLinkedList;

public class Utility {

	/*
	 * Static Variable is declared to create static object of Scanner class
	 */
	static Scanner scanner = new Scanner(System.in);
	private static final String REGEX_NAME = "<<name>>";
	private static final String REGEX_FULLNAME = "<<full name>>";
	private static final String REGEX_MOBILE_NUMBER = "XXXXXXXXXX";
	private static final String REGEX_DATE = "XX/XX/XXXX";

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

	public static void messageReplace(String message) {
		String replacedMessage = "";
		Pattern namePattern = Pattern.compile(REGEX_NAME);
		Pattern fullNamePattern = Pattern.compile(REGEX_FULLNAME);
		Pattern mobileNumberPattern = Pattern.compile(REGEX_MOBILE_NUMBER);
		Pattern datePattern = Pattern.compile(REGEX_DATE);
		Matcher mname = namePattern.matcher(message);
		replacedMessage = mname.replaceAll("Simran");

		Matcher fullName = fullNamePattern.matcher(replacedMessage);
		replacedMessage = fullName.replaceAll("Simran Bodra");

		Matcher mobileNumber = mobileNumberPattern.matcher(replacedMessage);
		replacedMessage = mobileNumber.replaceAll("7751886716");
		
		Matcher date = datePattern.matcher(replacedMessage);
		replacedMessage = date.replaceAll("31/05/2018");
		System.out.println(replacedMessage);
	}

	public static String[][] printDeckOfCards() {
		String[] cardsType = new String[4];
		String[] cards = {"King", "Queen", "Joker", "10", "9", "8", "7", "6", "5", "4","3", "2", "Ace"};
		String[][] deckOfCards = new String[4][13];
		cardsType[0] = "Clubs";
		cardsType[1] = "Hearts";
		cardsType[2] = "Spades";
		cardsType[3] = "Diamonds";
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				deckOfCards[i][j] = cardsType[i].charAt(0) + cards[j];
			}
		}
		for(int i=0; i<4; i++) {
			System.out.print(cardsType[i] + "==> ");
			for(int j=0; j<13; j++) {
				System.out.print(deckOfCards[i][j] + " ");
			}
			System.out.println();
		}
		return deckOfCards;
		
	}

	public static void shuffleCards(String[][] deckOfCards) {
		UnorderedLinkedList<String> cardsList = new UnorderedLinkedList<>();
		UnorderedLinkedList<String> suffledCards = new UnorderedLinkedList<>();
		String[][] suffledCardsArray = new String[4][13];
		Random random = new Random();
		int index = 0;
		int suffledCount = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				cardsList.add(deckOfCards[i][j]);
			}
		}
		while(suffledCards.size() < 38) {
			index = random.nextInt(cardsList.size());	
			suffledCards.add(cardsList.pop(index));
			suffledCount++;
		}
		//System.out.println(suffledCards.size());
		//suffledCards.display();
		//System.out.println(suffledCount);
		for(int i=0; i<4; i++) {
			for(int j=0; j<9; j++) {
			suffledCardsArray[i][j] = suffledCards.pop();
			}
		}
		System.out.println();
		for(int i=0; i<4; i++) {
			System.out.print("Player" + i + "==>");
			for(int j=0; j<9; j++) {
				System.out.print(suffledCardsArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}