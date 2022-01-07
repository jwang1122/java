package com.huaxia.component;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame2(){
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JTextField t = new JTextField();
		t.setBounds(50, 50, 200, 30);
		add(t);

	}
	
	public static void main(String[] args) {
		Frame2 f2 = new Frame2();
		f2.setLayout(null);
		f2.setVisible(true);
	}

}
