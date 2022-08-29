<h1>Functional Programing</h1>

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

* [Java reduce() function](../datastructure/src/functional/Reduce.java)

## stream()
* [stram, map, average()](../datastructure/src/array/array5.java)
* [Vector, stream, map, average()](../datastructure/src/builtins/MyVector.java)
* []()

## References
* [Optional Parameters](https://devwithus.com/java-optional-parameters/)