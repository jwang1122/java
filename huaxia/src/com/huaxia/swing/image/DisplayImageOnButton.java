package com.huaxia.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayImageOnButton extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String FOLDER = "/Users/12818/workspace/java/john/doc/";
	static final String RANGERS1 = "TexasRangers.png";
	Toolkit t = Toolkit.getDefaultToolkit();

	DisplayImageOnButton() {
		initFrame();
		init();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Display Image on Button");
		setSize(500, 400);
		getContentPane().setBackground(Color.getColor("#D2E7F9"));
		setLayout(new FlowLayout());
	}

	private void init() {
		ImageIcon img = new ImageIcon(t.getImage(FOLDER + RANGERS1));
		JButton btn = new JButton(img);
		add(btn);
		JLabel lbl = new JLabel("Try click the button");
		add(lbl);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("Hello, the world!");
			}
		});
	
	}
	
	public static void main(String[] args) {
		DisplayImageOnButton frame = new DisplayImageOnButton();
		frame.setVisible(true);
	}

}
