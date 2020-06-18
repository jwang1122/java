package com.huaxia.test;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		StackTest test = new StackTest();
		Stack<Integer> stack = new Stack<Integer>();
		test.pushTest(stack, 5);
		test.pushTest(stack, 10);
		test.pushTest(stack, 15);
		test.peekTest(stack);
		test.seachTest(stack, 10);
		test.popTest(stack);
		System.out.println(stack.isEmpty());
		System.out.println("Current stack: "+ stack);
		while(!stack.isEmpty()) {
			int i = stack.pop();
			System.out.println(i);
			System.out.println("Current stack: "+ stack);
		}
	}

	private void popTest(Stack<Integer> stack) {
		System.out.println("Current stack: " + stack);
		Integer item = stack.pop();
		System.out.printf("Item %s is pop out.\n", item);
		System.out.println("Current stack: " + stack);
	}

	private void seachTest(Stack<Integer> stack, int i) {
		Integer pos = stack.search(i);
		if (pos == -1) {
			System.out.println("Element not found.");
		} else {
			System.out.printf("Element %s is found at position: %d.\n", i, pos);
		}
	}

	private void peekTest(Stack<Integer> stack) {
		Integer i = stack.peek();
		System.out.printf("The item %d is on stack top.\n",i);
		System.out.println("Current stack: " + stack);
	}

	private void pushTest(Stack<Integer> stack, int i) {
		stack.push(i);
		System.out.printf("Current Stack: %s", stack);
		System.out.println();
	}

}
