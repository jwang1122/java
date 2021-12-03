package com.huaxia.swing;

/**

 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel5 extends JPanel {

	/**
	 * @see DisplayBufferedImage.java
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private int DELAY = 1000 / 30; // 30 pictures per second
	private int xDelta, yDelta;
	private int xPos, yPos;

	public MyPanel5() throws IOException {
		URL iconUrl = this.getClass().getResource("diamondK.gif");
		img = ImageIO.read(new File(iconUrl.getFile()));
		Random rnd = new Random();
//        do {
//            xDelta = rnd.nextInt(4);
//        } while (xDelta == 0);
//        do {
//            yDelta = rnd.nextInt(4);
//        } while (yDelta == 0);
		xDelta = rnd.nextInt(4) + 1;
		yDelta = rnd.nextInt(4) + 1;
		if (rnd.nextBoolean()) {
			xDelta *= -1;
		}
		if (rnd.nextBoolean()) {
			yDelta *= -1;
		}

		xPos = (getPreferredSize().width - img.getWidth()) / 2;
		yPos = (getPreferredSize().height - img.getHeight()) / 2;

		Timer timer = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xPos += xDelta;
				yPos += yDelta;
				if (xPos + img.getWidth() > getWidth()) {
					xPos = getWidth() - img.getWidth();
					xDelta *= -1;
				} else if (xPos < 0) {
					xPos = 0;
					xDelta *= -1;
				}
				if (yPos + img.getHeight() > getHeight()) {
					yPos = getHeight() - img.getHeight();
					yDelta *= -1;
				} else if (yPos < 0) {
					yPos = 0;
					yDelta *= -1;
				}

				repaint();
			}
		});
		timer.start();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.drawImage(img, xPos, yPos, this);
			g2d.dispose();
		}
	}

}