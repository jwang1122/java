package com.huaxia.swing;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame2(){
		setSize(400, 500);
		
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
