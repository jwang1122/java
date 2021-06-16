package com.huaxia.swing;

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample1 implements ItemListener{
	JFrame f;
	final JLabel label = new JLabel();
	final JComboBox<String> cb;
	
	ComboBoxExample1() {
		f = new JFrame("ComboBox Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setSize(400, 100);
		label.setBounds(10,10,400,100);
		JButton b = new JButton("Show");
		b.setBounds(120, 100, 75, 20);
		String languages[] = { "Python","C", "C++", "C#", "Java", "PHP", "JavaScript" };
		cb = new JComboBox<>(languages);
		cb.addItemListener(this);
		cb.setBounds(10, 100, 90, 20);
		f.add(cb);
		f.add(label);
		f.add(b);
		f.setLayout(null);
		f.setSize(350, 350);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Button Clicked: Programming language Selected: " + cb.getSelectedItem();//cb.getItemAt(cb.getSelectedIndex());
				label.setText(data);
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String data = "Programming language Selected: " + cb.getSelectedItem();//cb.getItemAt(cb.getSelectedIndex());
		label.setText(data);
	}

	public static void main(String[] args) {
		new ComboBoxExample1();
	}
}