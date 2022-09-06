<h1>Java Design Pattern</h1>

- [Creational Pattern](#creational-pattern)
  - [Factory Pattern](#factory-pattern)
  - [Singleton Pattern](#singleton-pattern)
  - [Prototype Pattern](#prototype-pattern)
  - [Builder Pattern](#builder-pattern)
- [Structural Pattern](#structural-pattern)
  - [Adapter Pattern](#adapter-pattern)
  - [Brigde Patter](#brigde-patter)
  - [Composite Pattern](#composite-pattern)
  - [Decorator Pattern](#decorator-pattern)
  - [Facade Pattern](#facade-pattern)
  - [Proxy Pattern](#proxy-pattern)
- [Behavioral Pattern](#behavioral-pattern)
  - [Command Pattern](#command-pattern)
  - [Iterator Pattern](#iterator-pattern)
  - [Observer Pattern](#observer-pattern)
  - [State Pattern](#state-pattern)
  - [Strategy Pattern](#strategy-pattern)
  - [Template Pattern](#template-pattern)
- [References](#references)


## Creational Pattern

### Factory Pattern
* [Factory pattern test](../designPattern/src/creational/singleton/FactoryPatternTester.java)

### Singleton Pattern
* [Singleton pattern test](../designPattern/src/creational/singleton/SingletonTest.java)
  
### Prototype Pattern
* [Prototype pattern test](../designPattern/src/creational/prototype/PrototypeTest.java)

### Builder Pattern
* [Builder pattern test](../designPattern/src/creational/builder/BuilderTest.java)


## Structural Pattern
### Adapter Pattern
* [Adapter pattern test](../designPattern/src/structural/adapter/AdapterTest.java)

### Brigde Patter
* [Bridge pattern test](../designPattern/src/structural/bridge/BridgeTest.java)

### Composite Pattern
* [Composite pattern test](../designPattern/src/structural/composite/CompositeTest.java)

### Decorator Pattern
> 1. Allow to modify an object dynamically
> 2. add functionality at run time
> 3. it is more flexible than inheritance

* [Pizza without pattern](../designPattern/src/structural/decorator/ThreeCheesPizza.java)

```mermaid
classDiagram

class Shape{
    <<interface>>
    draw()
}


class ShapeDecorator{
    <<abstract>>
    constructor(Shape)
}

Shape <-- Circle
Shape <-- Rectangle
Shape <-- ShapeDecorator
```

* [Decorator Pattern](../designPattern/src/DecoratorTest.java)

```mermaid
classDiagram

class Pizza{
    <<interface>>
    getDescription():String
    getCost():double
}

class ToppingDecorator{
    <<abstract>>
    pizza: Pizza
    ToppingDecorator(Pizza)
}

Pizza <-- PlainPizza
Pizza <-- ToppingDecorator
ToppingDecorator o-- Pizza: has
ToppingDecorator <|-- Mozzarella
ToppingDecorator <|-- Fontina
ToppingDecorator <|-- Mushroom
ToppingDecorator <|-- Paper
```

* [Pizza Topping](../designPattern/src/structural/decorator/PizzaTest.java)

### Facade Pattern
* [Facade Pattern test](../designPattern/src/structural/facade/FacadeTest.java)

### Proxy Pattern
* [Proxy Pattern test](../designPattern/src/structural/proxy/ProxyTest.java)


## Behavioral Pattern
### Command Pattern

```mermaid
classDiagram

class Stock{
  name:String
  quantity:int
  buy()
  sell()
}

class Order{
  <<interface>>
  execute()
}

class BuyStock{
  stock:Stock
}

class SellStock{
  stock:Stock
}

Order <-- BuyStock
Order <-- SellStock
BuyStock o-- Stock
SellStock o-- Stock
```
where Order is acting as command. there will be two commands for stock: 1. buy; 2. sell.

* [Command pattern test](../designPattern/src/structural/command/CommandTest.java)

### Iterator Pattern

```mermaid
classDiagram

class Iterator{
  <<interface>>
  boolean hasNext()
  Object next()
}

class Container{
  <<interface>>
  Iterator getIterator()
}

class NameRepository{
  name:String[]
}

Iterator<--NameIterator
Container<--NameRepository
NameRepository o-- NameIterator
```
* [Iterator pattern test](../designPattern/src/structural/iterator/IteratorTest.java)


### Observer Pattern

```mermaid
classDiagram

class Observer{
    <<interface>>
    subject: Subject
    update()
}

class Subject{
    observers:List
    state:int
    getState()
    setState()
    attach()
    notifyAllObservers()
    register()
    remove()
}

class BinaryObserver
class OctalObserver
class HexObserver

Observer <-- BinaryObserver
Observer <-- OctalObserver
Observer <-- HexObserver
Subject *-- Observer
```
* [Observer pattern test](../designPattern/src/behavioral/observer/ObserverTest.java)

### State Pattern


* [State pattern test](../designPattern/src/behavioral/state/StateTest.java)
 
### Strategy Pattern

```mermaid
classDiagram

class Strategy{
  <<interface>>
  int doOperation()
}

Strategy <-- OperationAdd
Strategy <-- OperationSubstract
Strategy <-- OperationMultiply

class Context{
  strategy:Strategy
  int executeStrategy()
}

Context o-- Strategy
```
One Context run different operations.

> **strategy**: a detailed plan for achieving success in situations such as war, politics, business, industry, or sports, or the skill of planning for such situations.

* [Strategy pattern test](../designPattern/src/behavioral/strategy/StrategyTest.java)

### Template Pattern

```mermaid
classDiagram

class Game{
  <<abstract>>
  initialize()
  startPlay()
  endPlay()
  play()
}

Game <|-- Cricket
Game <|-- Football
```
where Game class as an template for all different games.

* [Template pattern test](../designPattern/src/behavioral/template/TemplateTest.java)

## References
[👍😄 Better design patter website](https://www.tutorialspoint.com/design_pattern/observer_pattern.htm)
[Design pattern website](https://www.javatpoint.com/design-patterns-in-java)