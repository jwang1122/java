package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private MainFrame parent; // bi-dirctional connection
	
	ConfigPanel(MainFrame parent){
		this.parent = parent;
		this.setLayout(new BorderLayout());
		ImagePanel imgPnl = new ImagePanel();
		add(imgPnl, BorderLayout.CENTER);
		
		JPanel buttonPnl = buildButtonPanel();
		add(buttonPnl, BorderLayout.SOUTH);
	}
	
	private JPanel buildButtonPanel() {
		JPanel configPnl = new JPanel();
		configPnl.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton switchBtn = new JButton("Start");
		switchBtn.setBackground(new Color(110, 15, 135));
		switchBtn.setForeground(Color.white);
		switchBtn.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth =2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configPnl.add(switchBtn, gbc);
		
		JButton configPlayerBtn = new JButton("Configure Player");
		configPlayerBtn.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth =1;
		configPnl.add(configPlayerBtn, gbc);

		JButton configBgBtn = new JButton("Configure Background");
		configBgBtn.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth =1;
		configPnl.add(configBgBtn, gbc);
		
		configPnl.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
//		configPnl.setBorder(BorderFactory.createLineBorder(Color.red));
		return configPnl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String act = e.getActionCommand();
		switch(act) {
		case "Start":
			parent.switchCard();
			break;
		case "Configure Player":
			ConfigPlayerDialog dialog = new ConfigPlayerDialog(parent); // bi-directional connection
			dialog.setVisible(true);
			break;
		case "Configure Background":
			Color[] availableColors = {BoardPanel.RED, BoardPanel.GREEN, BoardPanel.BLUE};
			Color bgColor = (Color)JOptionPane.showInputDialog(parent, "Choose One", "Input", JOptionPane.INFORMATION_MESSAGE, null, availableColors, availableColors[0]);
			parent.setBoardBackground(bgColor); // Method Driving
			break;
		default:
			parent.switchCard();
		}
	}

}
