# 华夏中文学校 Java level-II

[Understand Kingdomino Game](#Understand-Kingdomino-Game)

[enum](#enum)

[Functional Programming](#Functional-Programming)

[Reactive x in Java](#Reactive-x-in-Java)

[class](#class)

[build Blackjack Card Game](#build-Blackjack-Card-Game)


[Gson](#Gson)


[Design Pattern](#Design-Pattern)

[](#)

[Applications](#Applications)

## Design Pattern
* Observer

* Singleton
* Factory
* Builder
* Decorator
* Strategy
* Command
* Bridge
* Facade
* Prototype

## Gson
[Gson Tutorial](https://mkyong.com/java/how-to-parse-json-with-gson/)
* GsonExample1.java
* GsonExample2.java
* GsonExample3.java; read json file, return ArrayList<Book>

## Understand Kingdomino Game
* BoarderTest.java; Unittest
* PlayerTest.java;
* CardTest.java;
* DeckTest.java;
* MessageTest.java;
* PositionTest.java;
### Test Driving Development
* practice: simaple math: add(), sub(), mul(), div()

## enum
* DividedByZero.java; Traditional programming, NullPointException
* EitherExample.java; 

## Functional Programming

## Reactive x in Java

![Reactive Action](./images/ReactiveAction.gif)
* DividedByZero.java; normal way to handle exception
* OptionExample1.java; DividedByZero, Option way
* EitherExample2.java; use Either for / by zero
* EitherExample1.java; Use Gson convert json file to book list
* Employee.java; use filter
* MultipleReturn1.java; use Hashmap for function return multiple values.
* Operation.java; abstract class
* OptionExample1.java; 

## class
* Static Class; StaticClassExample.java
* Final Class; FinalClassExample.java > final class cannot be inheriated.
* Abstract Class; Operation.java > can define constant, abstract method, and concret method.
* Concrete Class; ConcreteClassExample.java
* Singleton Class; SingletonClassExample.java; StaticAttribute.java
* POJO Class; Plain Old Java Object > PojoClassExample.java
    - It does not extend the predefined classes such as Arrays, HttpServlet, etc.
    - It cannot contain pre-specified annotations.
    - It cannot implement pre-defined interfaces.
    - It is not required to add any constructor.
    - All instance variables must be private.
    - The getter/ setter methods must be public.
* Inner Class; OuterClass.java, AnonymousClassExample.java (Swing use a lot)

## build Blackjack Card Game

## Logging
    - Log all the things. Log as much as we possibly can, to always have relevant, contextual logs that don’t add overhead.
    - Work smarter, not harder. Consolidate and aggregate all of our logging to a central location, available to all devs, and easy to distil. Also, to find new ways for our logging and exception data to help us proactively improve our product.
* C:\Program Files\Java\jdk-14.0.2\conf\logging.properties
make change on this file will make FileHandler on level FINE, and ConsoleHandler on INFO
```
handlers= java.util.logging.FileHandler, java.util.logging.ConsoleHandler
.level= FINE
java.util.logging.FileHandler.pattern = %h/java%u.log
java.util.logging.FileHandler.limit = 50000
java.util.logging.FileHandler.count = 1
java.util.logging.FileHandler.maxLocks = 100
java.util.logging.FileHandler.formatter = java.util.logging.XMLFormatter
java.util.logging.ConsoleHandler.level = INFO
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
```

## Applications
* Calculator
* Notepade
* Snake-Game
* Kingdomino
* Tic Tac Toe
* Blackjack Card Game

## References
[Java Class Type](https://www.javatpoint.com/types-of-classes-in-java)

[Gson Tutorial](https://mkyong.com/java/how-to-parse-json-with-gson/)

[Design Patter Tutorial](https://www.journaldev.com/1827/java-design-patterns-example-tutorial)
