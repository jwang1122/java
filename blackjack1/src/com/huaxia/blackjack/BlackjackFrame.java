package com.huaxia.blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackjackFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final Color bgColor = new Color(238, 231, 188);
	static final int frameWidth = 1080;
	static final int frameHeight = 720;
	static final Dimension frameSize = new Dimension(frameWidth, frameHeight);

	
	public BlackjackFrame() throws HeadlessException {
		super();
		setTitle("BlackJack");
		setSize(frameSize);
		setBackground(bgColor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
	}

	private void init() {
		JPanel mainPanel = new MyPanel();
		add(mainPanel);
	}

	public static void main(String[] args) {
		BlackjackFrame game = new BlackjackFrame();
		game.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
