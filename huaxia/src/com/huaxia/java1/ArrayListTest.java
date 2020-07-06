package com.huaxia.java1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
	static final String[] type = { "Glass", "Paper", "Plastic", "China" };

	public static void main(String[] args) throws IOException {
		ArrayListTest test = new ArrayListTest();
		ArrayList<Integer> myInts = test.createIntegerArrayList();
		System.out.println(myInts);
		System.out.println(myInts.size());
		ArrayList<String> cupTypes = test.arrayToArrayList();
		System.out.println(cupTypes);
		test.createObjectArrayList();
		test.insertItemIntoArrayList();
		test.removeItemFromArrayList();
		test.replaceItemInArrayList();
		test.numberOfElementsInArrayList();
		test.findPosition();
		test.clearArrayList();
		test.writeObjectArrayListToFile();
	}
	
	private void clearArrayList() {
		ArrayList<String> cupTypes = arrayToArrayList();
		System.out.println(cupTypes);
		cupTypes.clear();
		System.out.println(cupTypes.isEmpty());		
	}

	private void findPosition() {
		ArrayList<String> cupTypes = arrayToArrayList();
		int position = cupTypes.indexOf("Plastic");
		System.out.println(position);
	}

	private void numberOfElementsInArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		int numOfItem = list.size();
		System.out.println(numOfItem);
	}

	private void replaceItemInArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.set(3,15);
		System.out.println(list);
	}

	private void removeItemFromArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.remove(3);
		System.out.println(list);
	}

	private void insertItemIntoArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.add(3,15);
		System.out.println(list);
	}

	ArrayList<String> arrayToArrayList() {
		ArrayList<String> cupTypes = new ArrayList<String>();
		cupTypes.addAll(Arrays.asList(type));
		
		cupTypes = new ArrayList<String>(10);
		System.out.println(cupTypes.size());
		
		cupTypes = new ArrayList<String>(Arrays.asList(type));
		return cupTypes;
	}
	
	private ArrayList<Integer> createIntegerArrayList() {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(10);
		integers.add(20);
		integers.add(30);
		integers.add(40);
		integers.add(50);
		integers.add(60);
		return integers;
	}

	ArrayList<Cup>  createObjectArrayList() {
		ArrayList<Cup> cups = new ArrayList<Cup>();
		Cup cup = new Cup("Glass","Hot Water");
		cups.add(cup);
		cup = new Cup("Paper","Ice Water");
		cups.add(cup);
		cup = new Cup("Plastic","Coca-Cola");
		cups.add(cup);
		return cups;
	}
	
	void writeObjectArrayListToFile() throws IOException {
		FileWriter fw = new FileWriter("cups.csv");
		ArrayList<Cup> cups = createObjectArrayList();
		fw.write("cup type, liquids\n");
		for (Cup c : cups) {
			fw.write(c.type+","+c.liquids +"\n");
		}
		fw.close();
	}

}
