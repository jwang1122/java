package blackjack;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout cardLyt = new CardLayout();
	ConfigPanel configPnl;
	BoardPanel boardPnl;
	Container container;
	
	MainFrame(){ // default scope modifier (public, protected, private, default)
		init();
		this.setLayout(cardLyt);
		
		configPnl = new ConfigPanel(this);
		boardPnl = new BoardPanel();
		
		add(configPnl);
		add(boardPnl);
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
}
