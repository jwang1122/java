package com.huaxia.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Strange enough, t
 * @author John
 *
 */
public class DisplayImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyPanel p = new MyPanel("diamondK.gif");
	boolean flag = true;

	public DisplayImage() {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Click");
		btn.setPreferredSize(new Dimension(100, 30));
		MyAction1 action = new MyAction1(p, this);
		btn.addActionListener(action);
		setLayout(new BorderLayout());
		JPanel controlPnl = new JPanel();
		controlPnl.add(btn);

		add(p);
		add(controlPnl, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		DisplayImage di = new DisplayImage();
		di.setVisible(true);

	}

}

class MyAction1 implements ActionListener {

	MyPanel panel;
	DisplayImage frame;

	MyAction1(MyPanel panel, DisplayImage frame) {
		this.panel = panel;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.p.setVisible(frame.flag);
		frame.repaint();
		frame.flag = !frame.flag;
	}

}
