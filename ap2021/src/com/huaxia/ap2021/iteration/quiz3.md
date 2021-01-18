1. Choose the correct option to complete lines 3 and 4 such that str2 will contain the letters of str1 in reverse order.

	```java
		String str1 = "banana";
		String str2 = "";
		// 3. missing code
		// 4. missing code 
		{
			str2 += str1.substring(i, i + 1);
			i--;
		}
		System.out.println(str2);
	
	```
	```
	(A) int i = 0;
		while(i<str1.length);
	(B) int i = str1.length();
		while (i >=0);
	(C) int i = str1.length() - 1;
		while (i >=0);
	(D) int i = str1.length();
		while (i>0);
	(E) int i = str1.length() - 1;
		while (i>0)
	```

1. Consider the following code excerpt:

	```java
			int n = // some integer greater than zero
			int count = 0;
			int p = 0;
			int q = 0;
			for (p=1; p<n; p++)
				for(q=1; q<=n; q++)
					count++;
			System.out.println(count);
	```
	(A) $n^n$ 
	
	(B) $n^2-1$
	
	(C) $(n-1)^2$
	
	(D) $n(n-1)$
	
	(E) $n^2$

1. Given the following code excerpt, determine the output:

	```java
		int x = 0;
		for (int j = 1; j < 4; j++) {
			if (x != 0 && j / x > 0)
				System.out.print(j / x + " ");
			else
				System.out.print(j * x + " ");
		}
	```
	```
	(A) 0 0 0
	(B) 0 0 0 0
	(C) 1 2 3
	(D) 1 0 2 0 3 0
	(E) ArithmeticException: Divide by zero
	```
1. Consider the following code:

	```java
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
	```
	```
	(A) *****
		****
		***
		**
		*
		*****
	(B) *****
		****
		***
		**
			*
		*****
	(C) *****
			*
		*
		*
		*
		*****
	(D) *****
		*
		*
		*
		*
		*****
	(E) *****
		*
		**
		***
		****
		*****
	```
1. What will be printed as a result of the following code excerpt?

	```java
		int sum = 0;
		for (int i=1; i<2; i++)
			for(int j=1; j<=3; j++)
				for(int k=1; k<4; k++)
					sum += (i*j*k);
		System.out.println(sum);
	```
	```
	(A) 18
	(B) 36
	(C) 45
	(D) 60
	(E) 108
	```