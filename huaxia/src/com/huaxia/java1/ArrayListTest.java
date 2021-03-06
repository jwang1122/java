package com.huaxia.java1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

}
