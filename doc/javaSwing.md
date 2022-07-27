# Java Swing Class

[Tutorial website](https://www.javatpoint.com/java-swing)
[javax.swing api](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
[Java API](https://docs.oracle.com/javase/8/docs/api/)
[Image download website](http://www.pngmart.com/image/)
[Official Java Tutorial](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)

## Applications & build.xml
* [Calculator.java](../swing/src/com/huaxia/calculator/Calculator.java); add BorderLayout and GridLayout
* [Snake-Game](../Snake-Game/build.xml)
* √ Tic Tac Toe, TT1.java; build jar; load image by using classpath

## Swing Layout
[Swing Layout](https://www.tutorialspoint.com/swing/swing_layouts.htm)

The layout manager automatically positions all the components within the container. 
Layout Manager

* √ remove setLayout(null) from FourCornersImages.java
* √ FlowLayout.java; change the window size feel the button position changes. remove frame.pack() function call, see the result. 
    - ask student add code for button click response
    - ask student add more component in the panel, such as JTextField, and JLabel
* √ BorderLayoutExample.java; resize the window. 
    - BorderLayoutExample1.java; ask student add more components in the center as FlowLayout.
* √ CardLayoutExample.java; class level attributes, JFrame.getContentPanel()
* √ BoxLayoutExample.java; disappare when change Window size.
* √ GridLayoutExample.java;
* √ GridBagLayoutExample.java;
* √ SpringLayoutExample.java; Fixed relationship between components
* √ GroupLayoutExample.java; need set both Horizontal and Vertical

## Swing Hierarchy
![Container](Swing.png)

## Swing JComponent
[Java Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html)
[JRadio Button](https://www.geeksforgeeks.org/jradiobutton-java-swing/?ref=lbp)

* [Open Window](../swing/src/com/huaxia/component/OpenWindow.java)
* [Add Label](../swing/src/com/huaxia/component/AddLabel.java)
* [Add Button](../swing/src/com/huaxia/component/AddButton.java)
* [Add TextField](../swing/src/com/huaxia/component/AddTextField.java)
* [Open Frame](../swing/src/com/huaxia/component/Frame2.java)

## Display Image
DisplayImage.java & MyPanel.java; display an apple image, load some image from 
*  [DisplayImage](../swing/src/com/huaxia/image/DisplayImage.java)

## JPanel
*  [Image Panel](../swing/src/com/huaxia/image/MyPanel.java)
*  [Button switch image](../swing/src/com/huaxia/image/FourCornersImage.java)
  
√ MovingImage.java & MyPanel1.java
*  [Moving Image](../swing/src/com/huaxia/image/MoveImage.java) 
*  [Moving Image Panel](../swing/src/com/huaxia/image/MyPanel1.java)
*  [Key Controlled Image](../swing/src/com/huaxia/image/KeyboardControl.java)
*  [Key Controlled Image Panel](../swing/src/com/huaxia/image/MyPanel2.java)
*  [Random Moving Image](../swing/src/com/huaxia/image/RandomMoveImage.java)
10. [Random Moving Imabe Panel](../swing/src/com/huaxia/image/MyPanel3.java)
11. [Bounced Image](../swing/src/com/huaxia/image/DisplayBouncedImage.java)
12. [Bounced Image Panel](../swing/src/com/huaxia/image/MyPanel4.java)
13. [Bufferred Image](../swing/src/com/huaxia/image/DisplayBufferedImage.java)
23. [Bufferend Image Panel](../swing/src/com/huaxia/image/MyPanel5.java)
24. [Random Ball Image](../swing/src/com/huaxia/image/DiaplayBallImage.java)
25. [Ball Image Panel](../swing/src/com/huaxia/image/MyPanel6.java)
26. [Simple add math](../swing/src/com/huaxia/image/MyMath.java)
27. [Check Box](../swing/src/com/huaxia/component/CheckBoxExample.java)
28. [CheckBoxExample1.java](../swing/src/com/huaxia/component/CheckBoxExample1.java); (with icon)
29. [Radio Button](../swing/src/com/huaxia/component/RadioButtonExample.java)2 ways to add an ActionListener for jButton
30. [Text Area](../swing/src/com/huaxia/component/TextAreaExample.java) copy large file to see some text been hidden.
31. [Scrolled Pane](../swing/src/com/huaxia/pane/ScrolledPaneExample.java)Scrolled Pane around the TextArea
32. [List](../swing/src/com/huaxia/component/ListExample.java)
33. [List 1](../swing/src/com/huaxia/component/ListExample1.java)
34. [List 2](../swing/src/com/huaxia/component/ListExample2.java) without layout(FlowLayout), use GridLayout(), use BorderLayout() 
35. [OptionPane](../swing/src/com/huaxia/pane/OptionPaneExample.java);
36. [ComboBox](../swing/src/com/huaxia/component/ComboBoxExample.java) 
37. [ComboBox1](../swing/src/com/huaxia/component/ComboBoxExample1.java); ActionListener, ItemListener; ask student add clear button to clear label message.

## Layout
* [Flow Layout](../swing/src/com/huaxia/layout/FlowLayoutExample.java)
* [Border Layout](../swing/src/com/huaxia/layout/BorderLayoutExample.java)
* [Embedded Border Layout](../swing/src/com/huaxia/layout/BorderLayoutExample1.java)
* [Grid Layout](../swing/src/com/huaxia/layout/GridLayoutExample.java)
* [Grid Bag Layout](../swing/src/com/huaxia/layout/GridBagLayoutExample.java)
* [Box Layout](../swing/src/com/huaxia/layout/BoxLayoutExample.java)
![](images/BoxLayout-1.gif)
* [Box Vertical](../swing/src/com/huaxia/layout/BoxVertical.java)
* [Box Horizontal](../swing/src/com/huaxia/layout/BoxHorizontal.java)
* [Box Glue](../swing/src/com/huaxia/layout/BoxLayoutVerticalGlueTest.java)
* [Group Layout](../swing/src/com/huaxia/layout/GroupLayoutExample.java)
* [Group Layout 2](../swing/src/com/huaxia/layout/GroupLayoutExample2.java)
* [Card Layout](../swing/src/com/huaxia/layout/CardLayoutExample.java)
* [Spring Layout](../swing/src/com/huaxia/layout/SpringLayoutExample.java)
* 
## Pane
* [ScrolledPane](../swing/src/com/huaxia/swing/pane/ScrolledPaneExample.java); add JScrollPane around the TextArea
* [OptionPaneExample.java](../swing/src/com/huaxia/pane/OptionPaneExample.java);
* [TabbedPaneExmple.java](../swing/src/com/huaxia/pane/TabbedPaneExample.java);
* [DesktopPaneExample.java](../swing/src/com/huaxia/pane/DesktopPaneExample.java);
* [EditorPaneExample.java](../swing/src/com/huaxia/pane/EditorPaneExample.java);
* [EditorPaneExample1.java](../swing/src/com/huaxia/pane/EditorPaneExample1.java);


## Applications
* [Calculator.java](../swing/src/com/huaxia/calculator/Calculator.java); Default layout=FlowLayout, JFrame, JPanel, JTextField, JButton 
* [Calculator1](../swing/src/com/huaxia/calculator/Calculator1.java)
* [Tic Tac Toe](../huaxia/src/com/huaxia/tictactoe/TTT1.java); com.huaxia.tictactoe; layout=null, resizable=false; getClass().getResource() refer to MyPanel.java; CheckBox, JOptionPane,
```java
    Toolkit t = Toolkit.getDefaultToolkit();
    URL iconUrl = this.getClass().getResource("resources/tiger.jpeg");
    apple = t.getImage(iconUrl);
```
1. [Kingdomino](https://www.youtube.com/watch?v=Wo7tLXgnzzI)

 
## Anonymous Class
1. √ GetInfo.java; interface
1. √ Student.java; implements GetInfo
1. √ Teacher.java; implements GetInfo
1. √ StudentTest.java; test GetInfo, build Polymorpythism concept. 3 way to use Interface.
1. √ JButton.addActionListener(ActionEvent) 

## Commonly used Methods of Component class
Method |	Description
|---|---|
public void add(Component c)	|add a component on another component.
public void setSize(int width,int height)	|sets size of the component.
public void setLayout(LayoutManager m)	|sets the layout manager for the component.
public void setVisible(boolean b)	|sets the visibility of the component. It is by default false.

## Create a window frame

* [OpenWindow.java](../swing/src/com/huaxia/swing/component/OpenWindow.java)
* [Frame2.java](../swing/src/com/huaxia/swing/component/Frame2.java)

## Add components to frame
* [AddButton.java](../swing/src/com/huaxia/swing/component/AddButton.java)
* AddTextField.java
* AddLabel.java

## Blackjack Card Game

Board or card game, no object motion

## Snake Eat Apple
object motion game
[](../snake/src/snake/SnakeEatApple.java)

## Kingdomino
Board or card game, no object motion

[](https://www.gamesweb.dk/spilleregler/kingdomino_eng.pdf)

[](../kingdomino/src/com/huaxia/kingdomino/Kingdomino.java)

![](images/bigwinner.png)
🎯 Difficulty
> Calculate the score (顺藤摸瓜-Follow the trail)

## Five in line
[](../fiveinline/src/fiveinline/FiveInLine.java)
🎯 Difficulty
> How to determine 5 chesses in line?

![](images/fileinline.png)


## Tetris
[](../tetris/src/tetris/TetrisApp.java)
🎯 Difficulty
> 1. How to build a tetris shape?
> 2. how to turn the tetris shape?
> 3. how to figure out the tetris touch another onw?
> 4. how to determine the one line is filled up, so we can remove it.

## kick Brick down
🎯 Difficulty
> how to determine the ball hit the brick

## Yahtzee Rules

[Dice game](https://www.hasbro.com/common/instruct/yahtzee.pdf)

## Cannon Bumb
![](../kingdomino/doc/images/canyonBomber.gif)

## JetFighter
![](../kingdomino/doc/images/jetFighter.gif)

## References
[Java tutorial](http://www.java2s.com/Tutorial/Java/0240__Swing/BoxcreateVerticalGlue.htm)