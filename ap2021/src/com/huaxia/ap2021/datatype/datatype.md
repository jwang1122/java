# AP Computer Science Prep - Question Catagory - datatype

|Catagory | Questions in 40 | Percentage
|---      |---              |---         |
|datatype |2                |5%
|operator |3                |7.5%
|if-else  |5                |12.5%
|loop     |16               |40%
|method   |14               |35%

Questions related to **datatype** can be divided by 
* cast
* math operator on different type
* data type stored in array or ArrayList 

1. Choose the missing code below that will accurately find the average of the values in the sales array.

    ```java
        double avg = 0;
        int i = 0;
        int sum = 0;
        for (int element: sales) 
        // Missing code
    ```

    ```java
    (A) {
            sum += element;
        }
        avg = (double) sum / sales.length;
    (B) {
            sum += sales[i];
        }
        avg = (double) sum / sales.length
    (C) {
            sum += sales;
        }
        avg = (double) sum / sales.length
    (D) {
            sum += sales[element];
        }
        avg = (double) sum / sales.length
    (E) {
            sum += element[sales];
        }
        avg = (double) sum / sales.length
    ```
1. Which code has declared and properly populated the given ArrayList?
    ```java
    I. 	ArrayList<String> alist1 = new ArrayList<String>();
        alist1.add("4.5");
    II. ArrayList<Integer> alist2 = new ArrayList<Integer>();
        alist1.add((int)4.5); 
    III.ArrayList<Double> alist3;
        alist3 = new ArrayList<Double>();
        alist3.add(4.5); 
    ```
    ```
    (A) I only
    (B) I and II
    (C) I and III
    (D) II and III
    (E) I, II and III
    ```
1. Assuming all other statements in the program are correct, each of the following statements will allow the program to compile **EXCEPT**

    ```java
    (A) //This is a comment
    (B) /* This is a comment*/ 
    (C) // myName is a good identifier name 
    (D) // myname is a good identifier name 
    (E) All of the above statements will compile. 
    ```
1. Assuming all other statements in the program are correct, each of the following statements will allow the program to compile **EXCEPT**

    ```java
    (A) system.out.print(1);
    (B) System.out.print("1");  
    (C) System.out.print(side1); 
    (D) System.out.print"side1");
    (E) All of the above statements will compile. 
    ```
1. Assuming all other statements in the program are correct, each of the following statements will allow the program to compile **EXCEPT**

    ```java
    (A) System.out.print("Ilove Java"); 
    (B) System.out.print("Ilove" + "Java"); 
    (C) System.out.print(1 + "love" + Java"); 
    (D) System.out.print(1 + "love" + "Java"); 
    (E) System.out.print("I love" + " " + "Java"); 
    ```
1. Consider the following code segment: 

    ```java
    int a =10 ;
    double b = 10.7; 
    double c = a + b;
    int d =a + c; 
    Sstem.out.println(c + " " + d);  
    ```
    What will be output as a result of executing the code segment? 

    ```
    (A) 20      20
    (B) 20.0    30
    (C) 20.7    31
    (D) 20.7    30.7
    (E) Nothing will be printed because of a compile-time error.
    ```    
1. Consider the following code segment: 
   
   ```java
    1   int a 10;
    2   double b = 10.7; 
    3   int d = a + b;  
   ```
    Line 3 will not compile in the code segment above. With which of the following statements could we replace this line so that it compiles? 

    ```java
    I.      int d = (int) a + b
    II.     int d = (int) (a + b);
    III.    int d = a + (int)b; 
    ```
    ```
    (A) I 
    (B) II
    (C) III 
    (D) I and III
    (E) II and III   
    ```
1. Consider the following code segment. 

   ```java
   1    int a = 11; 
   2    int b = 4;
   3    double x = 11;
   4    double y = 4;
   5    System.out.print(a/b) ;   
   6    System.out.print(", ") ;   
   7    System.out.print(x/y) ;   
   8    System.out.print(", ") ;   
   9    System.out.print(a/y) ;   
   ```
   What is printed as a result of executing the code segment? 
   ```
   (A) 3, 2.75, 3 
   (B) 3,2.75,2.75 
   (C) 2,3.2 
   (D) 2, 2.75,2.75 
   (E) Nothing will be printed because of a compile-time error. 
   ```
1. A math teacher is writing a program that will correctly calculate the area of acircle. Recall that the area of a circle is pi times the radius squared ($\pi r^2$). Assuming Math-PI returnsan accurate decimal approximation of pi, which of the following statements **WILL NOT** calculate an accurate area of a circle with radius 22 ? 

    ```java
    (A) r*r*Math.PI; //r is the int 22 
    (B) r*r*Math.PI; // r is the double 22.0 
    (C) (double) r*r*Math.PI; //r is the int 22 the int 22 
    (D) (double) (r*r) *Math.PI; // r is the int 22 
    (E) All of the above choices will calculate an accurate area. 
    ```
1. Consider the following code segment: 
   
   ```java
   String s = "This is the beginning";
   String t = s.substring(5);
   int n = t.indexOf ("the");  
   ```
   Which of the following will be the value of n ? 
   ```
    (A) -1 
    (B) 3 
    (C) 7
    (D) 9 
   ```
