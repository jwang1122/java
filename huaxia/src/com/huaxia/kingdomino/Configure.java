package com.huaxia.kingdomino;

import javax.swing.*;

import com.huaxia.kingdomino.Player.PlayerColor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configure extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel image;
	private JComboBox<String> numPlayers, gameModel;
	Kingdomino kingdomino;

	public Configure(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(816, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		setVisible(true);
	}

	public Kingdomino getKingdomino() {
		return kingdomino;
	}

	private void configKingdomino() {
		kingdomino = new Kingdomino();
		String name = JOptionPane.showInputDialog(null, "Blue Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player1 = new Player(PlayerColor.BluePlayer, name);
		name = JOptionPane.showInputDialog(null, "Green Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player2 = new Player(PlayerColor.GreenPlayer, name);
		name = JOptionPane.showInputDialog(null, "Yellow Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player3 = new Player(PlayerColor.YellowPlayer, name);
		name = JOptionPane.showInputDialog(null, "Blue Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player4 = new Player(PlayerColor.RedPlayer, name);
//		JOptionPane.showMessageDialog(null, "Start of the game :\n", "Start", JOptionPane.INFORMATION_MESSAGE);
	}
	private void defaultKingdomino() {
		kingdomino = new Kingdomino();
		kingdomino.player1 = new Player(PlayerColor.BluePlayer, null);
		kingdomino.player2 = new Player(PlayerColor.GreenPlayer, null);
		kingdomino.player3 = new Player(PlayerColor.YellowPlayer, null);
		kingdomino.player4 = new Player(PlayerColor.RedPlayer, null);
//		JOptionPane.showMessageDialog(null, "Start of the game :\n", "Start", JOptionPane.INFORMATION_MESSAGE);
	}

	private void initComponent() {
		image = new JLabel(new ImageIcon("Kingdomino.png"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(image);

		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(2, 1));
		playerPanel.setBackground(Color.white);
		playerPanel.setPreferredSize(new Dimension(450, 100));
		playerPanel.setBorder(BorderFactory.createTitledBorder("Numbers of players"));
		numPlayers = new JComboBox<String>();
		numPlayers.addItem("1");
		numPlayers.addItem("2");
		numPlayers.addItem("3");
		numPlayers.addItem("4");
//		playerPanel.add(numPlayers);
		JLabel msg1 = new JLabel("There will be total 4 players in this game.");
		msg1.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		playerPanel.add(msg1);
		JLabel msg2 = new JLabel("Plase enter their name.");
		msg2.setFont(new Font(msg2.getName(), Font.BOLD, 20));
		playerPanel.add(msg2);

		JPanel modelPanel = new JPanel();
		modelPanel.setBackground(Color.white);
		modelPanel.setPreferredSize(new Dimension(450, 100));
		modelPanel.setBorder(BorderFactory.createTitledBorder("Game Mode"));
		gameModel = new JComboBox<String>();
		gameModel.addItem("Regular");
		gameModel.addItem("Dynastie");
		gameModel.addItem("Empire du milieu");
		gameModel.addItem("Harmonie");
		gameModel.addItem("Le Grand Duel");
		modelPanel.add(gameModel);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panIcon);
		content.add(playerPanel);
//		content.add(modelPanel);

		JPanel control = new JPanel();
		JButton configBtn = new JButton("Config");
		configBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configKingdomino();
				setVisible(false);
			}		
		});
		control.add(configBtn);
		JButton LaunchButton = new JButton("PLAY");

		LaunchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defaultKingdomino();
				setVisible(false);
			}

			
		});

		control.add(LaunchButton);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}