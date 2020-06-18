package com.huaxia.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		QueueTest test = new QueueTest();
		
		test.queueProcessTest(queue);
	}
	
	void queueProcessTest(Queue<String> queue) {
		queue.add("element 1");
		queue.offer("element 2");
		System.out.println(queue);
		String element1 = queue.poll();
		System.out.println(element1);
		System.out.println(queue);
		String element2 = queue.remove();
		System.out.println(element2);
		System.out.println(queue);		
	}
	
}
