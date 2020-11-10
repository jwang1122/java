package com.huaxia.kingdomino;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	static Image imageredC;
	static Image imageblueC;
	static Image imagegreenC;
	static Image imageyellowC;
	static {
		try {
			imageredC = ImageIO.read(new File("redC.png"));
			imageblueC = ImageIO.read(new File("blueC.png"));
			imagegreenC = ImageIO.read(new File("greenC.png"));
			imageyellowC = ImageIO.read(new File("yellowC.png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	JPanel statusPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	JTextField statusTxt = new JTextField("");
	ImageIcon icon;
	String playerName;
	
	public BoardPanel(String playerName, int color) {
		this.playerName = playerName;
		statusTxt.setText(playerName + "'s turn.");
		switch (color) {
		case 1:
			icon = new ImageIcon(imageredC);
			break;
		case 2:
			icon = new ImageIcon(imageblueC);
			break;
		case 3:
			icon = new ImageIcon(imagegreenC);
			break;
		case 4:
			icon = new ImageIcon(imageyellowC);
			break;
		}
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		statusPanel.setLayout(new FlowLayout());
		statusPanel.add(new JLabel("Status: "));
		statusPanel.add(statusTxt);
		add(statusPanel, BorderLayout.SOUTH);

		boardPanel.setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == 4 && j == 4) {
					boardPanel.add(new JButton(icon));
				} else {
					boardPanel.add(new JButton(i + "," + j));
				}
			}
		}
		add(boardPanel, BorderLayout.CENTER);
	}
}
