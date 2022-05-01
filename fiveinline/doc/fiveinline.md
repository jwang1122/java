<h1>Five in Line Chess Game</h1>

```mermaid
classDiagram

class FiveInLine{
    main()
}
class MainFrame{
	init()
}

class BoardPanel{
    chesses:Chess[][]
    paint()
}

class Chess{
    x:int
    y:int
    row:int
    col:int
    color:Color
}

FiveInLine *-- MainFrame
MainFrame *-- BoardPanel
BoardPanel o-- Chess
```

## Source Code online
* [](../src/fiveinline/FiveChess.java)

## Getting Start
* [Start up class](../src/fiveinline/FiveInLine.java)
* [Main Frame](../savedSrc/MainFrame1.java)
  
## Draw Chess Board
👍😄 Idea: create Chess object array for every cross point on the chess board once.
* [Chess class](../savedSrc/Chess2.java)
* [Board class](../savedSrc/BoardPanel2.java)
* [MainFrame class](../savedSrc/MainFrame2.java)

![](images/chessboard.png)

## Draw Chess if any
* [Chess class add color attribute](../savedSrc/Chess3.java)
* [Board class add draw chess](../savedSrc/BoardPanel3.java)

![](images/drawchess.png)

## Mouse click response
* [get mouse click position](../savedSrc/BoardPanel4.java)
* [draw chess on mouse click](../savedSrc/BoardPanel5.java)

![](images/placechess.png)

## Check for 5 chesses in line
* [add gameover() method](../savedSrc/BoardPanel6.java)
* [implements fiveInLine() method]()