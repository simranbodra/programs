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

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
	
	/****************************************************************************************
	 * Function to take replace a string using regular expression
	 * 
	 * @param message stores the string to be manipulated
	 ****************************************************************************************/
	public static void messageReplace(String message) {

		Date date = new Date();
		DateFormat sysDate = new SimpleDateFormat("dd/mm/yyyy");
		String systemDate = sysDate.format(date);
		String replacedMessage = "";
		Pattern namePattern = Pattern.compile(REGEX_NAME);
		Pattern fullNamePattern = Pattern.compile(REGEX_FULLNAME);
		Pattern mobileNumberPattern = Pattern.compile(REGEX_MOBILE_NUMBER);
		Pattern datePattern = Pattern.compile(REGEX_DATE);
		Matcher mname = namePattern.matcher(message);
		System.out.println("Enter first name:-");
		String firstName = stringInput();
		replacedMessage = mname.replaceAll(firstName);
		
		System.out.println("Enter last name:-");
		String lastName = stringInput();

		Matcher fullName = fullNamePattern.matcher(replacedMessage);
		replacedMessage = fullName.replaceAll(firstName+ " " + lastName);

		System.out.println("Enter mobile number:-");
		String number = stringInput();
		Matcher mobileNumber = mobileNumberPattern.matcher(replacedMessage);
		replacedMessage = mobileNumber.replaceAll(number);
		
		Matcher dateMatcher = datePattern.matcher(replacedMessage);
		replacedMessage = dateMatcher.replaceAll(systemDate);
		System.out.println(replacedMessage);
	}
	
	/****************************************************************************************
	 * Function to print the arranged deck of cards
	 * 
	 * @return String two dimensional array
	 ****************************************************************************************/
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
	
	/****************************************************************************************
	 * Function to shuffle cards and distribute 9 cards to each 4 players
	 * 
	 * @param deckOfCards which contains all the cards in arranged order
	 ****************************************************************************************/
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
		while(suffledCards.size() < 36) {
			index = random.nextInt(cardsList.size());	
			suffledCards.add(cardsList.pop(index));
			suffledCount++;
		}
		//System.out.println(suffledCards.size());
		//suffledCards.display();
		System.out.println(suffledCount);
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
	
	/****************************************************************************************
	 * Function to write java object to json file
	 * 
	 * @param fileName which stores the file location
	 * @param javaObject which is to be written in a json file
	 * @throws IOException 
	 ****************************************************************************************/
	public static void javaToJsonObject(String fileName, Object javaObject) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(fileName), javaObject);
		//String inventoryInformation = mapper.defaultPrettyPrintingWriter().writeValueAsString(javaObject);
		//System.out.println(inventoryInformation);
		System.out.println("json file created");
	}
	
}