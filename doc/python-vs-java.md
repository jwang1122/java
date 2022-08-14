# Python vs. Java

* Both Java and Python are Object Oriented Programing language.
* Java start with class, need understand everyting about class to write Java program.
* Python start with code block, no need to understand class for beginer.

## Java

```mermaid
graph TB

A([java programing])
B[class<br>Data Type]
C[name]
D[attributes]
E[methods]
F[constructor<br>return instance of the class]
G[static method<br>called by class name]
H[none-static method]
I[abstract method]

A --is nothing but write--> B
B --includes--> C & D & E
E --could be --> F & G & H & I

classDef start fill:green,stroke:#DE9E1F,stroke-width:2px,color:white;
classDef process fill:#F46624,stroke:#F46624,stroke-width:4px,color:white;
classDef js fill:yellow,stroke:black,stroke-width:2px;

class A start
class B process
class F,G,H,I js
```

* Simple java code

```java
public class Hello{
    public static void main(String[] args){
        System.out.println("Hello, the world!");
    }
}
```

* Simple math: calculate circle area,

```java
package mymath;

public class MyMath{
    public double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        MyMath math = new MyMath();
        double area = math.circleArea(2.3);
        System.out.println(area);
    }
}

```

## Python

```mermaid
graph TB

START([Python Program])
A[Python Code]
C[Python function]
D[Python class]
N[Name]
E[Attributes]
F[Functions]


START-->A & C & D
D-->N & E & F

classDef html fill:#F46624,stroke:#F46624,stroke-width:4px,color:white;
classDef js fill:yellow,stroke:#DE9E1F,stroke-width:2px;
classDef start fill:#53DE1F,stroke:#267608,stroke-width:2px;

class START start
class A,C,D html
```

* Simple Python code

```py
print('Hello, the world!')
```

* Simple math: calculate circle area,

```py
from math import pi

def circleArea(radius):
    return pi * radius * radius

a = circleArea(2.3)
print(a) 
```

* Simple plot

```py
import matplotlib.pyplot as plt

plt.plot([1,2,3,4])
plt.show()
```

![](images/strightLinePlot.png)