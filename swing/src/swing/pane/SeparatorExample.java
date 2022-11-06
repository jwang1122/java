package swing.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class SeparatorExample implements ActionListener{
	private JMenu menu;
	private JMenuItem i1, i2, i3, i4, i5;
	private JLabel label = new JLabel();
	
	SeparatorExample() {
		JFrame f = new JFrame("Separator Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		menu = new JMenu("Menu");
		i1 = new JMenuItem("Item 1");
		i2 = new JMenuItem("Item 2");
		i3 = new JMenuItem("Item 3");
		i4 = new JMenuItem("Item 4");
		i5 = new JMenuItem("Item 5");
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		menu.add(i1);
		menu.addSeparator();
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.addSeparator();
		menu.add(i5);
		mb.add(menu);
		f.setJMenuBar(mb);
		f.add(label);
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new SeparatorExample();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		label.setText(cmd + " menu item is selected.");
	}
	
}