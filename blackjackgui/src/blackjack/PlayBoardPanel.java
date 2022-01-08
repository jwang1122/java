package blackjack;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayBoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static Color color1, color2, color3;
	static {
		color1 = new Color(114, 183, 244);
		color2 = new Color(244, 215, 114);
		color3 = new Color(183, 243, 79);		
	}
	
	private Color bkColor;
	private List<JLabel> cardList = new ArrayList<>(); // for removing all cards from the Panel
	private List<JLabel> playerNameLabelList = new ArrayList<>(); // for resigning player name label
	private List<JLabel> resultNameLabelList = new ArrayList<>();
	private List<JLabel> resultValueLabelList = new ArrayList<>();
	private List<Player> playerList;
	
	public PlayBoardPanel() {
		bkColor = color3;
		this.setBackground(bkColor);
		setLayout(null);
	}
	
	
	void setBackgroundColor(Color bkColor){
		this.bkColor = bkColor;
	}

	public void addCard(Card card, Player player) {
		JLabel label = new JLabel(card.getCardImage());
		label.setLocation(player.getCardX(), player.getCardY());
		label.setSize(Card.CARD_WIDTH, Card.CARD_HEIGHT);
		add(label);
		cardList.add(label);
		this.revalidate();
		repaint();
	}


	public void clearBoard() {
		for(JLabel card: cardList) {
			remove(card);
		}
		
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
		for (int i=0; i<playerList.size(); i++) {
			Player player = playerList.get(i);
			JLabel nameLbl = new JLabel(player.getName());
			nameLbl.setLocation(player.getCardX()-60, player.getCardY());
			nameLbl.setSize(70, 30);
			add(nameLbl);
			playerNameLabelList.add(nameLbl);
			JLabel resultNameLbl = new JLabel(player.getName());
			resultNameLbl.setLocation(800,i*30 + 30);
			resultNameLbl.setSize(70, 30);
			add(resultNameLbl);
			resultNameLabelList.add(resultNameLbl);
			JLabel resultValueLbl = new JLabel("" + player.getWin());
			resultValueLbl.setLocation(900,i*30 + 30);
			resultValueLbl.setSize(30, 30);
			add(resultValueLbl);
			resultValueLabelList.add(resultValueLbl);
		}
	}


	public void updatePlayerName() {
		for(int i=0; i<3; i++) {
			String name = playerList.get(i).getName();
			playerNameLabelList.get(i).setText(name);
			resultNameLabelList.get(i).setText(name);
		}
	}
}
