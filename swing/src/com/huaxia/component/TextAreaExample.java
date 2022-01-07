package com.huaxia.component;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaExample {
	TextAreaExample() {
		JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea area = new JTextArea("Welcome to Huaxia Java class.");
		area.setBounds(10, 30, 200, 200);
		f.add(area);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new TextAreaExample();
	}
}
