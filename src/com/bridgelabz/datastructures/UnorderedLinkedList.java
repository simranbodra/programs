package com.bridgelabz.datastructures;

public class UnorderedLinkedList <T>{
	protected Node<T> start;
	protected int size;
	
	public UnorderedLinkedList() {
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
    	Node<T> newNode = new Node<T>(value);
    	Node<T> temp = start;
    	if(start == null){
            start = newNode;
            size++;
        } else {
            while(temp.getNext() != null) 
            	temp = temp.getNext();
            temp.setNext(newNode);
            size++;
        }
    }
    
    public void addFront(T value) {
    	Node<T> newNode = new Node<T>(value);
    	if(start == null){
            start = newNode;
            size++;
        } else {
            newNode.setNext(start);
            start = newNode;
            size++;
        }
    }
    
    public void append(T value) {
        Node<T> newNode = new Node<T>(value);  
        Node<T> temp = start;   
        if(start == null) {
            start = newNode;
            size++;
            return;
        }
        else {
        	while(temp.getNext() != null)
        		temp = temp.getNext();
        	temp.setNext(newNode);
        	size++;
        }
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
    	if(temp!= null && temp.getData().equals(item)) {
    		start = temp.getNext();
    		size--;
    		return;
    	}
    	while(temp != null && !temp.getData().equals(item)) {
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
    		if((temp.getData()).equals(item))
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
    		if((temp.getData()).equals(item)) {
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
    	Node<T> temp = start;
    	Node<T> prev = null;
    	if(start == null)
    		return null;
    	if(start.getNext() == null) {
    		start.setNext(null);
    		size--;
    		return temp.getData();
    	}
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
    	Node<T> temp = start;
    	Node<T> prev =null;
    	int index = 0;
    	if(start==null) return null;
    	if(position == 0) {
    		start = temp.getNext();
    		size--;
    		return temp.getData();
    	}
    	if(temp.getNext()==null) return temp.getData();
    	while(temp.getNext() != null && index != position) {
    		prev=temp;
    		temp = temp.getNext();
    		index++;
    	}
    	prev.setNext(temp.getNext());
    	T removedData = temp.getData();
    	return removedData;
    }
    
    public T getDataAtIndex(int index) {
    	int currentPosition = 0;
    	Node<T> temp = start;
    	if(start == null)
    		return null;
    	if(temp.getNext()==null) return temp.getData();
    	else {
    		while(temp.getNext() != null && currentPosition != index) {
    			temp = temp.getNext();
    			currentPosition++;
    		}
    		return temp.getData();
    	}
    }
    
    public void display() {
    	Node<T> temp = start;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
		
	}
    
    public String displayElements() {
		String string = "";
		Node<T> temp = start;
		while(temp.getNext() != null) {
			string += temp.getData() + " ";
			temp = temp.getNext();
		}
		return string;
	}
    
}





















