/******************************************************************************
 *  
 *  Purpose: to search the word from the wordlist
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class WordSearch {

	public static void main(String[] args) {
		String[] wordList = Utility.readWordListFile();
		System.out.println("Enter the words to be searched:-");
		String word = Utility.stringInput();
		Utility.searchWord(wordList, word);
	}
}
