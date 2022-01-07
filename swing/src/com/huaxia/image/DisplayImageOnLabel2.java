package com.huaxia.swing.image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayImageOnLabel2 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	ImageIcon icon = new ImageIcon("logo.jpeg");
	boolean flag = true;

	DisplayImageOnLabel2() {
		initFrame();
		init();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Display Image on Label");
		setSize(500, 500);
		getContentPane().setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		setResizable(false);
	}

	private void init() {
		JButton button = new JButton("Display");
		add(button, BorderLayout.NORTH);
		// Create an object

		// Associate ActionListener with button
		button.addActionListener(this);

	}

	public static void main(String[] args) {
		DisplayImageOnLabel2 frame = new DisplayImageOnLabel2();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (flag) {
			label = new JLabel(icon);
			add(label, BorderLayout.CENTER);
			pack();

		} else {
			remove(label);
			repaint();
		}
		flag = !flag;
	}
}
