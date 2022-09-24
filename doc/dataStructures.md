<h1> Java Data Structures & Algorithms</h1>

- [Data Structure & Algorithms](#data-structure--algorithms)
- [Data Structure Category](#data-structure-category)
  - [Data Management](#data-management)
  - [Data Usage](#data-usage)
- [Squencial Search](#squencial-search)
- [Selection Sort](#selection-sort)
- [Shuffle left](#shuffle-left)
- [Copy over](#copy-over)
- [Converging Pointers](#converging-pointers)
- [Array](#array)
  - [Lambda Expression](#lambda-expression)
  - [Stream](#stream)
  - [Java Generics](#java-generics)
- [Java Built-ins Data Structure](#java-built-ins-data-structure)
  - [ArrayList](#arraylist)
  - [Vector](#vector)
  - [Hashtable](#hashtable)
  - [HashMap](#hashmap)
  - [Linked List](#linked-list)
  - [HashSet](#hashset)
  - [TreeSet](#treeset)
  - [StringBuffer](#stringbuffer)
  - [StringBuilder](#stringbuilder)
- [Linked List](#linked-list-1)
- [Data Structure](#data-structure)
  - [Queue](#queue)
  - [Stack](#stack)
  - [Set](#set)
  - [HashSet](#hashset-1)
  - [TreeSet](#treeset-1)
  - [Search](#search)
  - [Sort](#sort)
- [HashCode() and equals()](#hashcode-and-equals)
- [References](#references)

❓ Why we want to learn data structure?
>✔️ The reason for learning about data structures is because adding structure to our data can make the algorithms much simpler, easier to maintain, and often faster.


## Data Structure & Algorithms

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

```mermaid
graph LR

PRIM[Primitive Data Type]
NONPRIM[Non-Primitive Data Type]
LINEAR[Linear data structure]
NONLINEAR[Non-linear data structure]

DS(Data Structure)

DS--> PRIM & NONPRIM
NONPRIM-->LINEAR & NONLINEAR

DS1(Data Structure)
STATIC[Static Data Structure]
NONSTATIC[Non-static Data Structure]
DS1-->STATIC & NONSTATIC
```

❓ What is data structure?
>✔️A data structure is a named location that can be used to store and organize data. 

❓ What is algorithm?
>✔️an algorithm is a collection of steps to solve a particular problem. Informally, an algorithm is nothing but a mention of steps to solve a problem. They are essentially a solution.

Learning data structures and algorithms allow us to write efficient and optimized computer programs.

🔑💡 **Knowlodge Base**: Attributes of Algorithms
> 1. existence and correctness; (wrong result worse than not working at all)
> 2. practical consideration;

[sample of finding Prime number]()

❓Does Linux support CRLF?
>✔️in Windows both a CR and LF are required to note the end of a line, whereas in Linux/UNIX a LF is only required.

```linux
sed 's/\r$//' file.txt > out.txt
tr -d '\r' input.txt > out.txt
sudo apt install dos2unix 
```

```mermaid
graph TB

ALG(Algorithm)
CORR[Correctness & Existence]
PRAC[Practical Constidration]
EASY[Ease of Handling]
CODE[Code Readability]
DOC[Documentation]
SEPA[Logical Separation]
STYLE[Elegant Style<br>Efficience]

ALG-->CORR & PRAC
PRAC-->EASY
PRAC-->STYLE
EASY-->DOC
EASY-->CODE
EASY-->SEPA
```



* [Array](../datastructure/src/array/array1.java)
* [Array List](../datastructure/src/builtins/MyArrayList.java)


🔑💡 **Knowlodge Base**
### Data Management
> 1. append
> 2. insert
> 3. delete
> 4. (modify)

### Data Usage
> 1. traverse
> 2. sort
> 3. search

## Squencial Search
* [Squential search](../datastructure\src\algorithms\SquentialSearch.java)

## Selection Sort
* [Selection sort](../datastructure\src\algorithms\SelectionSort.java)

## Shuffle left
* [Shuffle left](../datastructure\src\algorithms\ShuffleLeft.java)

## Copy over
* [Copy over](../datastructure\src\algorithms\CopyOver.java)

## Converging Pointers
* [Converging Pointers](../datastructure\src\algorithms\ConvergingPointers.java)
  
## Binary Search
* []()

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
Lambda expression provides implementation of functional interface.

```
([argument list])->{[function code block]};

(variables) -> {

}
```

* [lambda for](../datastructure/src/lambda/Lambda1.java)

### Stream

* [Sample stream](../datastructure/src/array/array5.java)

### Java Generics
❓ What is Generics?
>✔️Generics add stability to your code by making more of your bugs detectable at compile time. In Java, Generics data structure handle any other data type in more generic way.

* [Java ArrayList](../datastructure/src/builtins/MyArrayList.java)
* [Define own generic class](../datastructure/src/linkedlist/Node.java)
* [Java Collections](../datastructure/src/builtins/MyCollections.java)

## Java Built-ins Data Structure
* [Understand Collections.sort()]()
>1. ArrayList
>2. Vector
>3. Hashtable
>4. HashMap
>5. HashSet
>6. TreeSet

### ArrayList

* [ArrayList](../datastructure/src/builtins/MyArrayList.java)

### Vector
* [Vector](../datastructure/src/builtins/MyVector.java)

### Hashtable
* [Hashtable](../datastructure/src/builtins/MyHashtable.java)

### HashMap
* [HashMap](../datastructure/src/builtins/MyHashMap.java)

### Linked List
[Linked List website](https://www.geeksforgeeks.org/data-structures/linked-list/)

### HashSet
* [HashSet](../datastructure/src/builtins/MyHashSet.java)

### TreeSet
* [TreeSet](../datastructure/src/builtins/MyTreeSet.java)

### StringBuffer
* []()
### StringBuilder


## Linked List

* [Sigle linked list](../datastructure/src/linkedlist/LinkedList.java)
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
list of element with no duplication.

```mermaid
classDiagram

class Set{
<<interface>>
  of()
  add()
  remove()
  isEmpty()
}

class SortedSet{
  <<interface>>
  comparator()
}

class TreeSet{
  iterator()
}

SortedSet <-- TreeSet:implements
Set <-- SortedSet:implements
```


* [Set]()

### HashSet
* []()


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


* Stack (FILO)
* Queue (FIFO)
* [Linked List](../huaxia/src/com/huaxia/datastructure/LinkedList.java)
* [Doubly linked list](../huaxia/src/com/huaxia/datastructure/DoublyLinkedList.java)
* Tree
❓ What is tree structure
✔️Trees are a collection of nodes (vertices), and they are linked with edges (pointers), representing the hierarchical connections between the nodes. A node contains data of any type, but all the nodes must be of the same data type. 
![tree](images/tree.png)
[](https://www.educative.io/blog/data-structures-trees-java)

![](images/tree-1.webp)
```mermaid
classDiagram

class BinaryNode{
  value:int
  left:BinaryNode
  rght:BinaryNode
}

class BinaryTree{
  root:BinaryNode
  addRecursive(BinaryNode, value)
  traverseInOrder(BinaryNode)
  traversePreOrder(BinaryNode)
}
```
* [BinaryNode](../huaxia/src/com/huaxia/datastructure/BinaryNode.java)
* [BinaryTree](../huaxia/src/com/huaxia/datastructure/BinaryTree.java)
* [PartList Homework](../huaxia/docs/PartList.pdf)
* ![PartList Design](../huaxia/docs/autopartDesign.jpg)

* [BinaryTree.insert() test](../huaxia/src/com/huaxia/danceticket/Test.java)
* [BinaryTree.remove() test](../huaxia/src/com/huaxia/danceticket/Test.java)
* [BinaryTree](../huaxia/src/com/huaxia/danceticket/BinaryTree.java)
```mermaid
graph TB
A((6))
B((4))
C((8))
D((3))
E((5))
F((7))
G((9))
H((2))
A --> B & C
B --> D & E
C --> F & G
D --> H
```
* [TreeMap sort by AutoComparator](../huaxia/src/com/huaxia/java2/treemap/PartList.java)
* [Functional programing Better way to load part data](../huaxia/src/com/huaxia/java2/treemap/PartList1.java)
* [Insertion sort](../huaxia/src/com/huaxia/datastructure/InsertionSort.java)

![](images/Selection-sort-flowchart.jpg)

* [Selection Sort](../huaxia/src/com/huaxia/datastructure/SelectionSort.java)

```mermaid
graph TB
S([Start])
R[/Read the length<br/>of array in n<br/> and the array<br/>in arr/]
A[set i=0]
B{i<n-1}
C[min_index=i]
D[j=i+1]
P[/print sorted array/]


S-->R-->A-->B
B--true-->C
B--false-->P
```
![](images/insertionsort.png)

* [Quick sort](../huaxia/src/com/huaxia/datastructure/QuickSort.java)
![](images/QuickSort2.png)

* [Order Part by make and year](../huaxia/src/com/huaxia/java2/treemap/TreeMapDemo1.java)
* [Sorted by make, mode, and year](../huaxia/src/com/huaxia/java2/treemap/TreeMapDemo2.java)
* [TreeMap Generics sorted by value](../huaxia/src/com/huaxia/java2/treemap/TreeMapDemo.java)
* [TreeSet ](../huaxia/src/com/huaxia/java2/treemap/TreeSetExample.java)
* [TreeSetDemo](../huaxia/src/com/huaxia/java2/treemap/TreeSetDemo.java)
* [Video for insertion sort](images/insertionsort.mp4)

## References
* [Wetsite tutorial](https://jenkov.com/tutorials/java-collections/queue.html)
* [Algorithms](https://www.programiz.com/dsa/why-algorithms)
* [CSC150 Chapter 3:Efficiency of Algoritms](http://faculty.otterbein.edu/psanderson/csc150/notes/chapter3.html)
* []()