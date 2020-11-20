package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayerBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static int boradLength = 9;
	static int terrainLength = 70;
	static int leftSpacing = 30;
	static int topSpacing = 10;
	boolean initialDrawing = true;
	Player player;
	Property[][] properties;

	PlayerBoardPanel(Player player) {
		this.player = player;
		properties = player.board.properties;
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int row = 0; row < boradLength; row++) {
			for (int column = 0; column < boradLength; column++) {
				g.setColor(Color.BLACK);
				g.drawRect(leftSpacing + terrainLength * row, topSpacing + terrainLength * column, terrainLength,
						terrainLength);
				properties[row][column].draw(g, player.castleImage);
			}
		}
	}

	public void setProperties(Property[][] properties) {
		this.properties = properties;
	}

}
