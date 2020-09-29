package com.huaxia.john;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddButton {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("My First Window");// creating instance of JFrame

		JButton b = new JButton("click");// creating instance of JButton
		b.setBounds(130, 100, 100, 30);// x axis, y axis, width, height
//		b.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("The button clicked.");				
//			}
//		});
		f.add(b);// adding button in JFrame
		
		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}
}