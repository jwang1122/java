# AP Computer Science Prep - Question Catagory - operator

|Catagory | Questions in 40 | Percentage
|---      |---              |---         |
|datatype |2                |5%
|operator |3                |7.5%
|if-else  |5                |12.5%
|loop     |16               |40%
|method   |14               |35%

Questions related to **operator** can be divided by 
* /, +, -, *
* cast
* escape sequence for special caracters

1. Which of the following expressions does **not** evaluate to 0.2?

    ```java
    (A) (1.0 * 2.0) / (1.0 * 10);
    (B) 2.0 / 10;
    (C) (double) 2 / 10;
    (D) (double)(2 / 10);
    (E) Math.sqrt(4) / Math.sqrt(100);
    ```

1. Evaluate the following expression: 4 + 6 % 12/4?

    ```
    (A) 1
    (B) 2
    (C) 4
    (D) 4.5
    (E) 5
    ```
1. Choose the code used to print the following:
   
   "Friends"
   
    ```java
    (A) System.out.println(""Friends"");
    (B) System.out.println("//"Friends//"");
    (C) System.out.println("/"Friends/"");
    (D) System.out.println("\"Friends\"");
    (E) System.out.println("\\"Friends\\"");
    ```
1. Consider the following code segment: 
   
    ```java
    int a = 3; 
    int b = 6; 
    int c = 8; 
    int d = a/b; 
    c /= d;
    System.out.print(c)
    ```
    Which of the following will be output by the code segment? 
    ```
    (A) 4 
    (B) 8
    (C) 12 
    (D) 16 
    (E) There will be no output because of a run-time error.  
    ```
1. Consider the following code segment.

	```java
	boolean a = true, b = false;
	if (/* missing code */)
		System.out.print ("Nice job.");   
	else 
		System.out.print("Nicer job ."); 
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
1. Suppose p and q are declared as boolean variables and have been initialized to unknown truth values. 

    What does the following boolean expression evaluate to? 

    ```
    (!p && !q) || !(p || q)
    (A) The expression salway s evaluates to true.
    (B) The expression always evaluates to false.
    (C) The expression evaluates to true whenever p is false.
    (D) The expression evaluates to true whenever q is false.
    (E) The expression evaluates to false whenever p and q have opposite truth values. 
    ```
1. Consider the following statement: 

    ```java
    int i = x % 50;
    ```
    If x is a positive integer, which of the following could NOT be the value of i after the statement above executes? 
    ```
    (A) 0 
    (B) 1O 
    (C) 25
    (D) 40
    (E) 50   
    ```
1. In the following statement, a and b are boolean variables: 

    ```java
    boolean c = (a && b) || !(a || b);
    ```
    Under what conditions will the value of c be true? 
    ```
    (A) Only when the value of a is different than the value of b 
    (B) Only when the value of a is the same as the value of b 
    (C) Only when a and b are both true 
    (D) Only when a and b are both false 
    (E) The value of c will be true for all values of a and b. 
    ```
1. Consider the following code segment: 

    ```java
    while ( (x > y) || y >= z){
        System.out.print ("*") ; 
    } 
    ```
    In the code segment above, x, y, and z are the variables of type int. Which of the following must be true after the code segment has executed? 
    ```java
    (A) x>y || y>=z
    (B) x<=y || y>z 
    (C) x>y && y>=z
    (D) x<y && y<=z
    <E) x<=y && y<z  
    ```
1. Consider the following code segment: 

	```java
	int x =10; 
	int y = x / 3; 
	int z = x % 2; 
	x++;
	SYstem. out. printin (x); 
	```
	What is printed as a result of executing the code segment above? 
	```
	(A) 2 
	(B) 4 
	(C) 10 
	(D) 11 
	(E) 15 
	```
1. Consider the following code segment: 

    ```java
    int a = 10;
    double b =3.7;
    int c = 4; 
    int x = (int) (a + b);
    double y = (double) a/c;
    double z = (double) (a / c) ; 
    double w = x + y + z ;
    System.out.println(w); 
    ```
    What is printed as a result of evaluating the code above? 
 	```
	(A) 10 
	(B) 15
	(C) 15.5 
	(D) 17 
	(E) 17.5 
	```
