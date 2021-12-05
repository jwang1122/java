package com.huaxia.danceticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
			g.drawRoundRect(250, 10, 220, 70, 5, 5);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.setColor(Color.RED);
			g.drawString("Time: 7:30PM, 1/1/2022", 260, 35);
			g.drawString("Location: University Center", 260, 65);
			g.setColor(Color.BLACK);
			g.drawString("Sponsored by: Chinese Student Association.", 160, 430);
		}
	}

	public void setDisplayBackground(boolean displayBackground) {
		this.displayBackground = displayBackground;
	}
}
