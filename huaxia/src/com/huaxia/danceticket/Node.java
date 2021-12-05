package com.huaxia.danceticket;

public class Node<T> {
	T student;
	Node<T> left;
	Node<T> right;
	
	public Node(T student) {
		this.student = student;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "Node [" + student + "]";
	}
	
}
