# AP Computer Science Prep - Question Catagory - datatype

Catagory | Questions in 40 | Percentage
|--- |--- |--- |
datatype |2  |5%
operator |3  |7.5
if-else  |5  |12.5%
loop     |16 |40%
method   |14 |35%

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
