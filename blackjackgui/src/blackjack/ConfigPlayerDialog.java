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
	private static final long serialVersionUID = 1L;

	ConfigPlayerDialog(MainFrame parent) {
		super(parent, true);
		setSize(300, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);

		JPanel namePnl = new JPanel();
		JLabel nameLbl = new JLabel("Player name: ");
		namePnl.add(nameLbl);
		JTextField nameTxt = new JTextField(10);
		namePnl.add(nameTxt);
		add(namePnl, BorderLayout.NORTH);
		
		JPanel seatPnl = new JPanel();
		JLabel seatLbl = new JLabel("Select Seat: ");
		seatPnl.add(seatLbl);
		String seats[] = { "WEST", "SOUTH", "EAST" };
//		JList<String> seatLst = new JList<String>(seats);
//		seatLst.setSelectedIndex(0);
//		seatLst.setFixedCellWidth(110);
//		seatPnl.add(seatLst);
		JComboBox<String> seatCbx = new JComboBox<>(seats);
		seatCbx.setPreferredSize(new Dimension(110, 25));;
		seatPnl.add(seatCbx);
		add(seatPnl, BorderLayout.CENTER);
		
		JButton setBtn = new JButton("Set");
		add(setBtn, BorderLayout.SOUTH);
		setBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				String seat = seatLst.getSelectedValue();
				String seat = seatCbx.getSelectedItem().toString();
				String name = nameTxt.getText();
				parent.setPlayerName(seat, name);				
			}
			
		});
	}
}
