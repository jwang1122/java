package com.huaxia.kingdomino;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	BoardPanel(ArrayList<Player> players) {
//		setSize(780, 720);
		JTabbedPane tabbedPane = new JTabbedPane();
		for (int i = 0; i < players.size(); i++) {
			PlayerBoardPanel playerBoard = new PlayerBoardPanel(players.get(i));
			tabbedPane.add(players.get(i).getName(), playerBoard);
		}
		tabbedPane.setBounds(320, 50, 750,700);
		add(tabbedPane);
	}
}
