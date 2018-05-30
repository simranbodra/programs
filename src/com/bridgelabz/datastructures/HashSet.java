package com.bridgelabz.datastructures;

public class HashSet {
	public OrderedLinkedList[] array; 
	private int size;
	
	public HashSet(int size) {
		this.size = size;
		array = new OrderedLinkedList[size];
		for(int i=0; i < array.length; i++) {
			array[i] = new OrderedLinkedList();
		}
	}
	public void add(int item) {
		int position = item%(size);
		array[position].add(item);
	}
	
	public void remove(int item) {
		int position = item%(size);
		array[position].remove(item);
	}
	
	public boolean search(int item) {
		int position = item%(size);
		if(array[position].search(item))
			return true;
		else
			return false;
	}
	
	public int size() {
		return size;
	}

	
	public void display() {
		for(int i=0; i< array.length; i++) {
			OrderedLinkedList list = array[i];
			System.out.print(array[i].displayElement());
		}
		System.out.println();
	}
	
	public String displayElements() {
		String string = "";
		for(int i=0; i< array.length; i++) {
			OrderedLinkedList list = array[i];
			string += array[i].displayElement() + " ";
		}
		return string;
	}
	
}
 