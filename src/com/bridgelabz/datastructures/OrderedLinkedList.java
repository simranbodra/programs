package com.bridgelabz.datastructures;

public class OrderedLinkedList<T extends Comparable<T>>{
	private Node<T> start;
	private int size;
	
	public OrderedLinkedList() {
		start = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int size() {
		return size;
	}
	
    public void add (T value) {
    	Node<T> newNode = new Node<T>(value);
    	
    	if(start == null || start.getData().compareTo(value)>0){
            newNode.setNext(start);
    		start = newNode;
            size++;
            return;
        } 
    	Node<T> temp = start;    
    	while(temp.getNext() != null && temp.getNext().getData().compareTo(value) < 0) {
            		temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
        return;
        
}
    
    public void append(T value) {
    	Node<T> newNode = new Node<T>(value);
    	
    	if(start == null || start.getData().compareTo(value)>0){
            newNode.setNext(start);
    		start = newNode;
            size++;
            return;
        } 
    	Node<T> temp = start;    
    	while(temp.getNext() != null && temp.getNext().getData().compareTo(value) < 0) {
            		temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
        return;
    }
    
    public void insert(T value , int position) {
     Node<T> newNode = new Node<T>(value);
     Node<T> temp = start;
     Node<T> prev = null;
     int currentPosition = 0; 
     if(temp == null ) {
    	 start = newNode;
    	 size++;
    	 return;
     }
     while(temp.getNext() != null && currentPosition != position) {
    	 prev = temp;
    	 temp = temp.getNext();
    	 currentPosition++;
     }
     prev.setNext(newNode);
     newNode.setNext(temp);
    }
    
    public void remove(T item) {
    	Node<T> temp = start, prev = null;
    	if(temp!= null && temp.getData().compareTo(item) == 0 ) {
    		start = temp.getNext();
    		size--;
    		return;
    	}
    	while(temp != null && temp.getData().compareTo(item) != 0) {
    		prev = temp;
    		temp = temp.getNext();
    	}
    	if(temp == null)
    		return;
    	prev.setNext(temp.getNext());
    	size--;
    }
    
    public boolean search(T item) {
    	Node<T> temp =start;
    	while(temp != null) {
    		if((temp.getData()).compareTo(item) == 0)
    			return true;
    		else
    			temp = temp.getNext();
    	}
    	return false;
    }
    
    public int index(T item) {
    	int position = 1;
    	Node<T> temp = start;
    	while(temp != null) {
    		if((temp.getData()).compareTo(item) == 0) {
    			position = position + 1;
    			return position;
    		}
    		else {
    			temp = temp.getNext();
    			position++;
    		}
    	}
    	return position;
    }
    
    public T pop() {
    	Node<T> temp = start, prev = null;
    	while(temp.getNext() != null) {
    		prev = temp;
    		temp = temp.getNext();
    	}
    	T removedData = temp.getData();
    	prev.setNext(null);
    	size--;
    	return removedData;
    }
    
    public T pop(int position) {
    	Node<T> temp = start, prev = null;
    	T removedData = temp.getData();
    	int currentIndex = 1;
    	if(temp.getNext() != null && currentIndex == position) {
    		start = temp.getNext();
    	}
    	while(temp.getNext() != null && currentIndex != position) {
    		prev = temp;
    		temp = temp.getNext();
    		currentIndex++;
    	}
    	if(currentIndex == position)
    		removedData = temp.getData();
    	prev.setNext(temp.getNext());
    	size--;
    	return removedData;
    }
    
    public void display() {
    	Node<T> tmp = start;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }
    
    public String displayElement() {
    	Node<T> temp = start;
    	String string = "";
    	while(temp != null) {
    		string += temp.getData() + " ";
    		temp = temp.getNext();
    	}
    	return string;
    }
    
 }




















