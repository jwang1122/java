package com.huaxia.datastructure;

public class LinkedList<T> {
	private Node<T> head; //
	private Node<T> tail; 
	
	public static void main(String[] args) {
		Node<Person> node = new Node<Person>(new Teacher("John"));
		LinkedList<Person> list = new LinkedList<>();
		list.add(node);
		node = new Node<Person>(new Teacher("Rodney"));
		list.add(node);
		Node<Person> node1 = new Node<>(new Teacher("Bob"));
		list.add(node1);
		
		list.insert(node, new Node<Person>(new Teacher("Charles"))); // John, Charles, Rodney
		
		System.out.println(list);		
	}

	public void add(Node<T> node) {
		if(head==null) {
			this.head = node;
			this.tail = node;
		}else {
			tail.setNext(node);
			tail = node;
			node.setNext(null);
		}
	}
	
	public void insert(Node<T> node, Node<T> newNode) { // insert a new node before node : homework1 implement this method
		newNode.setNext(node.getNext());
		node.setNext(newNode);
	}
	
	public Node<T> next(Node<T> node) {
		return node.getNext();
	}
	
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(); // StringBuilder()
		Node<T> current = head;
		while (current.getNext()!=null) {
			result.append(current.getData());
			current = current.getNext(); // feature of linked list 
		}
		result.append(current.getData());
		return result.toString();
	}


}
