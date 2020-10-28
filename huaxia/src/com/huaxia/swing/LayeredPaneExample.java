package com.huaxia.swing;

import javax.swing.*;
import java.awt.*;

public class LayeredPaneExample extends JFrame {

	private static final long serialVersionUID = 1L;

	public LayeredPaneExample() {
		super("LayeredPane Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		JLayeredPane pane = getLayeredPane();
		// creating buttons
		JButton top = new JButton();
		top.setBackground(Color.white);
		top.setBounds(20, 20, 50, 50);
		JButton middle = new JButton();
		middle.setBackground(Color.red);
		middle.setBounds(40, 40, 50, 50);
		JButton bottom = new JButton();
		bottom.setBackground(Color.cyan);
		bottom.setBounds(60, 60, 50, 50);
		// adding buttons on pane
		pane.add(bottom, 0);
		pane.add(middle, 1);
		pane.add(top, 2);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LayeredPaneExample();		
	}
}