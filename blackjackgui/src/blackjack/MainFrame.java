package blackjack;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private CardLayout card;
	private Container parentContainer;
	private PlayBoardPanel boardPnl;
	private ControlPanel buttonPnl;
	private List<Player> playerList = new ArrayList<>();
	private Player currentPlayer;
	private int index = 0;
	private Dealer dealer;
	
	public MainFrame() {
		init();
		
		card = new CardLayout();
		this.setLayout(card);
		this.parentContainer = this.getContentPane();

		this.add(new ConfigPanel(this));
		this.add(buildBoardPanel());

		buildPlayerList();
	}

	private void init() {
		setTitle("Blackjack Game");
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL url = getClass().getClassLoader().getResource("resources/icon.jpg");
		Image icon = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(icon);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width-this.getSize().width)/2, (dim.height-this.getSize().height)/2);
	}

	private void buildPlayerList() {
		Player westPlayer = new Player("WEST", "WEST", this);
		Player southPlayer = new Player("SOUTH", "SOUTH", this);
		Player eastPlayer = new Player("EAST", "EAST", this);
		dealer = new Dealer(this);
		
		playerList.add(eastPlayer);
		playerList.add(southPlayer);
		playerList.add(westPlayer);
		playerList.add(getDealer());
		currentPlayer = playerList.get(index);
		buttonPnl.setCurrentPlayer(currentPlayer);
		boardPnl.setPlayerName(playerList);
		boardPnl.setPlayerList(playerList);
	}

	private JPanel buildBoardPanel() {
		JPanel mainPnl = new JPanel();

		mainPnl.setLayout(new BorderLayout());
		buttonPnl = new ControlPanel(this);
		mainPnl.add(buttonPnl, BorderLayout.NORTH);

		boardPnl = new PlayBoardPanel(this);
		mainPnl.add(boardPnl, BorderLayout.CENTER);

		return mainPnl;
	}

	void switchCard() {
		card.next(parentContainer);
	}

	public void setBoardColor(Color backgroundColor) {
		boardPnl.setBackground(backgroundColor);
	}

	public void addCard(Card card, Player player) {
		boardPnl.addCard(card, player);
	}

	public void deal() {
		currentPlayer.addCardToHand(getDealer().deal());
		index++;
		if(currentPlayer.isDealer() && currentPlayer.getHandSize()==2) {
			buttonPnl.setEnabledDealBtn(false);
		}
		if (index>playerList.size()-1) {
			index=0;
		}
		currentPlayer = playerList.get(index);
	}

	public void clearBoard() {
		for(Player player: playerList) {
			player.resetCardPosition();
		}
		buttonPnl.setEnabledDealBtn(true);
		boardPnl.clearBoard();
		index=0;
		currentPlayer = playerList.get(index);
		buttonPnl.setCurrentPlayer(currentPlayer);
		boardPnl.repaint();
	}

	public void setPlayerName(String seat, String name) {
		for(Player player: playerList) {
			if(player.seat.equals(seat)) {
				player.setName(name);
			}
		}
		boardPnl.updatePlayerName();
		buttonPnl.updateCurrentPlayerName();
	}

	public void enableHitBtn() {
		buttonPnl.enableHitBtn();
	}
	
	public void determineWinner() {
		int dealerTotal = dealer.getHandValue();
		for(int i=0; i<playerList.size()-1; i++) {
			Player player = playerList.get(i);
			int playerTotal = player.getHandValue();
			if(playerTotal>21) {
				dealer.win();
			}else if(dealerTotal>21) {
				player.win();
			}else if(playerTotal==dealerTotal) {
				
			}else if(playerTotal>dealerTotal) {
				player.win();
			}else {
				dealer.win();
			}
		}
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Player nextPlayer() {
		index++;
		currentPlayer = playerList.get(index);
		buttonPnl.setCurrentPlayer(currentPlayer);
		return currentPlayer;
	}

	/**
	 * After every other player passed, add cards to dealer till meet the requirement.
	 */
	public void addCardToDealer() {
		boardPnl.removeFaceDownCard();
		int value = dealer.getHandValue();
		while(value<17) {
			dealer.addCardToHand(dealer.deal());
			value = dealer.getHandValue();
		}
		index = 0;
		buttonPnl.setEnabledDealBtn(false);
	}

	public void calculateResult() {
		determineWinner();
		boardPnl.updateResult();
	}

	/**
	 * for unittest only.
	 * 
	 * @return player list
	 */
	public List<Player> getPlayerList() {
		return playerList;
	}
}
