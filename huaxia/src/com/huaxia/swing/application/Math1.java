package com.huaxia.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Math1 extends JFrame {

	private static final long serialVersionUID = 1L;
	public Math1(String title) {
		super(title);
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLayout(null);
		setLocationRelativeTo(null);
		
		JTextField t1 = new JTextField();
		t1.setBounds(10, 50, 30, 30);
		add(t1);
		JLabel plus = new JLabel(" + ");
		plus.setBounds(50, 50, 30, 30);
		add(plus);
		JTextField t2 = new JTextField();
		t2.setBounds(80, 50, 30, 30);
		add(t2);
		JTextField result = new JTextField();
		result.setBounds(180, 50, 30, 30);
		add(result);
		JButton b = new JButton(" = ");// creating instance of JButton
		b.setBounds(120, 50, 50, 30);// x axis, y axis, width, height
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(t1.getText());
				int y = Integer.parseInt(t2.getText());
				int z = x + y;
				result.setText(""+ z);				
			}
		});
		add(b);// adding button in JFrame
		
		setVisible(true);
	}
	public static void main(String[] args) {
		Math1 m = new Math1("Simple Math");
		m.setVisible(true);
	}

}
