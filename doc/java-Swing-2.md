# Java Swing Class Level-II

[enum](#enum)

[Data Structure](#Data-Structure)

[Menu](#Menu)

[Swing JComponent](#Swing-JComponent)

[Pane](#Pane)

[Understand Kingdomino](#Understand-Kingdomino)

[Build Blackjack from scratch](#Build-Blackjack-from-scratch)

[Annotations](#Annotations)

[Applications](#Applications)

[](#)
[](#)

## enum
* enum1.java (Weekdays.java)
* Planet.java (args in main method, Run> Run Configurations...> Arguments > Program arguments)
* Exercises: Card.java, Face.java, Suit.java, Deck

## Data Structure
* LinkedList.java
* linkedlist (java project)

![Circular-doubly-linked-list](Circular-doubly-linked-list.png)
WordChecker.pdf

## Annotations
```java
@Override
public String toString(){
    ...    
}
```

## Menu
1. MenuExample.java; build simple menu and sub menu
1. MenuExample1.java; add Edit menu for cut, copy, paste, selectAll
1. MenuExample2.java; surround JTextArea with JScrollPane.
1. PopupMenuExample.java; build simple popup menu, no action
1. PopupMenuExample1.java; anonymous class for ActionListener
1. PopupMenuExample.java; implements ActionListener.
1. SeparatorExample.java; add separator line between menu item.

## Swing JComponent
1. ListExample.java; without layout(FlowLayout), use GridLayout(), use BorderLayout() 
1. ListExample2.java; with scroll
1. listExample1.java; select birthday
1. OptionPaneExample.java;
1. ComboBoxExample.java 
1. ComboBoxExample1.java; ActionListener, ItemListener; ask student add clear button to clear label message.

## Pane
1. ScrolledPaneExample.java; add JScrollPane around the TextArea
1. OptionPaneExample.java;
1. TabbedPaneExmple.java;
1. DesktopPaneExample.java;
1. EditorPaneExample.java;
1. EditorPaneExample1.java;

## Understand Kingdomino
* Keep Reading Existing Source Code
* Debug Existing Code
* Create unit test for Existing Code
* Document Existing Code (Java Doc, Markdown)
* Relationship between classes

![Kingdomino Classes](KingdominoClasses.png)
* Game logic

![Logic](gameLogic.png)
* Pick up Domino (Player>DominoPositionListener)
* Place Domino (Board.insertDomino())

![Place Domino](placeDomino.png)

![Kingdomino Layout](KingdominoLayout.png)
* load images (Terrain.java, Player.java)
* is Diagnal? (Board Unit test)
* is Occupied? (Board Unit test)
* is Out of 5X5 frame?
* Has Same Terrain arround?
* About Message.java
* Calculate score (Board.calculateScore())
* Display Result
* Configure the Kingdomino Game (think about the future)

![Calculate Score](scoreLogic.png)




## Build Blackjack from scratch
[Blackjack Rules](https://casinorange.com/how-to/how-to-play-blackjack#)
* Big Picture

![Classes Relationship](BlackJackClasses.png)
* Card.java
* BlackJackCard.java
* Deck.java
* Blackjack.java
* BlackJackFrame.java
* Player.java
* Dealer.java

## Applications
1. √ Calculator.java; Default layout=FlowLayout, JFrame, JPanel, JTextField, JButton 
1. Tic Tac Toe; com.huaxia.tictactoe; layout=null, resizable=false; getClass().getResource() refer to MyPanel.java; CheckBox, JOptionPane,
```java
    Toolkit t = Toolkit.getDefaultToolkit();
    URL iconUrl = this.getClass().getResource("resources/tiger.jpeg");
    apple = t.getImage(iconUrl);
```
1. Snake
1. Kingdomino
