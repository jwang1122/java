package com.huaxia.john;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.JPanel;
//import javax.swing.Timer;

public class MyPanel2 extends JPanel {// implements ActionListener {
	private static final long serialVersionUID = 1L;
//	private final int DELAY = 40;
	private final int DOT_SIZE = 10;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private Image apple;
	private int apple_x = 100;
	private int apple_y = 100;
//	private Timer timer;

	public MyPanel2() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		loadImage();
//		timer = new Timer(DELAY, this);
//		timer.start();
	}

	public void paint(Graphics g) {

		g.drawImage(apple, apple_x, apple_y, this);

	}

	private void loadImage() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("resources/apple.png");
		apple = t.getImage(iconUrl);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		move();
//		repaint();
//	}

	private void move() {
		if (leftDirection) {
			apple_x -= DOT_SIZE;
		}

		if (rightDirection) {
			apple_x += DOT_SIZE;
		}

		if (upDirection) {
			apple_y -= DOT_SIZE;
		}

		if (downDirection) {
			apple_y += DOT_SIZE;
		}

	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			leftDirection = false;
			rightDirection = false;
			upDirection = false;
			downDirection = false;
			switch (key) {
			case KeyEvent.VK_LEFT:
				leftDirection = true;
				break;
			case KeyEvent.VK_RIGHT:
				rightDirection = true;
				break;
			case KeyEvent.VK_UP:
				upDirection = true;
				break;
			case KeyEvent.VK_DOWN:
				downDirection = true;
				break;
			}
			move();
			repaint();
		}
	}
}
