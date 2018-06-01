package com.bridgelabz.datastructures;

public class Deque<T> {
private UnorderedLinkedList<T> list;
	
	public Deque() {
		list = new UnorderedLinkedList<T>();
	}
	
	public void addFront(T item) {
		list.addFront(item);
	}
	
	public void addRear(T item) {
		list.append(item);
	}
	
	public T removeFront() {
		return list.pop(0);
	}
	
	public T removeRear() {
		return list.pop();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	public void display() {
		list.display();
	}
}
