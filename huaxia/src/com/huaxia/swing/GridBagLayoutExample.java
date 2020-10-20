package com.huaxia.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutExample {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grid Bag Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define new buttons
		JButton jb1 = new JButton("Button 1");
		JButton jb2 = new JButton("Button 2");
		JButton jb3 = new JButton("Button 3");
		JButton jb4 = new JButton("Button 4");
		JButton jb5 = new JButton("Button 5");
		// Define the panel to hold the buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(jb1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(jb2, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		panel.add(jb3, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		jb4.setSize(30,160);
		panel.add(jb4, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(jb5, gbc);
		
		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
