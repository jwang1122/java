<h1>Snake Eat Apple</h1>

## Start Up

1. create package
2. [Game Main Frame](../src/snake/Game.java)
3. [Snake Eat Apple](../src/snake/SnakeEatApple.java)
4. [Apple](../src/snake/Apple.java)
5. [Snake](../src/snake/Snake.java)
6. [Position](../src/snake/Positin.java)
7. [Board Panel](../src/snake/BoardPanel.java)
8. [Rect](../../game2D/src/game2D/Rect.java)
9. [Size](../../game2D/src/game2D/Size.java)


## Objects
> Object oriented programming means:
> 1. higher readibility
> 2. easyer to maintain
> 3. function or class may be used in other place

💡👉 **Knowlodge Base**
> Use Java to develop application doesn't mean you write OOP code.

```mermaid
classDiagram

class Snake{
    head:Image
    tail:Image
    move()
}

class Apple{
    img:Image
    locateApple()
}

class Game{
    snake:Snake
    apple:Apple
    placeApple()
    checkCollision()
}

class BoardPanel{
    timer:Time
    paint()

}
class SnakeEatApple{
    main()
}

class Rect{
    left:int
    top:int
    collidepoint()
    colliderect()
    move_ip()
}
SnakeEatApple *-- Game
Game *-- Apple
Game *-- Snake
Game *-- BoardPanel
Apple *-- Rect:composition
Snake o-- Rect:aggregation

```

## Move snake
![](snakemove.png)

[Snake eat apple startup](../src/snake/SnakeEatApple.java)
[Cannot override JPanel.paint() method for drawing snake](../old/Game1.java)
[Snake](../old/Snake1.java)
[Apple](../old/Apple2.java)
[Rect](../old/Rect1.java)

![](snakemove.png)
* [Understand how to move snake, create new head position](../old/Snake1.java)
* [move snake within window](../old/Snake3.java)

## Control snake by arrow keys

* define a dictionay as key-value pair with keyboard key as key, and speed as value:

```java
static Hashtable<Integer, Position> arrowDirections = new Hashtable<>();
static {
    arrowDirections.put(KeyEvent.VK_LEFT, new Position(-10, 0));
    arrowDirections.put(KeyEvent.VK_RIGHT, new Position(10, 0));
    arrowDirections.put(KeyEvent.VK_UP, new Position(0, -10));
    arrowDirections.put(KeyEvent.VK_DOWN, new Position(0, 10));		
}
```
* create inner class ArrowKey for key control
  
```java
class ArrowKey extends KeyAdapter{

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(arrowDirections.containsKey(key)) {
            Position speed = arrowDirections.get(key);
            snake.setSpeed(speed);
        }
    }
}

```

```mermaid
classDiagram

class BoardPanel

class Component{
    addKeyListener(KeyListener)
}

class JPanel{
    addKeyListener(KeyListener)    
}

class KeyListener{
    <<interface>>
    keyPressed​(KeyEvent e)
    keyReleased​(KeyEvent e)
    keyTyped​(KeyEvent e)
}

class KeyAdapter{
    <<abstract>>
}

class ArrowKey{
    keyPressed​(KeyEvent e)
}

JPanel <|-- BoardPanel
Component <|-- JPanel
KeyAdapter <|-- ArrowKey 
KeyListener <|-- KeyAdapter
```

```mermaid
classDiagram

class MyMath{
    <<interface>>
    double add(double,double)
    double sub(double,double)
    double mul(double,double)
    double div(double,double)
}

class AbstractMath{
    <<abstract>>
}

class ConcreteMath{
    add(double, double)
}
```
💡👇 **Knowlodge Base**
> 1. interface is a group of method definitions without implementation. (such as KeyListener defined keyPressed() method)
> 2. cannot use abstract class to create instance. (such as KeyAdapter in the sample)
> 3. the abstract class implement default behavior for all methods defined in the interface it implements.
> 4. the abstract class allow us avoid implementing all methods defined in the interface.

* Understand Interface, abstract class, concrete class.

[Interface](../src/snake/MyMath.java)
[Abstract class](../src/snake/AbstractMath.java)
[Concrete class](../src/snake/ConcreteMath.java)


## DDD Demand Driven Development
> Call method on demand, then create the method.

## TDD Test Driven Development
> Write method test code before implementing the method.

```mermaid
classDiagram

class Rect{
    left:int
    top:int
    width:int
    height:int

    copy()
    moveIp()
    collidePoint()
    collideRect()
}
```