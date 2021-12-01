package com.rodney.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends AbstractFrame implements ActionListener{
	private JTextField t1;
	private JTextField t2;
	private JLabel lbl1;

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setVisible(true);
	}

	@Override
	protected void init() {
		t1 = new JTextField();
		t1.setBounds(10,10,50,30);
		add(t1);
		JLabel lbl = new JLabel("+");
		add(lbl);
		lbl.setBounds(70,10,20,30);
		t2 = new JTextField();
		t2.setBounds(90,10,50,30);
		add(t2);
		JButton button = new JButton("=");
		button.setBounds(145,10,45,30);
		add(button);
		button.addActionListener(this);
		lbl1 = new JLabel(" ");
		add(lbl1);
		lbl1.setBounds(190,10,50,30);

		setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double x = Double.parseDouble(t1.getText());
		double y = Double.parseDouble(t2.getText());
		double z = x+y;
		lbl1.setText(z+"");
	}

}
