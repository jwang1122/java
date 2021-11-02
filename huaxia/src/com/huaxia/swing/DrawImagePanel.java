package com.huaxia.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image apple;
	private int apple_x = 10;
	private int apple_y = 10;

	public void paint(Graphics g) {

		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("clubA.png");
		apple = t.getImage(iconUrl);
		int width = apple.getWidth(this);
		int height = apple.getHeight(this);
		float ratial = (float)height/width;
		g.drawImage(apple, apple_x, apple_y, 40, (int)(40*ratial), this);

	}
}
