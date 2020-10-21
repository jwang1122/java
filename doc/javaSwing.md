# Java Swing Class

[Tutorial website](https://www.javatpoint.com/java-swing)
[javax.swing api](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
[Java API](https://docs.oracle.com/javase/8/docs/api/)

## Swing Layout
[Swing Layout](https://www.tutorialspoint.com/swing/swing_layouts.htm)

The layout manager automatically positions all the components within the container. 
Layout Manager

* √ remove setLayout(null) from FourCornersImages.java
* √ FlowLayout.java; change the window size feel the button position changes. remove frame.pack() function call, see the result. 
    - ask student add code for button click response
    - ask student add more component in the panel, such as JTextField, and JLabel
* BorderLayoutExample.java; resize the window. 
    - BorderLayoutExample1.java; ask student add more components in the center as FlowLayout.
* CardLayoutExample.java; class level attributes, JFrame.getContentPanel()
* BoxLayoutExample.java;
* GridLayoutExample.java;
* GridBagLayoutExample.java;
* SpringLayoutExample.java;
* GroupLayoutExample.java;



## Swing Hierarchy
![Container](Swing.png)

## Swing JComponent
[Java Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html)
[JRadio Button](https://www.geeksforgeeks.org/jradiobutton-java-swing/?ref=lbp)
1. √ OpenWIndow.java; show JFrame window
1. √ AddButton.java; add a button to JFrame
1. √ AddTextField.java; add both TextField and Button in JFrame with button click response
1. √ AddLabel.java; add JLabel in the JFrame
1. √ Frame2.java; Extends JFrame
1. √ DisplayImage.java & MyPanel.java; display an apple image, load some image from internet
1. √ FourCornersImages.java; Homework, display images in JFrame
1. MovingImage.java & MyPanel1.java
1. RandomMovineImage.java & MyPanel3.java
1. KeyboardControl.java & MyPanel2.java
1. CheckBoxExample.java & CheckBoxExample1.java; (with icon)
1. RadioButtonExample.java; 2 ways to add an ActionListener for jButton
1. ListExample.java; without layout(FlowLayout), use GridLayout(), use BorderLayout() 
1. ListExample2.java; with scroll
1. listExample1.java; select birthday



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
