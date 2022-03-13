package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final Color RED, GREEN, BLUE;
	static {
		RED = new Color(250, 175, 175);
		GREEN = new Color(175, 250, 175);
		BLUE = new Color(175, 175, 250);
	}
	MainFrame parent;
	private List<Player> playerList;
	private Hashtable<String, JLabel> nameHash = new Hashtable<>(); // seat as key, JLabel as value
	JLabel facedownLbl;

	BoardPanel(MainFrame parent, List<Player> playerList) {
		this.parent = parent;
		this.playerList = playerList;
		this.setLayout(null);
		this.setBackground(BLUE); // set default background
		setPlayerNames();
		String imageFileName = "resources/backR.gif";
		URL url = this.getClass().getClassLoader().getResource(imageFileName);
		ImageIcon image = new ImageIcon(url);
		facedownLbl = new JLabel(image);
		
		JButton switchBtn = new JButton("Switch Configure Panel");
		switchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.switchCard(); // Method Driving Development (MDD)
			}

		});

		add(switchBtn, BorderLayout.NORTH);

	}


	public void setPlayerNames() {
		for (Player player : playerList) {
			String name = player.getName();
			JLabel lbl = new JLabel(name);
			lbl.setLocation(player.getX()-50, player.getY());
			lbl.setSize(50, 30);
			add(lbl);
			nameHash.put(player.seat, lbl);
//			JLabel cardLbl = new JLabel(diamondK.getImage());
//			cardLbl.setLocation(player.getX(), player.getY());
//			cardLbl.setSize(Card.IMAGE_WIDTH, Card.IMAGE_HEIGHT);
//			add(cardLbl);
		}

	}


	public void addCard(Card card, Player player) {
		ImageIcon image = card.getImage();
		JLabel imageLbl = new JLabel(image);
		imageLbl.setLocation(player.getX(), player.getY());
		imageLbl.setSize(125, 170);
		add(imageLbl, 0);
		if(player.name.equals("Dealer") && player.hand.size()==2) { // cover second card
			facedownLbl.setLocation(player.getX(), player.getY());
			facedownLbl.setSize(125, 170);
			add(facedownLbl,0);
			parent.disableDealBtn();
			parent.enableHitBtn();
			parent.enablePassBtn();
		}
		repaint();
	}


	public void setPlayerName(String name, String seat) {
		JLabel nameLbl = nameHash.get(seat);
		nameLbl.setText(name);		
	}


	public void removeFacedownCard() {
		this.remove(facedownLbl);
		repaint();	
	}
}