package com.huaxia.ap2021.section2;

/**
 * Refer to C:\Users\12818\workspace\apcomputer\exams\sectionII-10.md
 * 
 * @author John
 *
 */
public class FrogsSimulation {

	/** 
	 * Distance, in inches, from the starting position to the goal. 
	 */
	private int goalDistance;

	/** Maximum number of hops allowed to reach the goal. */
	private int maxHops;

	private int[][] distances = { 
			{ 5, 7, -2, 8, 6 }, 
			{ 6, 7, 6, 6}, 
			{ 6, -6, 31}, 
			{ 4, 2, -8}, 
			{ 5, 4, 2, 4, 3 } };
	private int index = 0;
	private int round = 0;

	/** 
	 * Constructs a FrogSimulation where dist is the distance, in inches, 
	 * from the starting position to the goal, and numHops is the 
	 * maximum number of hops allowed to reach the goal. 
	 * Precondition: dist > 0; numHops > 0 
	 */
	public FrogsSimulation(int dist, int numHops) {
		goalDistance = dist;
		maxHops = numHops;
	}

	/** 
	 * Returns an integer representing the distance, in inches, 
	* to be moved when the frog hops. 
	 */
	private int hopDistance() {
		/* implementation not shown */
		return distances[round][index++];
	}

	/** 
	* Simulates a frog attempting to reach the goal as described in part (a). 
	* Returns true if the frog successfully reached or passed the goal 
	* during the simulation; false otherwise. 
	*/
	public boolean simulate() {
		int frogPosition = 0;
		int hopsRemaining = maxHops;

		while (frogPosition < goalDistance && frogPosition >= 0 && hopsRemaining > 0) {
			frogPosition += hopDistance();
			hopsRemaining--;
		}
		System.out.print("Frog position: " + frogPosition);
		System.out.println(", " + (frogPosition >= goalDistance));
		return frogPosition >= goalDistance;
	}

	/** 
	* Runs num simulations and returns the proportion of simulations 
	* in which the frog successfully reached or passed the goal. 
	* Precondition: num > 0 
	*/
	public double runSimulations(int num) {
		int successfulRuns = 0;

		for (int run = 1; run <= num; run++) {
			maxHops = distances[round].length;
			boolean flag = simulate();
			round++;
			index=0;
			if (flag) {
				successfulRuns++;
			}
		}

		return successfulRuns / (double) num;
	}

	public static void main(String[] args) {
		FrogsSimulation frog = new FrogsSimulation(24, 5);

		double prop = frog.runSimulations(5);
		System.out.println("Success proportion: " + prop);
	}
}