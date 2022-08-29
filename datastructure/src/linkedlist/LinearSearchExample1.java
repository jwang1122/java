package linkedlist;

import java.util.Scanner;

class LinearSearchExample1 {
	public static void main(String args[]) {
		int c, n, search, array[];

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter number of elements");
			n = input.nextInt();
			array = new int[n];

			System.out.println("Enter those " + n + " elements");

			for (c = 0; c < n; c++)
				array[c] = input.nextInt();

			System.out.println("Enter value to find");
			search = input.nextInt();

			for (c = 0; c < n; c++) {
				if (array[c] == search) /* Searching element is present */
				{
					System.out.println(search + " is present at location " + (c + 1) + ".");
					break;
				}
			}
			if (c == n) /* Element to search isn't present */
				System.out.println(search + " isn't present in array.");
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
