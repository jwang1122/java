package com.huaxia.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MyPanel6 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
//	private int DELAY = 1000 / 30; // 30 pictures per second
//	private int xDelta, yDelta;
	private int xPos = 100, yPos = 100;

	public MyPanel6() {
		img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = img.createGraphics();
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fillRect(0, 0, 20, 20);
		g2.setColor(Color.red);
		g2.fillOval(0, 0, 20, 20);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.drawImage(img, xPos, yPos, this);
		g2.dispose();
	}
	
	

}
