package com.bridgelabz.datastructureprograms;

public class SinglyLinkedList <T extends Comparable <T>>{
	protected Node start;
	protected Node end;
	protected int size;
	
	public SinglyLinkedList() {
		start = null;
		end = null;
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
    	if(start == null){
            start = newNode;
            end = newNode;
        } else {
            end.setNext(newNode);
            end = newNode;
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
        Node nptr = new Node(value, null);                
        Node ptr = start;
        position = position - 1 ;
        for (int i = 1; i < size; i++) {
            if (i == position) {
                Node tmp = ptr.getNext() ;
                ptr.setNext(nptr);
                nptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++ ;
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
    	if(temp != null && temp.data == item)
    		return true;
    	while(temp != null && temp.data != item) {
    		temp = temp.next;
    	}
    	if(temp.data != item)
    		return false;
    	else
    		return true;
    }
    
    public int index(T item) {
    	int position = 0;
    	Node temp = start;
    	if(temp != null && temp.data == item) {
    		return position++;
    	}
    	while(temp != null && temp.data != item) {
    		temp = temp.getNext();
    		position++;
    	}
    	if(temp.data != item)
    		return position;
    	else
    		return position;
    }
    
    public T pop() {
    	Node temp = start, prev = null;
    	while(temp != null) {
    		prev = temp;
    		temp = temp.next;
    	}
    	T removedData = (T)temp.getData();
    	prev.next = temp.next;
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




















