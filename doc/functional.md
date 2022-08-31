<h1>Functional Programing</h1>

- [Anonymous class](#anonymous-class)
- [lambda expression](#lambda-expression)
- [map](#map)
- [filter](#filter)
- [reduce](#reduce)
- [stream()](#stream)
- [pass function as parameter](#pass-function-as-parameter)
- [callback](#callback)
- [References](#references)


❓ What is Functional Programing?
>✔️ Basically, functional programming is a style of writing computer programs that treat computations as evaluating mathematical functions.

In mathematics, a function is an expression that relates an input set to an output set.

$$ f(x) = ax^3 + bx^2 + cx + d$$

## Anonymous class

```java
Collections.sort(numbers, new Comparator<Integer>() { // anonymous class
    @Override
    public int compare(Integer n1, Integer n2) {
        return n1.compareTo(n2);
    }
});
```

[Functional programming](https://belief-driven-design.com/functional-programm-with-java-map-filter-reduce-77e479bd73e/)


## lambda expression
* [Simple lambda expression](../datastructure/src/functional/Lambda.java)

## map
* [Java map() function](../datastructure/src/functional/Map.java)

## filter

* [Java filter() function](../datastructure/src/functional/Filter.java)

## reduce

```
stream.reduce(initialValue, func);
stream.reduce(func);
```
* [Java reduce() function](../datastructure/src/functional/Reduce.java)

## stream()

![](images/stream.png)

* [stram, map, average()](../datastructure/src/array/array5.java)
* [Vector, stream, map, average()](../datastructure/src/builtins/MyVector.java)
* [normal loop vs. functional](../datastructure/src/functional/Stream.java)
* [Stream sort](../datastructure/src/functional/StreamSort.java)

## pass function as parameter

* [Pass interface as parameter](../datastructure/src/functional/PassFunction.java)
* [Pass function by reflect](../datastructure/src/functional/PassFunction1.java)


## callback

* [Java Callback Function](../datastructure/src/functional/Callback.java)

## References
* [Optional Parameters](https://devwithus.com/java-optional-parameters/)
* [Pass function](https://www.delftstack.com/howto/java/how-to-pass-a-function-as-a-parameter-in-java/)