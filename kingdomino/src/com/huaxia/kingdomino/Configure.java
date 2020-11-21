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
		kingdomino.player1 = new Player(PlayerColor.BluePlayer);
		if (name != null && name.length() > 0)
			kingdomino.player1.setName(name);
		name = JOptionPane.showInputDialog(null, "Green Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player2 = new Player(PlayerColor.GreenPlayer);
		if (name != null && name.length() > 0)
			kingdomino.player2.setName(name);
		name = JOptionPane.showInputDialog(null, "Yellow Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player3 = new Player(PlayerColor.YellowPlayer);
		if (name != null && name.length() > 0)
			kingdomino.player3.setName(name);
		name = JOptionPane.showInputDialog(null, "Red Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player4 = new Player(PlayerColor.RedPlayer);
		if (name != null && name.length() > 0)
			kingdomino.player4.setName(name);
//		JOptionPane.showMessageDialog(null, "Start of the game :\n", "Start", JOptionPane.INFORMATION_MESSAGE);
	}

	private void defaultKingdomino() {
		kingdomino = new Kingdomino();
		kingdomino.player1 = new Player(PlayerColor.BluePlayer);
		kingdomino.player2 = new Player(PlayerColor.GreenPlayer);
		kingdomino.player3 = new Player(PlayerColor.YellowPlayer);
		kingdomino.player4 = new Player(PlayerColor.RedPlayer);
//		JOptionPane.showMessageDialog(null, "Start of the game :\n", "Start", JOptionPane.INFORMATION_MESSAGE);
	}

	private void initComponent() {
		image = new JLabel(new ImageIcon("Kingdomino.png"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(image);

		JPanel welcomePanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Font font = new Font("Calibri", Font.BOLD, 30);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString("WELCOME TO KINGDOMINO!", 50, 80);

			}

		};
		welcomePanel.setPreferredSize(new Dimension(450, 100));
		welcomePanel.repaint();
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panIcon);
		content.add(welcomePanel);

		JPanel control = new JPanel();
		JButton configBtn = new JButton("Set Player Names");
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