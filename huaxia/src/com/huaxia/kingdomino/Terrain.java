package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Terrain {
	enum TerrainImage {
		EMPTY, FOREST, FIELD, MINE, SWAMP, MOUNTAIN, WATER
	}
	static final int lengthCase = 70;
	static Color fond = new Color(238, 231, 188);
	static Image imageF, imageL, imageM, imageP, imageQ, imageW; // tile images
	static {
		try {
			imageF = ImageIO.read(new File("Forest.jpg"));
			imageL = ImageIO.read(new File("Field.jpg"));
			imageM = ImageIO.read(new File("Mine.jpg"));
			imageP = ImageIO.read(new File("Swamp.jpg"));
			imageQ = ImageIO.read(new File("Mountain.jpg"));
			imageW = ImageIO.read(new File("Water.jpg"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	TerrainImage image;
	int numberOfCrowns;

	Terrain(TerrainImage image, int numberOfCrowns) {
		this.image = image;
		this.numberOfCrowns = numberOfCrowns;
	}

	/**
	 * draw itself on give position (row, column) in the Board.
	 * 
	 * @param g
	 * @param row
	 * @param column
	 */
	public void draw(Graphics g, int row, int column) {
		if (image==TerrainImage.EMPTY) {
			g.setColor(fond);
			g.fillRect(400 + lengthCase * row, 30 + lengthCase * column, lengthCase, lengthCase);
			return;			
		}
		g.drawImage(getImage(image), 400 + lengthCase * row, 30 + lengthCase * column, lengthCase, lengthCase, null);
		drawCrown(g, row, column);
	}
	
	private void drawCrown(Graphics g, int row, int column) {
		if (numberOfCrowns > 0) {
			Font font = new Font("Calibri", Font.PLAIN, 20);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(numberOfCrowns), 405 + lengthCase * row, 50 + lengthCase * column);
		}		
	}
	
	private Image getImage(TerrainImage terrain) {
		switch (terrain) {
		case FOREST:
			return imageF;
		case FIELD:
			return imageL;
		case MINE:
			return imageM;
		case SWAMP:
			return imageP;
		case MOUNTAIN:
			return imageQ;
		case WATER:
			return imageW;
		default:
			return null;
		}
	}
}
