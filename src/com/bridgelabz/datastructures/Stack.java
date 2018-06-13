package com.bridgelabz.datastructures;


public class Stack<T> {
	private UnorderedLinkedList<T> list;
	public Stack() {
		list = new UnorderedLinkedList<T>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	public void push(T item) {
		list.append(item);
	}
	
	public T pop() {
		T item = list.pop();
		return item;
	}
	
	public T peek() {
		if(list.isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return list.getDataAtIndex(0);
	}
	
	public void display() {
		list.display();
	}
}
