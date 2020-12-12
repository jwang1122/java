package com.huaxia.java2;

public class Deck {
    private static Card[] cards = new Card[52];
    public Deck() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                cards[i++] = new Card(face, suit);
            }
        }
    }
}
