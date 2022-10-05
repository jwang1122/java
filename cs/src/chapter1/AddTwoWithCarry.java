package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class AddTwoWithCarry {

	public static void main(String[] args) {
		System.out.print("Please enter two integer numbers with same digits (42,12): ");
		Scanner input = new Scanner(System.in);
		String nums = input.nextLine();
		int[] c = add(nums);
		System.out.printf("%s=%s", nums, Arrays.toString(c));
		input.close();
	}

	private static int[] add(String nums) {
		String[] arr = nums.split(",");
		String n1 = arr[0].trim();
		String n2 = arr[1].trim();
		int m = n1.length();
		int[] c = new int[m+1];
		for(int i=m-1; i>-1; i--) {
			int i1 = Character.getNumericValue(n1.charAt(i));
			int i2 = Character.getNumericValue(n2.charAt(i));
			c[i] = (i1+i2+c[i+1])/10;
			c[i+1] = (i1+i2+c[i+1])%10;
		}
		return c;
	}

}
