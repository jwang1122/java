<h1>Snake Eat Apple</h1>

## Start Up

1. create package
2. [Game Main Frame](../src/snake/Game.java)
3. [Snake Eat Apple](../src/snake/SnakeEatApple.java)
4. [Apple](../src/snake/Apple.java)
5. [Snake](../src/snake/Snake.java)
6. [Position](../src/snake/Positin.java)
7. [Board Panel](../src/snake/BoardPanel.java)
8. [Rect](../src/snake/Rect.java)


## Objects
1. higher readibility
2. easyer to maintain
3. function or class can be used in other place


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
    moveSnake()
    placeApple()
    checkCollision()
}

class SnakeEatApple{
    main()
}

SnakeEatApple *-- Game
Game *-- Apple
Game *-- Snake
```

[Snake eat apple startup](../src/snake/SnakeEatApple.java)
[Cannot override JPanel.paint() method for drawing snake](../src/snake/Game1.java)
[Snake](../src/snake/Snake.java)
[Apple](../src/snake/Apple.java)
[Rect](../src/snake/Rect.java


