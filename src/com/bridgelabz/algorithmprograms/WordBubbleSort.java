/******************************************************************************
 *  
 *  Purpose: to sort the word from the wordlist file using Bubble sort
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utils.Utility;

public class WordBubbleSort {

	public static void main(String[] args) {
		String[] words = Utility.readWordListFile();
		Utility.wordBubbleSort(words);
	}

}
