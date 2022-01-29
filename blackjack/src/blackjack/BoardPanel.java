package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	MainFrame parent;

	BoardPanel(MainFrame parent) {
		this.parent = parent;
		this.setLayout(new BorderLayout());
		
		URL url = this.getClass().getClassLoader().getResource("resources/diamondK.gif");
		ImageIcon image = new ImageIcon(url);
		JLabel imageLbl = new JLabel(image);
		add(imageLbl, BorderLayout.CENTER);
		JLabel westLbl = new JLabel("west");
		add(westLbl,BorderLayout.CENTER);
		westLbl.setLocation(10, 300);
		westLbl.setSize(50, 30);
		
		JButton switchBtn = new JButton("Switch Configure Panel");
		switchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.switchCard(); // Method Driving Development (MDD)
			}

		});

		add(switchBtn, BorderLayout.NORTH);

	}
}