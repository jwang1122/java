package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private Color btnColor = new Color(110, 15, 135);

	public ConfigPanel(MainFrame parent) {
		this.parent = parent;
		setLayout(new BorderLayout());
		JPanel buttonPnl = new JPanel();
		buttonPnl.setLayout(new GridBagLayout());

		JButton addPlayerBtn = new JButton("Configure Players");
		JButton backgrounBtn = new JButton("Configure Background");
		JButton startBtn = new JButton("Start");
		JLabel emptyLbl = new JLabel("  ");
		JLabel empty1Lbl = new JLabel("  ");

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 1;
		gc.gridy = 1;
		buttonPnl.add(addPlayerBtn, gc);
		gc.gridx = 2;
		buttonPnl.add(backgrounBtn, gc);
		gc.gridx = 1;
		gc.gridwidth = 2;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		buttonPnl.add(startBtn, gc);
		gc.gridy = 4;
		buttonPnl.add(emptyLbl, gc);
		gc.gridy = 5;
		buttonPnl.add(empty1Lbl, gc);

		startBtn.setBackground(btnColor);
		startBtn.setForeground(Color.white);

		add(buttonPnl, BorderLayout.SOUTH);
		add(new ImagePanel(), BorderLayout.CENTER);

		startBtn.addActionListener(this);
		backgrounBtn.addActionListener(this);
		addPlayerBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "Start":
			parent.switchCard();
			break;
		case "Configure Background":
			Color[] posibleValues = { MyBackgroundColor.MY_BLUE, MyBackgroundColor.MY_GREEN,
					MyBackgroundColor.MY_YELLOW };
			Color selectedColor = (Color) JOptionPane.showInputDialog(parent, "Choose One", "Input", JOptionPane.INFORMATION_MESSAGE, null, posibleValues, posibleValues[0]);
			if (selectedColor != null) {
				parent.setBoardColor(selectedColor);
			}
			break;
		case "Configure Players":
			ConfigPlayerDialog dialog = new ConfigPlayerDialog(parent);
			dialog.setVisible(true);
			break;
		default:
			return;
		}
	}

}
