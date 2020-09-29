package com.huaxia.john;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddTextField {
	static int count = 0;
	public static void main(String[] args) {
		JFrame f = new JFrame();// creating instance of JFrame

		JTextField t = new JTextField();
		t.setBounds(50, 50, 200, 30);
		f.add(t);

		JButton b = new JButton("click");// creating instance of JButton
		b.setBounds(50, 100, 100, 40);// x axis, y axis, width, height
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				t.setText("New text: " + count);			
			}
		});
		f.add(b);// adding button in JFrame

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
}
