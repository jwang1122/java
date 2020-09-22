package com.huaxia.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image apple;
	private int apple_x = 100;
	private int apple_y = 100;

	public void paint(Graphics g) {

		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("resources/apple.png");
		apple = t.getImage(iconUrl);
		g.drawImage(apple, apple_x, apple_y, this);

	}
}
