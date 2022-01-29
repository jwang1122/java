package blackjack;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout cardLyt = new CardLayout();
	ConfigPanel configPnl;
	BoardPanel boardPnl;
	Container container;
	List<Player> playerList = new ArrayList<>(); // Demand Driven Development
	Dealer dealer = new Dealer();
	
	MainFrame(){ // default scope modifier (public, protected, private, default)
		init();
		this.setLayout(cardLyt);
		
		configPnl = new ConfigPanel(this); // build a bi-direction connection
		boardPnl = new BoardPanel(this);
		
		add(configPnl);
		add(boardPnl);
		
		buildPlayerList();
	}
	
	private void buildPlayerList() {
		Player player = new Player("EAST", "EAST", this);
		playerList.add(player);
		player = new Player("SOUTH", "SOUTH", this);
		playerList.add(player);
		player = new Player("WEST", "WEST", this);
		playerList.add(player);
		player = new Dealer(this);
		playerList.add(player);
		
	}

	private void init() {
		this.setSize(1024, 728);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Blackjack Card Game");
		this.setResizable(false);	
		container = this.getContentPane();
	}

	public void switchCard() {
		cardLyt.next(container);
		
	}

	public void addCard(Card card, Player player) {
		// TODO Auto-generated method stub
		
	}
	
}
