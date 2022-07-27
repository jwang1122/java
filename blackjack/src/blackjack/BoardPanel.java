package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final MyColor RED, GREEN, BLUE; // MyColor is a Color
	static {
		RED = new MyColor(250, 175, 175,"red");
		GREEN = new MyColor(175, 250, 175,"green");
		BLUE = new MyColor(175, 175, 250,"blue");
	}
	MainFrame parent;
	private List<Player> playerList;
	private Hashtable<String, JLabel> nameHash = new Hashtable<>(); // seat as key, JLabel as value
	private Hashtable<String, JLabel> resultHash = new Hashtable<>(); // player name as key, win count JLabel as value
	JLabel facedownLbl;
	ArrayList<JLabel> cardsLbl = new ArrayList<>(); // for clear all cards on screen

	BoardPanel(MainFrame parent, List<Player> playerList) {
		this.parent = parent;
		this.playerList = playerList;
		this.setLayout(null);
		this.setBackground(BLUE); // set deffault background
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
		add(buildResultPanel());
	}

	private JPanel buildResultPanel() {
		JPanel resultPnl = new JPanel();
		Border borderLine = BorderFactory.createTitledBorder("Game Result");
		resultPnl.setBorder(borderLine);
		resultPnl.setLayout(new GridLayout(4,2));
		resultPnl.setBackground(Color.yellow);
		for(Player player: playerList) {
			JLabel nameLbl = new JLabel(player.name);
			resultPnl.add(nameLbl);
			JLabel winLbl = new JLabel(""+player.win);
			resultHash.put(player.name, winLbl);
			resultPnl.add(winLbl);			
		}
		resultPnl.setLocation(750, 10);
		resultPnl.setSize(200,200);
		return resultPnl;
	}
	
	private void updateResult() {
		for(Player player: playerList) {
			JLabel label = resultHash.get(player.name);
			label.setText(""+player.win);
		}
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
		cardsLbl.add(imageLbl);
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


	public void displayResult() {
		updateResult();	
	}

	public void clearCards() {
		// TODO in order to clear all cards on the screen, we need remember all card labels.
		for(JLabel lbl:cardsLbl) {
			remove(lbl);
		}
		cardsLbl.clear();
		repaint();
	}
}