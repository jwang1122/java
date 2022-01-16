package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel playerNameLbl = new JLabel("Player Name: ");
	JButton dealCardBtn, resultBtn, hitBtn, passBtn, configBtn, clearBtn, endBtn;
	MainFrame parent;
	Player player;
	
	public ControlPanel(MainFrame parent) {
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
		hitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean failed = player.addCardToHand(parent.getDealer().deal());
				if(failed) {
					JOptionPane.showMessageDialog(parent, player.name.concat(", your hand value is busted! You can only do pass."), "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		hitBtn.setEnabled(false);
		playerButtonPnl.add(hitBtn);
		
		passBtn = new JButton("Pass");
		passBtn.setEnabled(false);
		passBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Player player = parent.nextPlayer();
				if(player.isDealer()) {
					parent.addCardToDealer();
				}
			}
			
		});
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
		
		resultBtn = new JButton("Update Results");
		resultBtn.setEnabled(false);	
		resultBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.calculateResult();				
			}
			
		});
		resultBtn.setEnabled(false);
		cardButtonPnl.add(resultBtn);
		
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
		clearBtn.setEnabled(false);
		
		endBtn = new JButton("Exit");
		cardButtonPnl.add(endBtn);
		endBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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

	public void enableHitBtn() {
		hitBtn.setEnabled(true);
		passBtn.setEnabled(true);
	}

	public void setEnabledDealBtn(boolean b) {
		dealCardBtn.setEnabled(b);
	}
	
	public void setEnabledClearBtn(boolean b) {
		clearBtn.setEnabled(b);
	}
	
	public void setEnabledResultBtn(boolean b) {
		resultBtn.setEnabled(b);		
	}
	
	public void setEnabledHitBtn(boolean b) {
		hitBtn.setEnabled(b);
		passBtn.setEnabled(b);
	}
	
	
	
}
