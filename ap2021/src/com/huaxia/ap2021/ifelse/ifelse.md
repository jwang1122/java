# AP Computer Science Prep - Question Catagory - ifelse

|Catagory | Questions in 40 | Percentage
|---      |---              |---         |
|datatype |2                |5%
|operator |3                |7.5%
|if-else  |5                |12.5%
|loop     |16               |40%
|method   |14               |35%

Questions related to **if-else** can be divided by 
* Comparison operator (==, >, <, >=, <=, !=)
* logical operator (&&, ||)
* Comparator method (compareTo(), equals())

1. Determine the output of the following code.

	```java
		int x = 10;
		int y = 5;

		if (x == 10)
			if (y <= 5)
				y++;
			else if (y < 4)
				x = 3;
			else
				y += 6;
		if (y > 5)
		{
			if (x != 10) {
				x = 0;
				y = 0;
			} else
				x = -5;
		}
	```
	```
	(A) x = 0, y = 0
	(B) x = -5, y = 6
	(C) x = 10, y = 5
	(D) x = 3, y = 5
	(E) None of the above
	```

1. A programmer intend to write code to print three word in acending lexicographical order.  Follow the code and determin the printed output.

	```java
		String word1 = "frog";
		String word2 = "dog";
		String word3 = "cat";

		if (word1.compareTo(word2) < 0)
			if (word2.compareTo(word3) < 0)
				System.out.println(word1 + " " + word2 + " " + word3);
			else
				System.out.println(word1 + " " + word3 + " " + word2);
		else if (word1.compareTo(word2) > 0)
			if (word2.compareTo(word3) < 0)
				System.out.println(word1 + " " + word2 + " " + word3);
			else
				System.out.println(word1 + " " + word3 + " " + word2);
		else if (word2.equals(word3))
			System.out.println("All the words are the same.");
		else
			System.out.println("Word1 and word2 are duplicated.");

	```
	```
	(A) frog cat dog
	(B) cat dog frog
	(C) dog frog cat 
	(D) frog dog cat
	(E) dog cat frog 
	```
1. Using following variable declarations, determine which one of the following evaluate to true.

	```java
	int temp= 90;
	boolean cloudy= false;

	I. if (temp >= 90 && !cloudy)
	II. if (!(temp > 90 || cloudy))
	III. if (!(temp >= 90 && !cloudy))
	```
	```
	(A) I only
	(B) II only
	(C) III only
	(D) Two of the above will evaluate to true
	(E) All the above will evaluate to true
	```
1. Consider the following code

	```java
		String dog1 = new String("Poodle");
		String dog2 = new String("Beagle");
		dog1 = dog2;
		String dog3 = new String("Beagle");
		
		if(dog1==dog2) // same box with different label
			System.out.println("dog1 and dog2 are one and the same dog.");
		else
			System.out.println("dog1 and dog2 are not the same dog.");
		
		if(dog1==dog3) // same content with different box and label
			System.out.println("dog1 and dog3 are one and the same dog.");
		else
			System.out.println("dog1 and dog3 are not the same dog.");
		
		if(dog1.equals(dog3)) // same content with different box and label
			System.out.println("dog1 and dog3 are the same breed.");
		else
			System.out.println("dog1 and dog3 are not the same breed.");
	
	```
	
	Which of the following representa the output that will be produced by the code?
	
	```
	(A) 
	dog1 and dog2 are one and the same dog.
	dog1 and dog3 are one and the same dog.
	dog1 and dog3 are the same breed.
	(B) 
	dog1 and dog2 are one and the same dog.
	dog1 and dog3 are one and the same dog.
	dog1 and dog3 are not the same breed.
	(C) 
	dog1 and dog2 are one and the same dog.
	dog1 and dog3 are not the same dog.
	dog1 and dog3 are the same breed.
	(D) 
	dog1 and dog2 are one and the same dog.
	dog1 and dog3 are not the same dog.
	dog1 and dog3 are not the same breed.
	(E) 
	dog1 and dog2 are not the same dog
	dog1 and dog3 are not the same dog.
	dog1 and dog3 are the same breed.
	```
1. Choose the best solution to complete the missing code such that the code will implement a binary search to find the variable number in arr.

	```java
		int number = <some number in arr>;
		System.out.println (search (arr, 0, arr.length-1, number)) ;

		public int search(int [] a,int first, int last, int sought){
			int mid = (first +  last)/2 ;
			if (<missing code>) {
				last = mid - 1;
				return search(a, first,last, sought) ;
			}
			else if(<missingcode>){
				first = mid + 1;
				return search (a, first, last, sought); 
			}
			return mid;
		}
	```
	```
	(A) a[mid] > sought  		a[mid] < sought
	(B) a[mid] + 1 > sought  	a[mid] < sought 
	(C) a[mid] > sought			a[mid] -1 < sought
	(D) a[mid] + 1 > sought 	a[mid] -1 < sought
	(E) a[mid] = sought  		a[mid] = sought
	```  

1. Consider the following code.

	```java
	int x =0; 
	if (x == 0 ) 
		System.out.print ("1" );
	else 
		System.out.print("2");
		System.out .print("3"); 
	```
	Which of the following best describes the result of executing the code segment? 

	(A) Since the value of x is 0, the first print statement will be performed, producing 1 as the output. 

	(B) Since the value of x is 0, the first print statement will be performed, producing 13 as the output.

	(C) Since the value of x is 0, the first print statement will be performed, producing 123 as the output.

	(D) == is not the correct boolean operator, so a syntax error will be produced by the compiler prior to execution. 

	(E) == is not the correct boolean operator, so a logical error will be produced by the compiler prior to execution. 

1. Consider the following code segment.

	```java
	boolean a = true, b = false;
	if (/* missing code */)
		System.out.print ("Nice job.");   
	else 
		SYstern.out.print("Nicer job ."); 
	```
	Which of the following could be used to replace / * missing code * / so that the output of this block of code is "Nicer job."?

	```java
	I. 		a && !b
	II. 	!a || d
	III. 	!a && b   
	``` 
	```
	(A) I only
	(B) I and II only
	(C) I and III only
	(D) II and III only
	(E) I, II and III
	```
1. Consider the following code segments: 

	```java
	I. 	int x = 10; 
		int y = 20;
		int z = 0 ;
		if (x < y && 10 < y/z) {
			Systern.out.println("Homer") ; 
		}
		else{
			System.out.printIn("gart") 
		}
	II.	int x = 10; 
		int y = 20;
		int z = 0 ;
		if (x > y && 10 < y/z) {
			Systern.out.println("Homer") ; 
		}
		else{
			System.out.printIn("gart") 
		}
	III.int x = 10; 
		int y = 20;
		int z = 0 ;
		if (x < y || 10 < y/z) {
			Systern.out.println("Homer") ; 
		}
		else{
			System.out.printIn("gart") 
		}
	```
    Which of the code segments above will run without error? 
	```
	(A) I only
	(B) II only
	(C) III only
	(D) II and III
	(E) I, II and III
	```

