package com.bridgelabz.datastructureprograms;

public class SinglyLinkedList <T extends Comparable <T>>{
	protected Node start;
	protected int size;
	
	public SinglyLinkedList() {
		start = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int size() {
		return size;
	}
	
    public void add(T value) {
    	Node newNode = new Node(value, null);
    	Node temp = start;
    	if(start == null){
            start = newNode;
        } else {
            while(temp != null) {
            	
            }
        }
    }
    
    public void append(T value) {
        Node newNode = new Node(value,null);  
        Node temp = start;
        size++ ;    
        if(start == null) {
            start = newNode;
            end = start;
        }
        else {
        	end.setNext(newNode);
            end = newNode;
        }
    }
    
    public void insert(T value , int position) {
        Node newNode = new Node(value, null); 
        Node temp = start;
        if(temp == null && position != 0) { //if head is null and position is zero skip it.
            return;
          } else if(temp == null && position == 1) { // if head null and position is zero set at the head.
            temp = newNode;
          }
         
          if(position == 1) { // if position is zero then new node set at the head.
            newNode.next = temp;
            this.start = newNode;
          }
         
          Node current = temp;
          Node previous = null;
          int i = 1;
         
          while(i < position) { //loop until find the given position.
            previous = current;
            current = current.next;
            if(current == null)
              break;
              i++;
            }
         
            newNode.next = current; //get the new node and linked the remaining nodes in the list.
            previous.next = newNode;
    }
    
    public void remove(T item) {
    	Node temp = start, prev = null;
    	if(temp!= null && temp.data!=item) {
    		start = temp.next;
    		size--;
    		return;
    	}
    	while(temp != null && temp.data != item) {
    		prev = temp;
    		temp = temp.next;
    	}
    	if(temp == null)
    		return;
    	prev.next = temp.next;
    	size--;
    }
    
    public boolean search(T item) {
    	Node temp =start;
    	while(temp != null) {
    		if((temp.data).equals(item))
    			return true;
    		else
    			temp = temp.next;
    	}
    	return false;
    }
    
    public int index(T item) {
    	int position = 1;
    	Node temp = start;
    	while(temp != null) {
    		if((temp.data).equals(item)) {
    			position = position + 1;
    			return position;
    		}
    		else {
    			temp = temp.next;
    			position++;
    		}
    	}
    	return position;
    }
    
    public T pop() {
    	Node temp = start, prev = null;
    	while(temp != null) {
    		prev = temp;
    		temp = temp.next;
    	}
    	T removedData = (T)prev.getData();
    	prev.next = null;
    	size--;
    	return removedData;
    }
    
    public T pop(int position) {
    	Node temp = start, prev = null;
    	T removedData = (T)temp.getData();
    	int currentIndex = 1;
    	if(temp!= null && currentIndex == position) {
    		start = temp.next;
    	}
    	while(temp != null && currentIndex != position) {
    		prev = temp;
    		temp = temp.next;
    		currentIndex++;
    	}
    	if(temp == null && currentIndex == position)
    		removedData = (T)temp.getData();
    	prev.next = temp.next;
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
}




















