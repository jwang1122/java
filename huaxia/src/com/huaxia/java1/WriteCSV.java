package com.huaxia.java1;

import java.io.FileWriter;
import java.util.ArrayList;

public class WriteCSV {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("card.csv");
		ArrayList<Card> cards = createObjectArrayList();
		fw.write("Face, Suit\n");
		for (Card c : cards) {
			fw.write(c.face + "," + c.suit +"\n");
		}
		fw.close();
		System.out.println("Done.");
	}
	
	static ArrayList<Card>  createObjectArrayList() {
		ArrayList<Card> cards = new ArrayList<Card>();
		Card card = new Card("A","Hearts");
		cards.add(card);
		card = new Card("2","Spades");
		cards.add(card);
		card = new Card("K","Diamonds");
		cards.add(card);
		return cards;
	}

}
