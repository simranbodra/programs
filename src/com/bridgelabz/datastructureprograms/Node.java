package com.bridgelabz.datastructureprograms;

public class Node<J> {
	protected J data;
	protected Node next;
	
	public Node(J data, Node next) {
		this.data = data;
		this.next = next;
	}
	
    public void setNext(Node n){
    	next = n;
    }    
	
    public void setData(J d){
    	data = d;
    }  
    
    public Node getNext(){
        return next;
    } 
    
    public J getData() {
    	return data;
    }
        
	public String toString() {
		return data + "";
	}
}
