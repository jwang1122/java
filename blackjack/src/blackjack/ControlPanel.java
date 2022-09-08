package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame parent;
	Player player;
	JButton dealBtn = new JButton("Deal Card");
	JButton hitBtn = new JButton("Hit");
	JButton passBtn = new JButton("Pass");
	JButton updateBtn = new JButton("Update Result");
	JButton clearBtn = new JButton("Clear");
	JButton exitBtn = new JButton("Exit");
	JLabel nameLbl = new JLabel();

	
	ControlPanel(MainFrame parent){ // bi-directional connection
		this.parent = parent;
		this.setLayout(new BorderLayout());
		
		add(buildLeftPanel(), BorderLayout.WEST);
		add(buildRightPnl(), BorderLayout.EAST);
		
		init();
	}

	private void init() {
		hitBtn.setEnabled(false);
		passBtn.setEnabled(false);
		updateBtn.setEnabled(false);
		clearBtn.setEnabled(false);
	}

	private JPanel buildRightPnl() {
		JPanel rightPnl = new JPanel();
		rightPnl.add(nameLbl);
		hitBtn.addActionListener(this);
		
		rightPnl.add(hitBtn);
		passBtn.addActionListener(this);
		
		rightPnl.add(passBtn);
		return rightPnl;
	}

	private JPanel buildLeftPanel() {
		JPanel leftPnl = new JPanel();
		JButton configBtn = new JButton("Configure");
		leftPnl.add(dealBtn);
		leftPnl.add(configBtn);
		leftPnl.add(updateBtn);
		leftPnl.add(clearBtn);
		leftPnl.add(exitBtn);

		configBtn.addActionListener(this);
		dealBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		return leftPnl;
	}


	public void setPlayer(Player player) {
		this.player = player;
		nameLbl.setText(player.name);
	}


	public void setButtonEnabled(JButton btn, boolean flag) {
		btn.setEnabled(flag);
	}

	public void setPlayerName(String name, String seat) {
		if(player.seat.equals(seat)) {
			nameLbl.setText(name);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "Configure":
			parent.switchCard();
			break;
		case "Deal Card":
			parent.deal(player);
			break;
		case "Hit":
			parent.hit(player);
			break;
		case "Pass":
			parent.pass(player);
			break;
		case "Update Result":
			parent.updateResult();
			break;
		case "Clear":
			parent.clearCards();
			break;
		case "Exit":
			System.exit(0);
			break;
		default:
			System.exit(0);			
		}
			
		
	}

}
