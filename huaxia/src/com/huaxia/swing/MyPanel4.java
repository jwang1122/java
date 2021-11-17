package com.huaxia.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel4 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final int BOUNCE_WIDTH = DisplayBouncedImage.WIDTH-20;
	private final int BOUNCE_HEIGHT = DisplayBouncedImage.HEIGHT-43;
	private final int DELAY = 50;
	private final int MOVE_SIZE = 5;
	private int imgWidth = 10;
	private int imgHeight = 10;
	private Image apple;
	private int appleX = 100;
	private int appleY = 300;
	private boolean xDir = true;
	private boolean yDir = true;
	private Timer timer;

	public MyPanel4() {
//		this.setPreferredSize(new Dimension(200, 400));
		loadImage();
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, BOUNCE_WIDTH, BOUNCE_HEIGHT);
		g.drawImage(apple, appleX, appleY, this);

	}

	private void loadImage() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("resources/apple.png");
		apple = t.getImage(iconUrl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bounce();
		repaint();
	}

	private void bounce() {
		if (xDir) {
			appleX+=MOVE_SIZE;
		} else {
			appleX-=MOVE_SIZE;
		}
		if (yDir) {
			appleY+=MOVE_SIZE;
		} else {
			appleY-=MOVE_SIZE;
		}

		if (appleX > (BOUNCE_WIDTH - imgWidth)) {
			appleX -= MOVE_SIZE;
			xDir = false;
		}
		if (appleX < 0) {
			appleX+=MOVE_SIZE;
			xDir = true;
		}
		if (appleY > (BOUNCE_HEIGHT - imgHeight)) {
			appleY -= MOVE_SIZE;
			yDir = false;
		}
		if (appleY < 0) {
			appleY+=MOVE_SIZE;
			yDir = true;
		}
	}
}