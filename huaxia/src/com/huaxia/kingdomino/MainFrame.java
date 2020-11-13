package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;

	static Image imageF, imageL, imageM, imageP, imageQ, imageW; // tile images
	static Image imageredC, imageblueC, imagegreenC, imageyellowC;// castle images
	static Color fond = new Color(238, 231, 188);
	static {
		try {
			imageF = ImageIO.read(new File("Forest.jpg"));
			imageL = ImageIO.read(new File("Field.jpg"));
			imageM = ImageIO.read(new File("Mine.jpg"));
			imageP = ImageIO.read(new File("Swamp.jpg"));
			imageQ = ImageIO.read(new File("Mountain.jpg"));
			imageW = ImageIO.read(new File("Water.jpg"));
			imageredC = ImageIO.read(new File("redC.png"));
			imageblueC = ImageIO.read(new File("blueC.png"));
			imagegreenC = ImageIO.read(new File("greenC.png"));
			imageyellowC = ImageIO.read(new File("yellowC.png"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	ArrayList<Tile> tileList;
	int lengthBoard = Kingdomino.lengthBoard;
	int lengthCase = Kingdomino.lengthCase;
	Kingdomino kingdomino;
	
	@SuppressWarnings("unchecked")
	public MainFrame(Kingdomino kingdomino, ArrayList<Tile> tileList){
		this.kingdomino = kingdomino;
		Collections.sort(tileList);
		this.tileList = tileList;
	}
	
	public void displayFrame(Player player) {
		setTitle(player.getName());
		setSize(1080, 720);
		JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				DeckTray(g, player); // draw all images in the board
				displayDomino(g, tileList); // draw tile list
			}

		};
		setBackground(fond);
		add(p);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void DeckTray(Graphics g, Player player) {
		for (int i = 0; i < lengthBoard; i++) {
			for (int j = 0; j < lengthBoard; j++) {
				drawTerrian(g, player, i, j);
				drawCrown(g, player, i, j);
			}
		}
	}

	private void drawCrown(Graphics g, Player player, int i, int j) {
		int numCrowns = player.getBoard().properties[j][i].getCrown();
		g.setColor(Color.BLACK);
		g.drawRect(400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase);
		if (numCrowns > 0) {
			Font font = new Font("Calibri", Font.PLAIN, 20);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(numCrowns), 405 + lengthCase * i, 50 + lengthCase * j);
		}
	}

	private void drawTerrian(Graphics g, Player player, int i, int j) {
		char terrain = player.getBoard().properties[j][i].getTerrain();
		if (terrain == 'C') {
			g.drawImage(player.getCastleImage(), 400 + lengthCase * i, 30 + lengthCase
					* j, lengthCase, lengthCase, null);
			return;
		}
		if (terrain == '#') {
			g.setColor(fond);
			g.fillRect(400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase);
			return;
		}
		g.drawImage(getImage(terrain), 400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase, null);
	}

	private Image getImage(char value) {
		switch (value) {
		case 'P':
			return imageP;
		case 'Q':
			return imageQ;
		case 'F':
			return imageF;
		case 'L':
			return imageL;
		case 'W':
			return imageW;
		case 'M':
			return imageM;
		}
		return null;
	}
	
	private void displayDomino(Graphics g, ArrayList<Tile> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 2; j++) {
				char terrain;
				int numCrowns;
				ImageObserver obs = null;
				if (j == 0) {
					terrain = list.get(i).getTerrain1();
					numCrowns = list.get(i).getCrown1();
				} else {
					terrain = list.get(i).getTerrain2();
					numCrowns = list.get(i).getCrown2();
				}
				if (terrain == '#') {
					g.setColor(new Color(188, 181, 138));
					g.fillRect(100 + j * 70, 100 + i * 140, 70, 70);
				} else {
					g.drawImage(getImage(terrain), 100 + j * 70, 100 + i * 140, obs);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouse at (" + x + ", " + y + ")");
		if (x >= 100 && x <= 240) {
			for (int i = 0; i < tileList.size(); i++) {
				if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
					kingdomino.chooseTile = i + 1;
				}
			}
		}
		if (kingdomino.chooseTile != 0) {
			for (int i = 0; i < lengthBoard; i++) {
				for (int j = 0; j < lengthBoard; j++) {
					if (x >= 400 + lengthCase * j && x <= 400 + lengthCase * (j + 1)) {
						if (y >= 60 + lengthCase * i && y <= 60 + lengthCase * (i + 1)) {
							if (!kingdomino.case1Selected) {
								kingdomino.x1 = i;
								kingdomino.y1 = j;
								kingdomino.case1Selected = true;
							} else if (!kingdomino.case2Selected) {
								kingdomino.x2 = i;
								kingdomino.y2 = j;
								kingdomino.case2Selected = true;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
