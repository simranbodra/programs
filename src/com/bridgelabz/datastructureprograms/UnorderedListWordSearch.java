package com.bridgelabz.datastructureprograms;

public class UnorderedListWordSearch {

	public static void main(String[] args) {
		SinglyLinkedList wordList = new SinglyLinkedList();
		//wordList.add(1);
		wordList.add("i");
		wordList.add("simran");
		wordList.append("bodra");
		wordList.insert("am",3);
		//wordList.remove("1");
		//System.out.println(wordList.index(1));
		wordList.pop();
		//wordList.display();
		//System.out.println(wordList.search("simran"));
		wordList.display();
	}

}
