package com.huaxia.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPaneExample {
	JFrame f;

	OptionPaneExample() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
		int answer = JOptionPane.showConfirmDialog(f, "You are registered.");
		if (answer == JOptionPane.OK_OPTION) {
			System.out.println("You choose OK.");
		} else if (answer == JOptionPane.NO_OPTION) {
			System.out.println("You choose NO.");
		} else if (answer == JOptionPane.CANCEL_OPTION) {
			System.out.println("You choose CANCEL.");
		} else {
			System.out.println(answer);
		}
		JOptionPane.showMessageDialog(f, "Hello, Welcome to Huaxia Javat Level-I class.");
		JOptionPane.showMessageDialog(f, "Pay attention to the left icon.", "Alert", JOptionPane.WARNING_MESSAGE);
		String name = JOptionPane.showInputDialog(f, "Enter Name");
		System.out.println(name);
		int choice = JOptionPane.showOptionDialog(f, 
			      "You really want to quit?", 
			      "Quit?", 
			      JOptionPane.YES_NO_OPTION, 
			      JOptionPane.QUESTION_MESSAGE, 
			      null, null, null);	
		if(choice==JOptionPane.YES_OPTION) {
			System.out.println("Your choice: " + JOptionPane.YES_OPTION);
		}
	}
	public static void main(String[] args) {
		new OptionPaneExample();
	}
}