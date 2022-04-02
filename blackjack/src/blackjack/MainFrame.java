package blackjack;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	
	CardLayout cardLyt = new CardLayout(); // switch windows
	ConfigPanel configPnl;
	BoardPanel boardPnl;
	ControlPanel controlPnl;
	Container container; // for switch window
	List<Player> playerList = new ArrayList<>(); // Demand Driven Development
	Dealer dealer;
	Player currentPlayer;
	private int index; // to change current player
	
	MainFrame(){ // default scope modifier (public, protected, private, default)
		init();
		buildPlayerList();
		index = 0;
		
		this.setLayout(cardLyt);
		configPnl = new ConfigPanel(this); // build a bi-direction connection
		
		JPanel playPnl = new JPanel();
		playPnl.setLayout(new BorderLayout());
		controlPnl = new ControlPanel(this);
		boardPnl = new BoardPanel(this, playerList);
		playPnl.add(controlPnl, BorderLayout.NORTH);
		playPnl.add(boardPnl, BorderLayout.CENTER);
		
		add(configPnl);
		add(playPnl);
		controlPnl.setPlayer(getCurrentPlayer());
	}
	
	private Player getCurrentPlayer() {
		currentPlayer = playerList.get(index);
		return currentPlayer;
	}
	
	private void buildPlayerList() {
		Player player = new Player("EAST", "EAST", this);
		playerList.add(player);
		player = new Player("SOUTH", "SOUTH", this);
		playerList.add(player);
		player = new Player("WEST", "WEST", this);
		playerList.add(player);
		this.dealer = new Dealer(this);
		playerList.add(dealer);
		
	}
	
	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Blackjack Card Game");
		this.setResizable(false);	
		container = this.getContentPane();
	}

	public void switchCard() {
		cardLyt.next(container);		
	}

	public void addCard(Card card, Player player) {
		boardPnl.addCard(card, player);
		
	}
	
	public void deal(Player player) {
		player.addCardToHand(dealer.deal());
		index ++;
		if(index>3) {
			index = 0;
		}
		controlPnl.setPlayer(getCurrentPlayer());
	}

	public void setBoardBackground(Color bgColor) {
		boardPnl.setBackground(bgColor);
		
	}

	public void setPlayerSeat(String name, String seat) {
		for(Player player : playerList) {
			if(player.seat.equals(seat)) {
				player.name = name;
				break;
			}
		}
		boardPnl.setPlayerName(name, seat);
		controlPnl.setPlayerName(name, seat);
	}

	public void disableDealBtn() {
		controlPnl.setButtonEnabled(controlPnl.dealBtn, false);	
	}
	
	public void enableDealBtn() {
		controlPnl.setButtonEnabled(controlPnl.dealBtn, true);	
	}
	
	public void disableHitBtn() {
		controlPnl.setButtonEnabled(controlPnl.hitBtn, false);	
	}
	
	public void enableHitBtn() {
		controlPnl.setButtonEnabled(controlPnl.hitBtn, true);	
	}
	
	public void disablePassBtn() {
		controlPnl.setButtonEnabled(controlPnl.passBtn, false);	
	}
	
	public void enablePassBtn() {
		controlPnl.setButtonEnabled(controlPnl.passBtn, true);	
	}

	public void hit(Player player) {
		player.addCardToHand(dealer.deal()); //if player is not dealer		
	}

	public void pass(Player player) {
		index++;
		controlPnl.setPlayer(getCurrentPlayer());
		if(currentPlayer.name.equals("Dealer")) { //the index is out of bound
			index = 0;
			boardPnl.removeFacedownCard();
			this.disableHitBtn();
			this.disablePassBtn();
			while(dealer.getHandValue()<17) {
				dealer.addCardToHand(dealer.deal());
			}
			this.enableUpdateBtn();
		}
	}

	private void enableUpdateBtn() {
		controlPnl.setButtonEnabled(controlPnl.updateBtn, true);	
	}

	public void updateResult() {
		int dealerTotal = dealer.getHandValue();
		for(Player p:playerList) {
			if(p.name.equals("Dealer")) {
				break;
			}
			int playerTotal = p.getHandValue();
			if(playerTotal>21) {
				dealer.win();
			}else if (dealerTotal>21) {
				p.win();
			}else if(playerTotal==dealerTotal) {
				
			}else if(playerTotal>dealerTotal) {
				p.win();
			}else {
				dealer.win();
			}
//			System.out.printf("%s: %s", p.name, p.win);
		}
//		System.out.printf("%s: %s", dealer.name, dealer.win);
		displayResult();
		disableUpdateBtn();
		enableClearBtn();
	}

	private void enableClearBtn() {
		controlPnl.setButtonEnabled(controlPnl.clearBtn, true);	
	}

	private void disableClearBtn() {
		controlPnl.setButtonEnabled(controlPnl.clearBtn, false);	
	}

	private void displayResult() {
		boardPnl.displayResult();
		
	}

	private void disableUpdateBtn() {
		controlPnl.setButtonEnabled(controlPnl.updateBtn, false);	
		
	}

	public void clearCards() {
		boardPnl.clearCards(); // DDD (Demand Driven Development)
		disableClearBtn();
		enableDealBtn();
		for(Player player: playerList) {
			player.cleanHand();
		}
		index = 0;
		currentPlayer = getCurrentPlayer();
		controlPnl.setPlayer(currentPlayer);
	}
	
	
	
}
