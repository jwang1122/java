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
	
	PlayerBoardPanel(Player player) {
		this.player = player;
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
//		if (initialDrawing) {
			for (int i = 0; i < boradLength; i++) {
				for (int j = 0; j < boradLength; j++) {
					g.setColor(Color.BLACK);
					g.drawRect(leftSpacing + terrainLength * i, topSpacing + terrainLength * j, terrainLength, terrainLength);
					if(j==4 && i==4) {
						g.drawImage(player.castleImage, leftSpacing + terrainLength * i, topSpacing + terrainLength * j, terrainLength, terrainLength, null);
					}
				}
			}
//			initialDrawing = false;
//		}

	}

}
