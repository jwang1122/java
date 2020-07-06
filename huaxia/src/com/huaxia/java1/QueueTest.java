package com.huaxia.java1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		QueueTest test = new QueueTest();

		test.queueProcessTest(queue);
		test.example();
	}

	private void example() {
		Queue<Integer> q = new LinkedList<>();
		q.add(6);
		q.add(1);
		q.add(8);
		q.add(4);
		q.add(7);
		System.out.println("The queue is: " + q);
		int num1 = q.remove();
		System.out.println("The element deleted from the head is: " + num1);
		System.out.println("The queue after deletion is: " + q);
		int head = q.peek();
		System.out.println("The head of the queue is: " + head);
		int size = q.size();
		System.out.println("The size of the queue is: " + size);

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
