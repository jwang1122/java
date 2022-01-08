package blackjack;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
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
	private ButtonPanel buttonPnl;
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

	private void buildPlayerList() {
		Player westPlayer = new Player("WEST", "WEST", this);
		Player southPlayer = new Player("SOUTH", "SOUTH", this);
		Player eastPlayer = new Player("EAST", "EAST", this);
		dealer = new Dealer(this);
		
		playerList.add(westPlayer);
		playerList.add(southPlayer);
		playerList.add(eastPlayer);
		playerList.add(dealer);
		currentPlayer = playerList.get(index);
		buttonPnl.setCurrentPlayer(currentPlayer);
		boardPnl.setPlayerList(playerList);
	}

	private void init() {
		setTitle("Blackjack Game");
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL url = getClass().getClassLoader().getResource("resources/icon.jpg");
		Image icon = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(icon);
		setResizable(false);
	}

	private JPanel buildBoardPanel() {
		JPanel mainPnl = new JPanel();

		mainPnl.setLayout(new BorderLayout());
		buttonPnl = new ButtonPanel(this);
		mainPnl.add(buttonPnl, BorderLayout.NORTH);

		boardPnl = new PlayBoardPanel();
		mainPnl.add(boardPnl, BorderLayout.CENTER);

		return mainPnl;
	}

	void switchCard() {
		card.next(parentContainer);
	}

	public void setBoardColor(Color backgroundColor) {
		boardPnl.setBackground(backgroundColor);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		});
	}

	public void addCard(Card card, Player player) {
		boardPnl.addCard(card, player);
	}

	public void deal() {
		currentPlayer.addCardToHand(dealer.deal());
	}

	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return currentPlayer;
	}

	public void clearBoard() {
		for(Player player: playerList) {
			player.reset();
		}
		boardPnl.clearBoard();
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
}
