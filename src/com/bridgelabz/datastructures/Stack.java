package com.bridgelabz.datastructures;


public class Stack<T extends Comparable<T>> {
	protected Node<T> start;
	protected int size;
	
	public Stack() {
		start = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		if(start == null) {
			start = newNode;
		}
		else {
			newNode.setNext(start);
			start = newNode;
		}
	}
	
	public T pop() {
		if(start == null) {
			return null;
		}
		Node<T> temp = start;
		start = start.getNext();
		return temp.getData();
	}
	
	public T peek() {
		if(start == null) {
			System.out.println("Stack is empty");
			return null;
		}
		return start.getData();
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
}
