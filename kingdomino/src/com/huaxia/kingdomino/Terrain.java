package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;

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
			InputStream is = Terrain.class.getResourceAsStream("Forest.jpg");
			imageF = ImageIO.read(is);
			is = Terrain.class.getResourceAsStream("Field.jpg");
			imageL = ImageIO.read(is);
			is = Terrain.class.getResourceAsStream("Mine.jpg");
			imageM = ImageIO.read(is);
			is = Terrain.class.getResourceAsStream("Swamp.jpg");
			imageP = ImageIO.read(is);
			is = Terrain.class.getResourceAsStream("Mountain.jpg");
			imageQ = ImageIO.read(is);
			is = Terrain.class.getResourceAsStream("Water.jpg");
			imageW = ImageIO.read(is);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	static public Terrain emptyTerrain = new Terrain(TerrainImage.EMPTY, 0);
	static int boradLength = 9;
	static int terrainWidth = 70;
	static int leftSpacing = 30;
	static int topSpacing = 10;

	TerrainImage image;
	int numberOfCrowns;

	Terrain(TerrainImage image, int numberOfCrowns) {
		this.image = image;
		this.numberOfCrowns = numberOfCrowns;
	}

	public void draw(Graphics g, Position position, Image castleImage) {
		if(image==TerrainImage.CASTLE) {
			g.drawImage(castleImage, leftSpacing + terrainWidth * position.column, topSpacing + terrainWidth * position.row, terrainWidth, terrainWidth, null);
			return;
		}
		g.drawImage(getImage(image), leftSpacing + terrainWidth * position.column, topSpacing + terrainWidth * position.row,
				terrainWidth, terrainWidth, null);
		drawCrown(g, position);
	}
	
	private void drawCrown(Graphics g, Position position) {
		if (numberOfCrowns > 0) {
			Font font = new Font("Calibri", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString(String.valueOf(numberOfCrowns), leftSpacing+5 + terrainWidth * position.column, 30 + lengthCase * position.row);
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
