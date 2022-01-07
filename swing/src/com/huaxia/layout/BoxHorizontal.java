package com.huaxia.swing.layout;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxHorizontal {
  public static void main(String args[]) {
    JFrame horizontalFrame = new JFrame("Horizontal");
    horizontalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Box horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new JLabel("Left"));
    horizontalBox.add(new JTextField("Middle"));
    horizontalBox.add(new JButton("Right"));
    horizontalFrame.add(horizontalBox, BorderLayout.CENTER);
    horizontalFrame.setSize(150, 150);
    horizontalFrame.setVisible(true);
  }
}