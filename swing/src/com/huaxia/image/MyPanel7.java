package com.huaxia.image;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel7 extends JPanel {
	MyPanel7(){
		setLayout(null);
		JLabel lbl1 = new JLabel("label 1");
		JLabel lbl2 = new JLabel("label 2");
		JLabel lbl3 = new JLabel("label 3");
		JLabel lbl4 = new JLabel("label 4");
		JLabel lbl5 = new JLabel("label 5");

		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);

		lbl1.setLocation(27, 120);
		lbl2.setLocation(123, 320);
		lbl3.setLocation(273, 420);
		lbl4.setLocation(27, 123);
		lbl5.setLocation(153, 20);

		lbl1.setSize(86, 14);
		lbl2.setSize(140, 14);
		lbl3.setSize(80, 14);
		lbl4.setSize(80, 14);
		lbl5.setSize(130, 14);		
	}
}
