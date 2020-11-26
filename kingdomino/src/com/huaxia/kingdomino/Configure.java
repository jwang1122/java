package com.huaxia.kingdomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.huaxia.kingdomino.Player.PlayerColor;

public class Configure extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel image;
	Kingdomino kingdomino;

	public Configure(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(600, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		this.setBackground(Color.CYAN);
		this.setVisible(true);
	}

	public Kingdomino getKingdomino() {
		return kingdomino;
	}

	private void configKingdomino() {
		kingdomino = new Kingdomino();
		String name = JOptionPane.showInputDialog(null, "Blue Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player1 = new Player(PlayerColor.BluePlayer);
		kingdomino.player1.setName(name);
		name = JOptionPane.showInputDialog(null, "Green Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player2 = new Player(PlayerColor.GreenPlayer);
		kingdomino.player2.setName(name);
		name = JOptionPane.showInputDialog(null, "Yellow Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player3 = new Player(PlayerColor.YellowPlayer);
		kingdomino.player3.setName(name);
		name = JOptionPane.showInputDialog(null, "Red Player's name", "Players", JOptionPane.QUESTION_MESSAGE);
		kingdomino.player4 = new Player(PlayerColor.RedPlayer);
		kingdomino.player4.setName(name);
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
		try {
			InputStream is = Configure.class.getResourceAsStream("kingdomino.jpg");
			image = new JLabel(new ImageIcon(ImageIO.read(is)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.yellow);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(image);

		JPanel welcomePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

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