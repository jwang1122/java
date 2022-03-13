package blackjack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigPlayerDialog extends JDialog {
	MainFrame parent;
	
	ConfigPlayerDialog(MainFrame parent){
		this.parent = parent;
		setSize(300, 200);
		this.setTitle("Set player's seat");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(parent);
		
		JPanel namePnl = new JPanel(); // FlowLayout by default
		JLabel nameLbl = new JLabel("Player name: ");
		namePnl.add(nameLbl);
		JTextField nameTxt = new JTextField(10);
		namePnl.add(nameTxt);
		add(namePnl, BorderLayout.NORTH);
		
		JPanel seatPnl = new JPanel();
		JLabel seatLbl = new JLabel("Select Seat: ");
		seatPnl.add(seatLbl);
		String[] seats = {"EAST", "SOUTH", "WEST"};
		JComboBox<String> seatCbx = new JComboBox<>(seats);
		seatCbx.setPreferredSize(new Dimension(110, 25));
		seatPnl.add(seatCbx);
		add(seatPnl, BorderLayout.CENTER);
		
		JPanel buttonPnl = new JPanel();
		JButton setPlayerNameBtn = new JButton("Set Player Name");
		setPlayerNameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTxt.getText();
				String seat = seatCbx.getSelectedItem().toString();
				parent.setPlayerSeat(name, seat);				
			}
			
		});
//		setPlayerNameBtn.setSize(110, 25);
//		setPlayerNameBtn.setPreferredSize(new Dimension(110, 25)); no working
		buttonPnl.add(setPlayerNameBtn);		
		add(buttonPnl, BorderLayout.SOUTH);
	}
}
