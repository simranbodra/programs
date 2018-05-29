package com.bridgelabz.datastructures;

public class Queue <T extends Comparable<T>>{
	private UnorderedLinkedList<T> list;
	
	public Queue() {
		list = new UnorderedLinkedList<T>();
	}
	
	public void enqueue(T item) {
		list.append(item);
	}
	
	public T dequeue() {
		T item = list.pop(0);
		return item;
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
