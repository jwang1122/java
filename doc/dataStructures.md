# Java Data Structures

## Data Structure Category
* Primitive Data Type: int, char, float, double...
* Non-Primitive Data Type: 
  - linear data structure
  >The arrangement of data in a sequential manner is known as a linear data structure. The data structures used for this purpose are Arrays, Linked list, Stacks, and Queues. In these data structures, one element is connected to only one another element in a linear form.

  - non-linear data structure
  >When one element is connected to the 'n' number of elements known as a non-linear data structure. The best example is trees and graphs. In this case, the elements are arranged in a random manner.
* Static data structure:
  >It is a type of data structure where the size is allocated at the compile time. Therefore, the maximum size is fixed.
* Dynamic data structure:
  >It is a type of data structure where the size is allocated at the run time. Therefore, the maximum size is flexible.

## Data Structure & Algorithms
[Wetsite tutorial](https://jenkov.com/tutorials/java-collections/queue.html)

❓ What is data structure?
>✔️A data structure is a named location that can be used to store and organize data. And, an algorithm is a collection of steps to solve a particular problem. Learning data structures and algorithms allow us to write efficient and optimized computer programs.

🔑💡 **Knowlodge Base**
### Data Management
> 1. append
> 2. insert
> 3. delete

### Data Usage
> 1. traverse
> 2. sort
> 3. search


❓ What is data traverse?
>✔️Traversing a data structure means: "visiting" or "touching" the elements of the structure, and doing something with the data. (Traversing is also sometimes called iterating over the data structure)

## Array

[Array](https://www.javatpoint.com/data-structure-array)
```java
int arri[10];
char arrc[10];
float arrf[5];
```
* One variable name for all data
* Easy to traverse
* Able to get individual item by index

![Array in Memory](./images/ds-1d-array.png)

* [data without structure](../datastructure/src/array/array1.java)
* [int array](../datastructure/src/array/array2.java)
* [data stream reduce without loop](../datastructure/src/array/array3.java)
* [data stream calculate average](../datastructure/src/array/array4.java)
* [data stream map with average() function](../datastructure/src/array/array5.java)

![](images/mapExample.jpg)

❓What is map() function?
>✔️ the map() function is processing iterables without loop.

$$data: a_1, a_2, ..., a_n$$
$$list.stream.map(f)$$
$$result: f(a_1),f(a_2),...,f(a_n)$$

### Lambda Expression

```
([argument list])->{[function code block]};
```

* [lambda forEach]()
### Stream

### Java Generics

### ArrayList

* [ArrayList]()

### Vector


### Linked List
[Linked List website](https://www.geeksforgeeks.org/data-structures/linked-list/)

* [Sigle linked list]()
![](images/Linkedlist.png)


* [Doubly linked list](../datastructure/src/linkedlist/DoubleList.java)
* [Double node](../datastructure/src/linkedlist/DoubleNode.java)
* [Double data link test](../datastructure/src/linkedlist/DoubleListTest.java)

![](images/DLL1.png)

* [Circular Linked List]()

![](images/Circular-doubly-linked-list.png)

* [Quick Link]()


## Data Structure

### Queue
❓ What is Queue?
>✔️ First-In-First-Out data structure.

```mermaid
classDiagram

class Queue{
  <<interface>>
  add(E e)
  element()
  offer(E e)
  peek()
  poll()
  remove()
}

```

![](images/java-queue.png)

* [Queue]()

### Stack
❓ What is stack?
>✔️ The Stack class represents a last-in-first-out (LIFO) stack of objects.

```mermaid
classDiagram

class IStack {
<<interface>>
  pop()
  push(E item)
}
```

[implement IStack]()

```mermaid
classDiagram

class Stack{
  empty()
  peek()
  pop()
  push(E item)
  search(Object)
}
```
* [Stack](../datastructure/src/builtins/MyStack.java)



### Set
* [Set]()

### TreeSet
* [Tree]()


### Search

* [Sequential Search]()
* [Binary Search]()

### Sort
* [Selection sort](../datastructure/src/sort/SelectionSort.java)
* [Bubble sort](../datastructure/src/sort/BubbleSort.java)
* [Insertion sort](../datastructure/src/sort/InsertionSort.java)
* [Merge Sort](../datastructure/src/sort/MergeSort.java)
* [Quick Sort](../datastructure/src/sort/QuickSort.java)
* [Java Collections sort](../datastructure/src/sort/CollectionsSort.java)
* [Java TreeSet]()
* [Comparable]()
   
## HashCode() and equals()

