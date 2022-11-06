# Java Swing Class

[Tutorial website](https://www.javatpoint.com/java-swing)
[javax.swing api](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
[Java API](https://docs.oracle.com/javase/8/docs/api/)
[Image download website](http://www.pngmart.com/image/)
[Official Java Tutorial](https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html)

- [Java Swing Class](#java-swing-class)
  - [Swing Hierarchy](#swing-hierarchy)
  - [Swing JComponent](#swing-jcomponent)
    - [Anonymous class](#anonymous-class)
  - [Display Image](#display-image)
  - [JPanel](#jpanel)
  - [Layout](#layout)
  - [Pane](#pane)
  - [Applications](#applications)
  - [Anonymous Class](#anonymous-class-1)
  - [Commonly used Methods of Component class](#commonly-used-methods-of-component-class)
  - [Create a window frame](#create-a-window-frame)
  - [Add components to frame](#add-components-to-frame)
  - [Blackjack Card Game](#blackjack-card-game)
  - [Snake Eat Apple](#snake-eat-apple)
  - [Kingdomino](#kingdomino)
  - [Five in line](#five-in-line)
  - [Tetris](#tetris)
  - [kick Brick down](#kick-brick-down)
  - [Yahtzee Rules](#yahtzee-rules)
  - [Cannon Bumb](#cannon-bumb)
  - [JetFighter](#jetfighter)
  - [Applications & build.xml](#applications--buildxml)
  - [References](#references)



## Swing Hierarchy
![Container](Swing.png)

## Swing JComponent
[Java Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html)
[JRadio Button](https://www.geeksforgeeks.org/jradiobutton-java-swing/?ref=lbp)

* [Open Window](../src/swing/component/OpenWindow.java)
* [Add Label](../src/swing/component/AddLabel.java)
* [Add Button](../src/swing/component/AddButton.java)
### Anonymous class
* 3 ways to add an ActionListener for jButton
    1. anonymous class
    2. implements interface
    3. create named class which implements the interface.

```java
public interface Calculate(){
    double doCalculation(double x, double y);
}
package oop;

public class Girl {

	Calculate simpleMath;
	
	public void addActionListener(Calculate sm) {
		simpleMath = sm;
	}
	
	public static void main(String[] args) {
		Girl girl = new Girl();
		girl.addActionListener(new Calculate() { // anonymous class

			@Override
			public double doCalculation(double x, double y) {
				return x+y;
			}
		});
		
		double z = girl.doCalculation(3.0, 5.8);
		System.out.println(z);
		
		Girl girl2 = new Girl();
		girl2.addActionListener(new Calculate() {
			@Override
			public double doCalculation(double x, double y) {
				// TODO Auto-generated method stub
				return x*y;
			}
			
		});
		
		z = girl2.doCalculation(5.6, 8.7);
		System.out.println(z);
	}

}

```

* [Add TextField](../src/swing/component/AddTextField.java)
* [Open Frame](../src/swing/component/Frame2.java)
*  [Check Box](../src/swing/component/CheckBoxExample.java)
*  [CheckBoxExample1.java](../src/swing/component/CheckBoxExample1.java); (with icon)
*  [Radio Button](../src/swing/component/RadioButtonExample.java)
* [Text Area](../src/swing/component/TextAreaExample.java) copy large file to see some text been hidden.
1.  [Scrolled Pane](../src/swing/pane/ScrolledPaneExample.java)Scrolled Pane around the TextArea
2.  [List](../src/swing/component/ListExample.java)
3.  [List 1](../src/swing/component/ListExample1.java)
4.  [List 2](../src/swing/component/ListExample2.java) without layout(FlowLayout), use GridLayout(), use BorderLayout() 
5.  [OptionPane](../src/swing/pane/OptionPaneExample.java);
6.  [ComboBox](../src/swing/component/ComboBoxExample.java) 
7.  [ComboBox1](../src/swing/component/ComboBoxExample1.java); ActionListener, ItemListener; ask student add clear button to clear label message.

## Display Image
DisplayImage.java & MyPanel.java; display an apple image, load some image from 
*  [DisplayImage](../src/swing/image/DisplayImage.java)

## JPanel
*  [Image Panel](../src/swing/image/MyPanel.java)
*  [Button switch image](../src/swing/image/FourCornersImage.java)
  
√ MovingImage.java & MyPanel1.java
*  [Moving Image](../src/swing/image/MoveImage.java) 
*  [Moving Image Panel](../src/swing/image/MyPanel1.java)
*  [Key Controlled Image](../src/swing/image/KeyboardControl.java)
*  [Key Controlled Image Panel](../src/swing/image/MyPanel2.java)
*  [Random Moving Image](../src/swing/image/RandomMoveImage.java)
*  [Random Moving Imabe Panel](../src/swing/image/MyPanel3.java)
*  [Bounced Image](../src/swing/image/DisplayBouncedImage.java)
*  [Bounced Image Panel](../src/swing/image/MyPanel4.java)
*  [Bufferred Image](../src/swing/image/DisplayBufferedImage.java)
*  [Bufferend Image Panel](../src/swing/image/MyPanel5.java)
*  [Random Ball Image](../src/swing/image/DiaplayBallImage.java)
*  [Ball Image Panel](../src/swing/image/MyPanel6.java)
*  [Simple add math](../src/swing/image/MyMath.java)

## Layout
* [Flow Layout](../src/swing/layout/FlowLayoutExample.java)
* [Border Layout](../src/swing/layout/BorderLayoutExample.java)
* [Embedded Border Layout](../src/swing/layout/BorderLayoutExample1.java)
* [Grid Layout](../src/swing/layout/GridLayoutExample.java)
* [Grid Bag Layout](../src/swing/layout/GridBagLayoutExample.java)
* [Box Layout](../src/swing/layout/BoxLayoutExample.java)
![](images/BoxLayout-1.gif)
* [Box Vertical](../src/swing/layout/BoxVertical.java)
* [Box Horizontal](../src/swing/layout/BoxHorizontal.java)
* [Box Glue](../src/swing/layout/BoxLayoutVerticalGlueTest.java)
* [Group Layout](../src/swing/layout/GroupLayoutExample.java)
* [Group Layout 2](../src/swing/layout/GroupLayoutExample2.java)
* [Card Layout](../src/swing/layout/CardLayoutExample.java)
* [Spring Layout](../src/swing/layout/SpringLayoutExample.java)
* 
## Pane
* [ScrolledPane](../src/swing/swing/pane/ScrolledPaneExample.java); add JScrollPane around the TextArea
* [OptionPaneExample.java](../src/swing/pane/OptionPaneExample.java);
* [TabbedPaneExmple.java](../src/swing/pane/TabbedPaneExample.java);
* [DesktopPaneExample.java](../src/swing/pane/DesktopPaneExample.java);
* [EditorPaneExample.java](../src/swing/pane/EditorPaneExample.java);
* [EditorPaneExample1.java](../src/swing/pane/EditorPaneExample1.java);


## Applications
* [Calculator.java](../src/swing/calculator/Calculator.java); Default layout=FlowLayout, JFrame, JPanel, JTextField, JButton 
* [Calculator1](../src/swing/calculator/Calculator1.java)
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

* [OpenWindow.java](../src/swing/swing/component/OpenWindow.java)
* [Frame2.java](../src/swing/swing/component/Frame2.java)

## Add components to frame
* [AddButton.java](../src/swing/swing/component/AddButton.java)
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

## Applications & build.xml
* [Calculator.java](../src/swing/calculator/Calculator.java); add BorderLayout and GridLayout
* [Snake-Game](../Snake-Game/build.xml)
* √ Tic Tac Toe, TT1.java; build jar; load image by using classpath


## References
* [Java tutorial](http://www.java2s.com/Tutorial/Java/0240__Swing/BoxcreateVerticalGlue.htm)
* [Swing Layout](https://www.tutorialspoint.com/swing/swing_layouts.htm)
