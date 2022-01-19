package blackjack;

import java.awt.Color;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static Color blue, yellow, green;
	static { 
		blue = new Color(114, 183, 244);
		yellow = new Color(244, 215, 114);
		green = new Color(183, 243, 79);		
	}
	
	private Color bkColor; //background color
	private List<JLabel> cardList = new ArrayList<>(); // for removing all cards from the Panel
	private List<JLabel> playerNameLabelList = new ArrayList<>(); // for resigning player name label
	private List<JLabel> resultNameLabelList = new ArrayList<>();
	private List<JLabel> resultValueLabelList = new ArrayList<>();
	private List<Player> playerList;
	private ImageIcon faceDownImg;
	private JLabel faceDownLbl;
	private MainFrame parent;
	
	/**
	 * Constructor of player board panel
	 * @param parent
	 */
	public PlayBoardPanel(MainFrame parent) {
		this.parent = parent;
		bkColor = green; // default green background
		this.setBackground(bkColor); 
		setLayout(null);
		URL url = getClass().getClassLoader().getResource("resources/backR.gif");
		faceDownImg = new ImageIcon(url);
		setGameResultPanel(parent.getPlayerList());
	}
	
	/**
	 * add card to panel, not to hand
	 * @param card
	 * @param player
	 */
	public void addCard(Card card, Player player) {
		if(player.isDealer() && player.getHandSize()==2) {
			faceDownLbl = new JLabel(faceDownImg); // cover the second card with face down card
			faceDownLbl.setLocation(player.getCardX()+30, player.getCardY());
			faceDownLbl.setSize(Card.CARD_WIDTH, Card.CARD_HEIGHT);
			add(faceDownLbl);
			parent.setEnabledHitBtn(true);
		}
		JLabel label = new JLabel(card.getCardImage());
		label.setLocation(player.getCardX(), player.getCardY());
		label.setSize(Card.CARD_WIDTH, Card.CARD_HEIGHT);
//		add(label);
		cardList.add(label);
		player.lblList.add(label);
		for (JLabel lbl: player.lblList) {
			this.remove(lbl);
		}
		for (int i = player.lblList.size()-1; i>=0; i--) {
			int currentXPosition = player.getCardX()+i*30;
			JLabel label1 = player.lblList.get(i);
			label1.setLocation(currentXPosition, player.getCardY());
			label1.setSize(Card.CARD_WIDTH, Card.CARD_HEIGHT);
			add(label1);
		}
		repaint(); // repaint the whole panel 
	}

	/**
	 * Clears the play board and clears all the card in player's hand
	 */
	public void clearBoard() {
		for(JLabel card: cardList) {
			remove(card);
		}
		remove(faceDownLbl); // second card of dealer is covered by a face down card, so need to be removed
		for(Player player: playerList) {
			player.cleanHand();
		}
	}
	
	/**
	 * sets player's name on the play board
	 * @param playerList
	 */
	public void setPlayerName(List<Player> playerList) {
		for (int i=0; i<playerList.size(); i++) {
			Player player = playerList.get(i);
			JLabel nameLbl = new JLabel(player.getName());
			nameLbl.setLocation(player.getCardX()-60, player.getCardY());
			nameLbl.setSize(70, 30);
			add(nameLbl);
			playerNameLabelList.add(nameLbl);
		}
	}
	
	/**
	 * Set the game result or score panel on play board
	 * @param playerList
	 */
	public void setGameResultPanel(List<Player> playerList) {
		this.playerList = playerList;
		// put label into JPanel, put the JPanel to specific location.
		Border borderLine = BorderFactory.createTitledBorder("Game Result");
		JPanel resultPnl = new JPanel();
		resultPnl.setBorder(borderLine);
		resultPnl.setLayout(new GridLayout(4,2));
		resultPnl.setBackground(Color.yellow);
		for (int i=0; i<playerList.size(); i++) {
			Player player = playerList.get(i);
			JLabel resultNameLbl = new JLabel(player.getName());
			resultPnl.add(resultNameLbl);
			resultNameLabelList.add(resultNameLbl);
			
			JLabel resultValueLbl = new JLabel("" + player.getWin());
			resultPnl.add(resultValueLbl);
			resultValueLabelList.add(resultValueLbl);
			
			resultPnl.setLocation(800,20);
			resultPnl.setSize(200,200);
			add(resultPnl);
		}
	}

	public void updatePlayerName() {
		for(int i=0; i<3; i++) {
			String name = playerList.get(i).getName();
			playerNameLabelList.get(i).setText(name);
			resultNameLabelList.get(i).setText(name);
		}
	}

	public void removeFaceDownCard() {
		remove(faceDownLbl);
		repaint();
	}

	public void updateResult() {
		for(int i=0; i<4; i++) {
			Player player = playerList.get(i);
			int win = player.getWin();
			JLabel label = resultValueLabelList.get(i);
			label.setText(""+ win);
		}
		
	}

	public void setPlayerList(List<Player> playerList) {
		setGameResultPanel(playerList);
		
	}
}
