package com.huaxia.ap2021.quizes;

public class Quiz3 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		String str1 = "banana";
		String str2 = "";
		// 3. missing code
		// 4. missing code
//        int i = 0;  // (A) do NOT compile
//        while(i<str1.length)

//        int i = str1.length(); // (B) Out of bounds
//        while (i >=0)

		int i = str1.length() - 1; // (C)
		while (i >= 0)

//        int i = str1.length(); //(D) Out of bounds
//        while (i>0)	

//        int i = str1.length() - 1; // (E) missing first letter b.
//        while (i>0)	
		{
			str2 += str1.substring(i, i + 1);
			i--;
		}
		System.out.println(str2);

	}

	private static void question2() {
		int n = 3; // some integer greater than zero
		int count = 0;
		int p = 0;
		int q = 0;
		for (p = 1; p < n; p++)
			for (q = 1; q <= n; q++)
				count++;
		System.out.println(count);
	}

	private static void question3() {
        int x = 0;
        for (int j = 1; j < 4; j++) {
            if (x != 0 && j / x > 0)
                System.out.print(j / x + " ");
            else
                System.out.print(j * x + " ");
        }
        System.out.println();
	}

	private static void question4() {
	    String space = " ";
        String symbol = "*";
        int num = 5;
        for (int i = 1; i <= num; i++) {
            System.out.print(symbol);
        }
        System.out.println();
        for (int i = 1; i <= num; i++) {
            for (int j = num - i; j > 0; j--) {
                System.out.print(space);
            }
            System.out.println(symbol);
        }
        for (int i = 1; i <= num; i++) {
            System.out.print(symbol);
        }
        System.out.println();
	}

	private static void question5() {
        int sum = 0;
        for (int i=1; i<2; i++)
            for(int j=1; j<=3; j++)
                for(int k=1; k<4; k++)
                    sum += (i*j*k);
        System.out.println(sum);
/*
        i  j  k  sum
        1  1  1    1
        1  1  2    3
        1  1  3    6
        1  2  1    8
        1  2  2   12
        1  2  3   18
        1  3  1   21
        1  3  2   27
        1  3  3   36        
*/
	}

}
