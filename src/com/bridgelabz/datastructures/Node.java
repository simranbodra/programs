package com.bridgelabz.datastructures;

public class Node <T> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
    public void setNext(Node<T> n){
    	next = n;
    }    
	
    public void setData(T d){
    	data = d;
    }  
    
    public Node<T> getNext(){
        return next;
    } 
    
    public T getData() {
    	return data;
    }
        
	public String toString() {
		return data + "";
	}
}

