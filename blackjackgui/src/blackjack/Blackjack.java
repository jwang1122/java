package blackjack;

import java.awt.EventQueue;

/**
 * This is startup class for Blackjack game.
 * 
 * @author Rodney
 *
 */
public class Blackjack {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		});
	}
}
