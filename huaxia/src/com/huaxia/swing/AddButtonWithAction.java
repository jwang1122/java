package com.huaxia.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddButtonWithAction extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public AddButtonWithAction(String title) {
		super(title);
		JButton b = new JButton("click");// creating instance of JButton
		b.setBounds(130, 100, 100, 40);// x axis, y axis, width, height
		b.addActionListener(this);
		add(b);// adding button in JFrame
		
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("The button clicked.");				
	}
	
	public static void main(String[] args) {
		AddButtonWithAction f = new AddButtonWithAction("My First Window");// creating instance of JFrame

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
}