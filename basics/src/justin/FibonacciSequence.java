package justin;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		System.out.print("Please enter an integer number: ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] fabonacci = fabonacci(num);
		System.out.printf("Fibonacci sequence is: %s\n",Arrays.toString(fabonacci));
		System.out.printf("the sum is: %s\n",sum(fabonacci));
		input.close();
	}

	

	private static Object sum(int[] fabonacci) {
		int sum = 0;
		for(int i : fabonacci) {
			sum += i;
		}
		return sum;
	}

	public static int[] fabonacci(int n){
		int[] fabonacci = new int[n]; 
		fabonacci[0] = 0;
		fabonacci[1] = 1;
		for (int i=2; i<n; i++) {
			fabonacci[i] = fabonacci[i-2] + fabonacci[i-1];
		}
		return fabonacci;
	}
	
}
