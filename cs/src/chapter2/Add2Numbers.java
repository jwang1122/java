package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Add2Numbers {
	
	
	public static void main(String[] args) {
		int i, m, carry;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter number of digits: ");
		m = input.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		int[] c = new int[m + 1];
		for (int j = 0; j < m; j++) {
			System.out.printf("Please enter digit %sth of a: ", j);
			a[j] = input.nextInt();
			System.out.printf("Please enter digit %sth of b: ", j);
			b[j] = input.nextInt();
		}
		i = 0;
		carry = 0;
		while (i < m) {
			c[i] = a[i] + b[i] + carry;
			if (c[i] >= 10) {
				c[i] = c[i] % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			i++;
		}
		c[i] = carry;
		System.out.printf("%s + %s = %s\n", Arrays.toString(a), Arrays.toString(b), Arrays.toString(c));
		reverse(a);
		reverse(b);
		reverse(c);
		System.out.printf("%s + %s = %s\n", Arrays.toString(a), Arrays.toString(b), Arrays.toString(c));
		input.close();
	}
	
	public static void reverse(int[] arr) {
		int i,t;
		int n = arr.length;
		for(i=0; i<n/2; i++) {
			t=arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = t;
		}
	}

}
