package com.huaxia.ap2021.section2;

import java.util.ArrayList;

public class HungryChameleon {
	/**
	* Gets a list of adjacent bugs. 
	* @param actors the list of all adjacent neighbors 
	* @return a list of adjacent bugs 
	*/
	private ArrayList<Bug> getBugs(ArrayList<Actor> actors) { /* to be implemented in part (a) */
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		for (Actor a : actors) 
		{
			if (a instanceof Bug) 
				bugs.add((Bug) a) ; 
		}
		return bugs;
	}

	/**
	* Randomly "eats" one of the bugs in the list of bugs
	* Precondition: bugs.size() > 0. 
	* @param bugs the list of adjacent bugs 
	*/
	private void eatBug(ArrayList<Bug> bugs) {
		/* to be implemented in part (b) */ }

	/**
	* Gets a list of adjacent neighboring bugs and eats one.
	* If there are no bugs to eat, the HungryChame 1 eon takes
	* on the color of a neighboring actor. 
	* @param actors the list of all adjacent neighbors 
	*/
	public void processActors(ArrayList<Actor> actors) {
		/* to be implemented in part (c) */ }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Actor {

}

class Bug {

}
