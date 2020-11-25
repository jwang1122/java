package com.huaxia.kingdomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DominoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static final int leftSpacing = 100;
	static final int terrainWidth = 70;
	static final int topSpacing = 100;
	static final int rowSpacing = 140;
	
	ArrayList<Domino> dominoList;
	JPanel listPanel;
	String status;
	JLabel statusLbl;
	
	DominoPanel(){
		setLayout(new BorderLayout());
		listPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				paintDominoList(g);
			}
		};
		listPanel.setBackground(Kingdomino.bgColor);
		add(listPanel, BorderLayout.CENTER);
		JPanel statusPanel = new JPanel();
		add(statusPanel, BorderLayout.SOUTH);
		statusLbl = new JLabel("Status:");
		statusLbl.setSize(100, 30);
		statusLbl.setAlignmentX(LEFT_ALIGNMENT);
		statusPanel.add(statusLbl);
	}

	private void paintDominoList(Graphics g) {
		if(dominoList!=null && dominoList.size()>0) {
			for (int row = 0; row < dominoList.size(); row++) {
				displayDominoNumber(g, dominoList, row);
				drawTerrain(g, dominoList.get(row).getTerrain1(), row, 0);
				drawTerrain(g, dominoList.get(row).getTerrain2(), row, 1);
			}
			
		}
		
	}
	private void drawTerrain(Graphics g, Terrain terrain, int row, int column) {
		g.drawImage(Terrain.getImage(terrain.image), leftSpacing + column * terrainWidth, topSpacing + row * rowSpacing, null);
		if (terrain.numberOfCrowns > 0) {
			g.setColor(Color.RED);
			g.drawString(String.valueOf(terrain.numberOfCrowns), leftSpacing+5 + column * terrainWidth, topSpacing+20 + row * rowSpacing);
		}
	}

	private void displayDominoNumber(Graphics g, ArrayList<Domino> list, int i) {
		Font font = new Font("Calibri", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.DARK_GRAY);
		int number = list.get(i).number;
		if (number != 0)
			g.drawString("" + number, 50, 145 + i * 135);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		statusLbl.setText(status);
	}

	public ArrayList<Domino> getDominoList() {
		return dominoList;
	}

	public void setDominoList(ArrayList<Domino> dominoList) {
		this.dominoList = dominoList;
	}

	public void showWinner(Player player) {
		this.remove(listPanel);
		JPanel resultPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				paintResult(g);
			}

			private void paintResult(Graphics g) {
				Font font = new Font("Calibri", Font.BOLD, 20);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("The Big Winner: ", 50, 50);
				g.setColor(Color.RED);
				g.drawString(player.name, 150, 70);
				g.drawImage(Player.goldMedal, 50, 100, null);
				g.setColor(Color.BLACK);
				g.drawString("Score: " + player.score, 50, 470);
				g.drawString("Max Linked Fields: " + player.maxField, 50, 490);
				g.drawString("Crowns: " + player.crowns, 50, 510);
			}
			
		};
		add(resultPanel);
		repaint();
		
	}
	
	public void showScore(Player player) {
		remove(listPanel);
		JPanel resultPanel = new JPanel(); 
		resultPanel.setLayout(new BorderLayout());
		JTextArea scoreTxt = new JTextArea();
		scoreTxt.setText(String.format("Player %s\n\nScore: %d\nMax Linked Field: %d\nCrowns: %d", player.getName(), player.score, player.maxField, player.crowns));
		resultPanel.add(scoreTxt, BorderLayout.CENTER);
		add(resultPanel);
		repaint();
	}
	
}
