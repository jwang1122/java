package com.huaxia.kingdomino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog {
	private static final long serialVersionUID = 1L;
	private PassValue Value = new PassValue();
	private JLabel image;
	private JComboBox<String> numPlayers, gameModel;

	public Menu(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(816, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		setVisible(true);
	}

	public PassValue pass() {
		return Value;
	}

	private void initComponent() {
		image = new JLabel(new ImageIcon("Kingdomino.png"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(image);

		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.white);
		playerPanel.setPreferredSize(new Dimension(450, 100));
		playerPanel.setBorder(BorderFactory.createTitledBorder("Numbers of players"));
		numPlayers = new JComboBox<String>();
	//	numPlayers.addItem("1");
	//	numPlayers.addItem("2");
	//	numPlayers.addItem("3");
		numPlayers.addItem("4");
		playerPanel.add(numPlayers);

		JPanel modelPanel = new JPanel();
		modelPanel.setBackground(Color.white);
		modelPanel.setPreferredSize(new Dimension(450, 100));
		modelPanel.setBorder(BorderFactory.createTitledBorder("Game Mode"));
		gameModel = new JComboBox<String>();
		gameModel.addItem("Regular");
	//	gameModel.addItem("Dynastie");
	//	gameModel.addItem("Empire du milieu");
	//	gameModel.addItem("Harmonie");
	//	gameModel.addItem("Le Grand Duel");
		modelPanel.add(gameModel);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panIcon);
		content.add(playerPanel);
	//	content.add(modelPanel);

		JPanel control = new JPanel();
		JButton LaunchButton = new JButton("PLAY");

		LaunchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				if ((Integer.parseInt((String) numPlayers.getSelectedItem()) > 2)
						&& (String) gameModel.getSelectedItem() == "The Grand Duel") {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "This game mode is only available for 2 players! ", "Attention",
							JOptionPane.WARNING_MESSAGE);
				} else {*/
					Value = new PassValue(new String[] { (String) numPlayers.getSelectedItem(),
							(String) gameModel.getSelectedItem() });
					setVisible(false);
			//	}
				
			}

		});
		
		control.add(LaunchButton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}