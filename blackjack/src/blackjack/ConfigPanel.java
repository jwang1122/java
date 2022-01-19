package blackjack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MainFrame parent; // bi-dirctional connection
	
	ConfigPanel(MainFrame parent){
		this.parent = parent;
		JButton switchBtn = new JButton("Switch Play Board");
		switchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.switchCard();	// Method Driving Development (MDD)			
			}
			
		});
		
		
		add(switchBtn);
	}

}
