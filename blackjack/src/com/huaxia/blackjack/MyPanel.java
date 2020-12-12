package com.huaxia.blackjack;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image card;
	private int x = 100;
	private int y = 100;

	public void paint(Graphics g) {
		Card clubA = new Card(Face.ACE, Suit.CLUB);
		clubA = Deck.cardTable.get(clubA);
		card = clubA.getImage();
		g.drawImage(card, x, y, this);
	}
}
