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
		EMPTY, FOREST, FIELD, MINE, SWAMP, MOUNTAIN, WATER, CASTLE
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
	static public Terrain emptyTerrain = new Terrain(TerrainImage.EMPTY, 0);

	TerrainImage image;
	int numberOfCrowns;

	Terrain(TerrainImage image, int numberOfCrowns) {
		this.image = image;
		this.numberOfCrowns = numberOfCrowns;
	}

	public void draw(Graphics g, Position position, Image castleImage) {
		g.setColor(Color.BLACK);
		g.drawRect(400 + lengthCase * position.row, 30 + lengthCase * position.column, lengthCase, lengthCase);
		if(image==TerrainImage.CASTLE) {
			g.drawImage(castleImage, 400 + lengthCase * position.column, 30 + lengthCase * position.row, lengthCase, lengthCase, null);
			return;
		}
		g.drawImage(getImage(image), 400 + lengthCase * position.column, 30 + lengthCase * position.row, lengthCase, lengthCase, null);
		drawCrown(g, position);
	}
	
	private void drawCrown(Graphics g, Position position) {
		if (numberOfCrowns > 0) {
			Font font = new Font("Calibri", Font.PLAIN, 20);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(numberOfCrowns), 405 + lengthCase * position.column, 50 + lengthCase * position.row);
		}		
	}
	
	public static Image getImage(TerrainImage terrain) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + numberOfCrowns;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terrain other = (Terrain) obj;
		if (image != other.image)
			return false;
		if (numberOfCrowns != other.numberOfCrowns)
			return false;
		return true;
	}
	
}
