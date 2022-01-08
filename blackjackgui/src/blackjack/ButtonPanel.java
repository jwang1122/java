package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel playerNameLbl = new JLabel("Player Name: ");
	JButton dealCardBtn, resultBtn, hitBtn, passBtn, configBtn, clearBtn;
	MainFrame parent;
	Player player;
	
	public ButtonPanel(MainFrame parent) {
		this.parent = parent;
		this.setLayout(new BorderLayout());
		
		add(buildButtonPanel(), BorderLayout.WEST);
		add(buildPlayerPanel(), BorderLayout.EAST);
	}
	
	private JPanel buildPlayerPanel() {
		JPanel playerButtonPnl = new JPanel(); 
		
		playerButtonPnl.add(playerNameLbl);
		hitBtn = new JButton("Hit");
		hitBtn.setEnabled(false);
		playerButtonPnl.add(hitBtn);
		passBtn = new JButton("Pass");
		passBtn.setEnabled(false);
		playerButtonPnl.add(passBtn);
		return playerButtonPnl;
	}

	private JPanel buildButtonPanel() {
		JPanel cardButtonPnl = new JPanel();
		
		dealCardBtn = new JButton("Deal Card");
		cardButtonPnl.add(dealCardBtn);
		dealCardBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.deal();
			}
			
		});
		
		resultBtn = new JButton("Display Game Result");
		cardButtonPnl.add(resultBtn);
		resultBtn.setEnabled(false);		
		
		configBtn = new JButton("Configure");
		cardButtonPnl.add(configBtn);
		configBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.switchCard();
			}
			
		});
		
		clearBtn = new JButton("Clear");
		cardButtonPnl.add(clearBtn);
		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.clearBoard();
			}
			
		});
		
		
		return cardButtonPnl;
	}

	public void setCurrentPlayer(Player player) {
		this.player = player;
		playerNameLbl.setText(this.player.name);
	}

	public void updateCurrentPlayerName() {
		playerNameLbl.setText(this.player.name);
	}
	
}
