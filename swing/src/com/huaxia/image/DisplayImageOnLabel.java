package com.huaxia.image;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayImageOnLabel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayImageOnLabel() {
		initFrame();
		init();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Display Image on Label");
		setSize(500, 400);
	}
	private void init() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("SUBJECT ");
		label.setIcon(new ImageIcon("C:\\Users\\12818\\workspace\\java\\huaxia\\redC.png"));
		JTextArea text = new JTextArea();
		text.setText("Add subject here...");
		panel.setLayout(new GridBagLayout());
		panel.add(label);
		panel.add(text);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(panel);
	}
	
	public static void main(String[] params) {
		DisplayImageOnLabel frame = new DisplayImageOnLabel();
		frame.setVisible(true);
		
	}
}
