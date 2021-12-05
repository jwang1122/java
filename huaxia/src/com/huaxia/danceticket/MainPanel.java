package com.huaxia.danceticket;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String imageFile = "dance.jpg";
	private Image img;
	private int x, y;
	private boolean displayBackground = true;

	public MainPanel() {
		URL imgUrl = this.getClass().getResource(imageFile);
		try {
			img = ImageIO.read(new File(imgUrl.getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout());
	}

	@Override
	public void paint(Graphics g) { // javax.swing.JComponent
		if (displayBackground) {
			int width = img.getWidth(this);
			int height = img.getHeight(this);
			g.drawImage(img, x, y, width, height, this);
			g.drawRoundRect(300, 10, 160, 70, 5, 5);
			g.drawString("Time: 7:30PM, 1/1/2022", 310, 35);
			g.drawString("Location: University Center", 310, 65);
			g.drawString("Sponsored by: Chinese Student Association.", 220, 430);
		}
	}

	public void setDisplayBackground(boolean displayBackground) {
		this.displayBackground = displayBackground;
	}
}
