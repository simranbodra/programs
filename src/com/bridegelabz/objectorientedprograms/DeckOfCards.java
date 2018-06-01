package com.bridegelabz.objectorientedprograms;

import com.bridgelabz.utils.Utility;

public class DeckOfCards {

	public static void main(String[] args) {
		String[][] deckOfCards = Utility.printDeckOfCards();
		Utility.shuffleCards(deckOfCards);
	}

}
