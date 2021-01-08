package com.huaxia.ap2021.section2;

public class Question1 {
	int numFaces = 6;
	int numSampleSize = 100000;
	
	public int roll() {
		return (int)(Math.random() * numFaces + 1);
	}
	
	public int runSimulation() {
		int die1 = 0;
		int die2 = 0;
		int countDouble = 0;
		for (int i = 0; i<numSampleSize; i++) {
			die1 = roll();
			die2 = roll();
			if(die1==die2) {
				countDouble++;
			}
		}
		return (int)((1.0 * countDouble/numSampleSize) * 100);
	}
	
	public static void main(String[] args) {
		Question1 test = new Question1();
		System.out.println(test.runSimulation());

	}

}
