package com.huaxia.java1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayListTest {
	static final String[] type = { "Glass", "Paper", "Plastic", "China" };

	public static void main(String[] args) throws IOException {
		ArrayListTest test = new ArrayListTest();
//		ArrayList<Integer> myInts = test.createIntegerArrayList();
//		System.out.println(myInts);
//		System.out.println(myInts.size());
//		ArrayList<String> cupTypes = test.arrayToArrayList();
//		System.out.println(cupTypes);
//		test.insertItemIntoArrayList();
//		test.removeItemFromArrayList();
//		test.replaceItemInArrayList();
//		test.numberOfElementsInArrayList();
//		test.findPosition();
//		test.clearArrayList();
//		List<Card> cardList = test.createObjectArrayList();
//		for(Card c : cardList) {
//			System.out.println(c);
//		}
		test.writeObjectArrayListToFile();
		System.out.println("Done.");
	}
	
	void clearArrayList() {
		List<String> cupTypes = arrayToArrayList();
		System.out.println(cupTypes);
		cupTypes.clear();
		System.out.println(cupTypes.isEmpty());		
	}

	void findPosition() {
		List<String> cupTypes = arrayToArrayList();
		int position = cupTypes.indexOf("Plastic");
		System.out.println(position);
	}

	void numberOfElementsInArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		int numOfItem = list.size();
		System.out.println(numOfItem);
	}

	void replaceItemInArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.set(3,15);
		System.out.println(list);
	}

	void removeItemFromArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.remove(3);
		System.out.println(list);
	}

	void insertItemIntoArrayList() {
		ArrayList<Integer> list = createIntegerArrayList();
		list.add(3,15);
		System.out.println(list);
	}

//	ArrayList<String> arrayToArrayList() { // difference between return List and ArrayList
	List<String> arrayToArrayList() {
		List<String> cupTypes = new ArrayList<String>();
//		ArrayList<String> cupTypes = new ArrayList<String>();
		cupTypes = Arrays.asList(type);
//		cupTypes.addAll(Arrays.asList(type));
//		cupTypes = new ArrayList<String>(Arrays.asList(type));
		
		cupTypes = new ArrayList<String>(10);
		System.out.println(cupTypes.size());
		
		return cupTypes;
	}
	
	ArrayList<Integer> createIntegerArrayList() {
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(10);
		integers.add(20);
		integers.add(30);
		integers.add(40);
		integers.add(50);
		integers.add(60);
		return integers;
	}

	ArrayList<Card>  createObjectArrayList() {
		ArrayList<Card> cards = new ArrayList<Card>();
		Card card = new Card("A","Hearts");
		cards.add(card);
		card = new Card("2","Spades");
		cards.add(card);
		card = new Card("K","Diamonds");
		cards.add(card);
		return cards;
	}
	
	void writeObjectArrayListToFile() throws IOException {
		FileWriter fw = new FileWriter("card.csv");
		ArrayList<Card> cards = createObjectArrayList();
		fw.write("Face, Suit\n");
		for (Card c : cards) {
			fw.write(c.face + "," + c.suit +"\n");
		}
		fw.close();
	}

	void old(){
		// create ArryaList
		ArrayList<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("World");
		list.add("Good Morning");
		list.add("John");
		System.out.println(list);
		
		System.out.println(list.indexOf("World")); // what is the index of "world"
		boolean flag = list.contains("John");
		System.out.println(flag);
		
		List<Integer> iList = new ArrayList<>();
		iList.add(2);
		iList.add(12);
		iList.add(8);
		System.out.println(iList);
		System.out.println(iList.contains(12));
		System.out.println(list.size());
		
		// modify ArrayList (CRUD)
		iList.add(90);
		iList.set(2, 11); // update value
		System.out.println(iList);
		iList.add(2, 78); // insert new element in given index
		System.out.println(iList);
		iList.remove(Integer.valueOf(78)); // delete element at given index
		System.out.println(iList);
		System.out.println(iList.getClass().getName());
		iList.clear();  // remove all elements from the ArrayList
		System.out.println("40: list size is " + iList.size());
		
		list.remove("John");    // delete element directly
		System.out.println(list);
		
		// create ArrayList from an array
		Integer[] a = {1,4,6,3,8}; // must use Integer instead of int
		a[2]=7;
		System.out.println(Arrays.toString(a)); 
		iList = Arrays.asList(a);  // use Arrays.asList() to convert array to Arrays$ArrayList
//		iList.add(19); // 😢 👎java.lang.UnsupportedOperationException due to iList is Arrays$ArrayList
		System.out.println(iList.getClass().getName());
		iList = new ArrayList<Integer>(iList);
		System.out.println(iList.getClass().getName());
		iList.add(19);
		System.out.println(iList);
		// write while loop, only print the number >= 7 by using if condition
		
		// sort ArrayList
		Collections.sort(iList);
		System.out.println(iList);
		

	}
}
