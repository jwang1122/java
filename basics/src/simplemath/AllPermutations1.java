package simplemath;

import java.util.Scanner;

public class AllPermutations1 {

	public static void main(String[] args) {
		// 1
		int i, j, k;
		int[] arr = new int[3];

		// 2
		Scanner scanf = new Scanner(System.in);
		System.out.print("Enter the first number : ");
		arr[0] = Integer.parseInt(scanf.nextLine());
		System.out.print("Enter the second number : ");
		arr[1] = Integer.parseInt(scanf.nextLine());
		System.out.print("Enter the third number : ");
		arr[2] = Integer.parseInt(scanf.nextLine());

		// 3
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				for (k = 0; k < 3; k++) {
					if (i != j && j != k && k != i) {
						// 4
						System.out.printf("[%d %d %d]\n", arr[i], arr[j], arr[k]);
					}
				}
			}
		}
	}
}
