package com.huaxia.ap2021.section2;

/**
 * Soluction for ~/workspace/apcomputer/exams/sectionII-3.md
 * 
 * @author John
 *
 * @see Tournament 
 */
public class Player {
	private int playerNumber;
	private String name;

	public Player(String name, int playerNumber) { 
		/* implementation not shown */
		this.name = name;
		this.playerNumber = playerNumber;
	}

	public int getPlayerNumber() { 
		/* implementation not shown*/
		return playerNumber;
	}

	public String getName() {
		return name;
	}

	// private instance variables and other methods not shown
	public String toString() {
		return String.format("Player: (name=%s, number=%d)",name, playerNumber);
	}
}
