package com.huaxia.datastructure;

import java.util.Collections;
import java.util.LinkedList;

public class Test {
	
	public static void main(String[] args) {
		linkedListTest();
		stackTest();
		queueTest();
		
	}

	static void linkedListTest() {
		LinkedList<Teacher> list = new LinkedList<>();
		Teacher t1 = new Teacher("Rodney","111"); // top of stack represent of the list, first in linked list
		Teacher t2 = new Teacher("John","111");
		Teacher t3 = new Teacher("Charles","111"); // bottom of the stack
		list.add(t1);
		list.add(t2);
		list.add(t3);
		System.out.println(list);
		Teacher t = list.poll();
		System.out.println(t);
		Collections.sort(list);
		System.out.println(list);
		list.push(new Teacher("Bob","222"));
		t = list.pop();
		System.out.println(t);
		
	}
	
	static void queueTest() {
		// use LinkedList as Queue(FIFO (first-in-first-out)): add() and pop()
		// Queue (FIFO)
		LinkedList<Teacher> list = new LinkedList<>();
		Teacher t1 = new Teacher("Rodney","111"); // top of stack represent of the list, first in linked list
		Teacher t2 = new Teacher("John","111");
		Teacher t3 = new Teacher("Charles","111"); // bottom of the stack
		list.add(t1);
		list.add(t2);
		list.add(t3);
		Teacher t = list.pop();
		System.out.println(t);
		System.out.println(list);
		t = list.pop();
		System.out.println(t);
		System.out.println(list);
		
	}
	
	static void stackTest() {
		// use LinkedList as Stack(last-in-first-out (LIFO)): push() and pop()
		LinkedList<Integer> iList = new LinkedList<>();
		iList.push(2);
		iList.push(3);
		iList.push(4);
		int value = iList.pop();
		System.out.println(value);
		System.out.println(iList);
	}
}

