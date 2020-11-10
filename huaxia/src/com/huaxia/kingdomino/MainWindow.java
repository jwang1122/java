package com.huaxia.kingdomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	static Image imageF;
	static Image imageL;
	static Image imageM;
	static Image imageP;
	static Image imageQ;
	static Image imageW;
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
	JPanel selectPanel = new JPanel();
	JTabbedPane tp;
	JButton actionBtn = new JButton("Next Player");
	Deck deck = new Deck();

	public MainWindow() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());

		buildSelectPanel();
		add(selectPanel, BorderLayout.WEST);

		buildTabbedPanes();
		add(tp, BorderLayout.CENTER);
	}

	private void buildSelectPanel() {
		selectPanel.setLayout(new BorderLayout());
		ArrayList<Tile> tileList = deck.getTileList4Selection();
		JPanel centerPanel = new JPanel();
//		JPanel centerPanel = new JPanel() {
//			@Override
//			public void paintComponent(Graphics g) {
//				displayDomino(g,tileList); // draw tile list
//			}			
//		};
		centerPanel.setLayout(new GridLayout(4, 2));
		for (int i = 0; i < 4; i++) {
			char imageName = tileList.get(i).tile1;
			ImageIcon icon = getImageIcon(imageName);
			JButton jb1 = new JButton(icon);
			centerPanel.add(jb1);
			imageName = tileList.get(i).tile2;
			icon = getImageIcon(imageName);
			JButton jb2 = new JButton(icon);
			jb2.setAlignmentX(0);
			centerPanel.add(jb2);
		}
		selectPanel.add(centerPanel, BorderLayout.CENTER);
		selectPanel.add(actionBtn, BorderLayout.SOUTH);
	}

	private ImageIcon getImageIcon(char imageName) {
		switch (imageName) {
		case 'P':
			return new ImageIcon(imageP);
		case 'F':
			return new ImageIcon(imageF);
		case 'W':
			return new ImageIcon(imageW);
		case 'M':
			return new ImageIcon(imageM);
		case 'Q':
			return new ImageIcon(imageQ);
		case 'L':
			return new ImageIcon(imageL);
		}
		return null;
	}

	private void buildTabbedPanes() {
		tp = new JTabbedPane();
		tp.add("Player 1", new BoardPanel("Player 1", 1));
		tp.add("Player 2", new BoardPanel("Player 2", 2));
		tp.add("Player 3", new BoardPanel("Player 3", 3));
		tp.add("Player 4", new BoardPanel("Player 4", 4));

	}

	public static void displayDomino(Graphics g, ArrayList<Tile> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 2; j++) {
				char terrain;
				int numCrowns;
				ImageObserver obs = null;
				if (j == 0) {
					terrain = list.get(i).getTile1();
					numCrowns = list.get(i).getCrown1();
				} else {
					terrain = list.get(i).getTile2();
					numCrowns = list.get(i).getCrown2();
				}
				if (terrain == '#') {
					g.setColor(new Color(188, 181, 138));
					g.fillRect(100 + j * 70, 100 + i * 140, 70, 70);
				} else if (terrain == 'Q') {
					g.drawImage(imageQ, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'L') {
					g.drawImage(imageL, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'W') {
					g.drawImage(imageW, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'P') {
					g.drawImage(imageP, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'M') {
					g.drawImage(imageM, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'F') {
					g.drawImage(imageF, 100 + j * 70, 100 + i * 140, obs);
				}
				if (numCrowns > 0) {
					Font font = new Font("Calibri", Font.PLAIN, 20);
					g.setFont(font);
					g.setColor(Color.WHITE);
					g.drawString(String.valueOf(numCrowns), 105 + j * 70, 120 + i * 140);
				}
			}
		}
	}

}
