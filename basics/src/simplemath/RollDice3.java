package languagebasics;

/*
 * Two six-sided dice are rolled. What is the probability 
 * that the numbers on the dice are different?
 * all set are 6*6=36, there are 6 equal, 30/36 are different. 
 * Answer: 30/36 = 5/6 = 8.3333333
 * 
 * Homework:
 * Bob rolls 7 for 6-side dice.
 * What is the probability that the
 * sum of the numbers on his dice are no more than 10.
 */
public class RollDice3 {

	public static void main(String[] args) {
		int count = 0;
		int tests = 1000000;
		for (int i = 0; i<tests; i++) {
			int dice1 = getRandomNumber(1, 6);
			int dice2 = getRandomNumber(1, 6);
			if(dice1!= dice2) {
				count++;
			}
		}
		System.out.printf("The posibility for %d sample rollings is %.4f.\n", tests, ((double)count)/tests);
		System.out.printf("The posibility should be %.4f\n", 5.0/6.0);
		System.out.println("Done.");
	}
	
	static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * max) + min;
	}
}
