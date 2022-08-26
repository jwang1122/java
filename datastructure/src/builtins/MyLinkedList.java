package builtins;

import java.util.LinkedList;

public class MyLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		System.out.println(list.peek());
		Integer i1 = list.getFirst();
		System.out.println(i1);
	}

}
