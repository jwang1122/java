package com.huaxia.swing.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image cardImage;
	private int x = 10;
	private int y = 10;
	Toolkit t = Toolkit.getDefaultToolkit(); // get instance of Toolkit
	private boolean visible = false;

	MyPanel(String filename){
		URL iconUrl = this.getClass().getResource(filename);
		cardImage = t.getImage(iconUrl);		
	}
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void paint(Graphics g) { // javax.swing.JComponent
		if (visible) {
			int width = cardImage.getWidth(this);
			int height = cardImage.getHeight(this);
			g.drawImage(cardImage, x, y, width, height, this);
		}
	}
}
