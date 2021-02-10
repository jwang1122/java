# Java Swing Class Level-I

## Table of Contents
- [Java Swing Class Level-I](#java-swing-class-level-i)
  - [Table of Contents](#table-of-contents)
  - [References](#references)
  - [Applications & build.xml](#applications--buildxml)
  - [Menu](#menu)
  - [Swing Layout](#swing-layout)
  - [Swing Hierarchy](#swing-hierarchy)
  - [Swing JComponent](#swing-jcomponent)
  - [Pane](#pane)
  - [Applications](#applications)
  - [Anonymous Class](#anonymous-class)
  - [Commonly used Methods of Component class](#commonly-used-methods-of-component-class)
  - [Create a window frame](#create-a-window-frame)
  - [Add components to frame](#add-components-to-frame)

[References](#References)

## References

## Applications & build.xml
* √ Calculator.java; add BorderLayout and GridLayout
* √ Snake-Game; Ant build.xml
* √ Tic Tac Toe, TT1.java; build jar; load image by using classpath

## Menu
1. MenuExample.java; build simple menu and sub menu
1. MenuExample1.java; add Edit menu for cut, copy, paste, selectAll
1. MenuExample2.java; surround JTextArea with JScrollPane.
1. PopupMenuExample.java; build simple popup menu, no action
1. PopupMenuExample1.java; anonymous class for ActionListener
1. PopupMenuExample.java; implements ActionListener.
1. SeparatorExample.java; add separator line between menu item.

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
1. √ OpenWindow.java; show JFrame window
1. √ AddButton.java; add a button to JFrame
1. √ AddTextField.java; add both TextField and Button in JFrame with button click response
1. √ AddLabel.java; add JLabel in the JFrame
1. √ Frame2.java; Extends JFrame
1. √ DisplayImage.java & MyPanel.java; display an apple image, load some image from internet
1. √ FourCornersImages.java; Homework, display images in JFrame
1. √ MovingImage.java & MyPanel1.java
1. √ RandomMovineImage.java & MyPanel3.java
1. √ KeyboardControl.java & MyPanel2.java
1. √ CheckBoxExample.java & CheckBoxExample1.java; (with icon)
1. √ RadioButtonExample.java; 2 ways to add an ActionListener for jButton
1. √ TextAreaExample.java; copy large file to see some text been hidden.
1. √ ScrolledPaneExample.java; add JScroll Pane around the TextArea
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
* OpenWindow.java
* Frame2.java

## Add components to frame
* AddButton.java
* AddTextField.java
* AddLabel.java
