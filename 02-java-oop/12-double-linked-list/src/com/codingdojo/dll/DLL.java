package com.codingdojo.dll;

public class DLL {
    public Node head;
    public Node tail;
    
    private int size;
    
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        this.size++;
    	if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        System.out.println("\n-----");
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    
    public void printValuesBackwards() {
    	Node current = this.tail;
    	System.out.println("\n-----");
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    
    public Node pop() {
    	if(this.size == 0) {
    		return null;
    	} else if (this.size == 1) {
    		this.size--;
    		Node deleted = this.head;
    		this.head = null;
    		this.tail = null;
    		return deleted;
    	} else {
    		this.size--;
    		Node prev = this.tail.previous;
    		Node deleted = this.tail;
    		prev.next = null;
    		this.tail = prev;
    		return deleted;
    	}
    }
    
    public boolean contains( int value) {
    	Node current = this.head;
        while(current != null) {
        	if(current.value == value) {
        		return true;
        	}
            current = current.next;
        }
        return false;
    }
    
    public void insertAt(Node newNode, int index) {
    	if(index > this.size || index < 0) {
    		return;
    	}
    	
    	if(index == 0) {
    		this.head.previous = newNode;
    		newNode.next = this.head;
    		this.head = newNode;
    	} else if(index == this.size) {
    		this.tail.next = newNode;
    		newNode.previous = this.tail;
    		this.tail = newNode;
    	} else {
    		Node oldNodeAtIndex = this.head;
    		
    		for(int i = 0; i < index; i++) {
    			oldNodeAtIndex = oldNodeAtIndex.next;
    		}
    		
    		Node prev = oldNodeAtIndex.previous;
    		prev.next = newNode;
    		newNode.previous = prev;
    		newNode.next = oldNodeAtIndex;
    		oldNodeAtIndex.previous = newNode;    		
    	}
    	this.size++;
    }
    
    public void removeAt(int index) {
    	if(index >= this.size || index < 0) {
    		return;
    	}
    	if(this.size == 1) {
    		this.tail = null;
    		this.head = null;
    	} else if(index == 0) {
			this.head = this.head.next;
			this.head.previous = null;
    	} else if(index == this.size-1) {
    		this.tail = this.tail.previous;
    		this.tail.next = null;
    	} else {
    		Node toRemove = this.head;
    		
    		for(int i = 0; i < index; i++) {
    			toRemove = toRemove.next;
    		}
    		toRemove.previous.next = toRemove.next;
    		toRemove.next.previous = toRemove.previous;
    	}
    	this.size--;
    	
    }
    
    public int size() {
    	return this.size;
    }
}