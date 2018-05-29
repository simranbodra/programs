package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructures.UnorderedLinkedList;
import com.bridgelabz.utils.Utility;

public class UnorderedListWordSearch {

	public static void main(String[] args) {
		UnorderedLinkedList wordList = new UnorderedLinkedList();
		String words = Utility.readListFile("wordList.text");
		String[] stringArray = Utility.splitString(words);
		wordList = Utility.addWordsToList(stringArray);
		wordList.display();
		System.out.println("Enter the word to search");
		String searchElement = Utility.stringInput();
		wordList = Utility.searchWord(wordList,searchElement);
		wordList.display();
	}

}
