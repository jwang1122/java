package com.huaxia.ap2021.section2;

public class DiceSimulation {
	private int numSampleSize;
	private int numFaces;

	
	public DiceSimulation(int numSamples, int faces) {
		numSampleSize = numSamples;
		numFaces = faces;
	}

	public int roll() {
		return (int)(Math.random() * numFaces + 1); // understand Math.random()
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
			System.out.printf("Die1: %d\tDie2: %d\n", die1, die2);
		}
		return (int)(((double)countDouble/numSampleSize) * 100);
	}


	public static void main(String[] args) {
        int sampleSize = 10;
        int numFaces = 6;
		DiceSimulation test = new DiceSimulation(sampleSize, numFaces);
		int percentage = test.runSimulation();
		System.out.printf("The percentage of tow dice rolling %d times with same face value is %d.\n",sampleSize, percentage);
	}

}
