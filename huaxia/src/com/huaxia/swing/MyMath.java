package com.huaxia.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyMath {

	public static void main(String[] args) {
		JFrame f = new JFrame("My First Window");// creating instance of JFrame
		JTextField t = new JTextField();
		t.setBounds(50, 50, 30, 30);
		f.add(t);

		JButton b = new JButton("click");// creating instance of JButton
		b.setBounds(130, 100, 100, 40);// x axis, y axis, width, height
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("The button clicked.");				
			}
		});
		String a = "123";
		f.add(b);// adding button in JFrame
		f.setSize(400, 500);// 400 width and 500 height
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // terminate app on close window
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}

}
