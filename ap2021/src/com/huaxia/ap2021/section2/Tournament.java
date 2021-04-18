package com.huaxia.ap2021.section2;

import java.util.ArrayList;
import java.util.List;

/**
 * Soluction for ~/workspace/apcomputer/exams/sectionII-3.md
 * @see Player [main()]
 */
public class Tournament {
	/** The list of slots in the tournament. 
	* Each element corresponds to a slot in the tournament. 
	* If slots[i] is null, the slot is not yet taken; 
	* otherwise it contains a reference to a Player. 
	* For example, slots[i].getPlayerNumber() returns i. */
	private Player[] slots;

	/** The list of names of players who wish to participate in 
	the tournament, but cannot because all slots are taken. */
	private List<String> waitingList;

	public Tournament() {
		slots = new Player[2];
		waitingList = new ArrayList<>();
	}
	/**
	* If there are any empty slots (slots with no Player) 
	* assign the player with the specified playerName to an 
	* empty slot. Create and return the new Player. 
	* If there are no available slots, add the player's name 
	* to the end of the waiting list and return null. 
	* @playerName the name of the person requesting a slot 
	* @return the new player 
	*/
	public Player requestSlot(String playerName) { /* to be implemented in part (a) */
		for (int i = 0; i < slots.length; i++) {
			if (slots[i] == null) {
				Player p = new Player(playerName, i);
				slots[i] = p;
				return p;
			}
		}
		waitingList.add(playerName);
		return null;
	}

	/**
	* Release the slot for player p, thus removing that player 
	* from the tournament. If there are any names in waitingList, 
	* remove the first name and create a Piayer in the 
	* canceled slot for this person. Return the new Player. 
	* If waitingList is empty > mark the slot specified by p as 
	* empty and return null. 
	* precondition: p is a valid Player for some slot in this 
	*               tournament. 
	* @param p the player who will be removed from the tournament 
	* @return the new Player placed in the canceled slot 
	*/
	public Player cancelAndReassignSlot(Player p) { /* to be implemented in part (b) */
		int i = p.getPlayerNumber();
		if (waitingList.size() != 0) {
			slots[i] = new Player(waitingList.get(0), i);
			waitingList.remove(0);
		} else {
			slots[i] = null;
		}
		return slots[i];
	}

	public void printSlots() {
		for(Player p : slots) {
			System.out.println(p);
		}
	}
	// constructor and other methods not shown.

	public static void main(String[] args) {
		Tournament t = new Tournament();
		Player p1 = t.requestSlot("Angela");
		Player p2 = t.requestSlot("John");
		Player p3 = t.requestSlot("Nick");
		Player p4 = t.requestSlot("Charles");
		Player p5 = t.cancelAndReassignSlot(p1);
		Player p6 = t.cancelAndReassignSlot(p2);
	}

}
