package foundation.week13;

public class MyLinkedList {
	
	//Implementing Singly Linked List
	
	Node head, tail;
	private int size = 0;
	

	public void add(int data) {
			if(head==null) {
				head = tail = new Node(data);
			}else {
				tail.next = new Node(data);
				tail = tail.next;
				}
			size++;
	}
	
	public void addAll(int[] data) {
		for (int i = 0; i < data.length; i++) {
			if(head==null) {
				head = tail = new Node(data[i]);
			}else {
				tail.next = new Node(data[i]);
				tail = tail.next;
				}
			size++;
		}
	}
	
	public int get(int index) {
		if(index>size)
			throw new IndexOutOfBoundsException();
		Node temp = head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		return temp.value;
	}
	
	public int size() {
		return size;
	}
	
	public void remove(int index) {
		if(index>size)
			throw new IndexOutOfBoundsException();
		Node next =	 head;
		Node previousNode;
		for(int i=0; i<index; i++) {
			
			next = next.next;
		}
		previousNode = next;
		next = next.next;
//		previousNode.next = next;
		size--;
		
	}
	
	public void remove1(int index) {
		 if(index>size)
	            throw new IndexOutOfBoundsException();
	        Node temp = head;
	        for(int i=0; i<index-1; i++) {
	            temp = temp.next;
	        }
	        temp.next = temp.next.next;
	        size--;
	}
	
	/*
	initialize a listNode variable currentNode and assign head
	intitialize a listNode varaible previousNode = null
	iterate until currentNode ne null
	check if currentNode.val eq val
	    if yes then check previousNode eq null //to handle if head contains the value to be remeoved
	        if yes then assing currentNode = currentNode.next
	    if no, then check if currentNode.next eq null // to handle if tail contains the value to be removed
	        if yes then assign previousNode.next = null
	        if no then assign previousNode.next = currentNode.next //to handle any other node having the value to be removed
	    assign currentNode = currentNode.next;
	if No then,
	    assign previouse = currentNode & currentNode = currentNode.next
	*/
	public void removeAll(int val) {
		Node currentNode = this.head, previousNode = null;
		while(currentNode!=null) {
			if(currentNode.value==val) {
				if(previousNode==null) {
					currentNode = currentNode.next;
				} else if(currentNode.next==null) {
					previousNode.next = null;
				} else {
					previousNode.next = currentNode.next;
				}
				currentNode = currentNode.next;
			} else {
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
		}
	}
	
	public void removeAll_optimised(int val) {
		while(head.value==val) {
			head= head.next;
			size--;
		}
		Node currentNode = head;
		while(currentNode!=null) {
			if(currentNode.next.value==val) {
				currentNode.next = currentNode.next.next;
				size--;
			}
			currentNode = currentNode.next;
		}
	}
	
	Node node(int index) {
		Node currentNode = head;
		for(int i=0; i<index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	public MyLinkedList clone() {
		MyLinkedList clone = new MyLinkedList();
		clone.head = clone.tail = null;
		clone.size = 0;
		Node temp = this.head;
		for(int i=0; i<size; i++) {
			clone.add(temp.value);
			temp = temp.next;
		}
		return clone;
	}
	
	public void reverse() {
		Node curr = head, prev = null, next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next; 
		}
	}
	
	public static class Node {
		
		int value;
		Node next;
		
		public Node(int data){
			this.value = data;
			this.next = null;
		}

	}

}
