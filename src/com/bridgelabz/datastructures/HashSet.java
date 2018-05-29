package com.bridgelabz.datastructures;

public class HashSet {
	public OrderedLinkedList[] array; 
	private int size;
	
	public HashSet(int size) {
		this.size = size;
		array = new OrderedLinkedList[size+1];
		for(int i=0; i < size; i++) {
			array[i] = new OrderedLinkedList();
		}
	}
	public void add(int item) {
		int position = item%(size+1);
		array[position].add(item);
	}
	
	public void remove(int item) {
		int position = item%(size+1);
		array[position].remove(item);
	}
	
	public boolean search(int item) {
		int position = item%(size+1);
		if(array[position].search(item))
			return true;
		else
			return false;
	}
	
	public void display() {
		for(int i=0; i< size; i++) {
        while(true){
            if(array[i] == null){
                break;
            }
            System.out.println(array[i].getData());
            array[i] = array[i].getNext();
        }
		}
	}
	
}
 