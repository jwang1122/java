package com.huaxia.pane;

import javax.swing.*;
import java.awt.event.*;

class PopupMenuExample2 implements ActionListener{
	final JLabel label = new JLabel();
	PopupMenuExample2() {
		final JFrame f = new JFrame("PopupMenu Example");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);
		final JPopupMenu popupmenu = new JPopupMenu("Edit");
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		popupmenu.add(cut);
		popupmenu.add(copy);
		popupmenu.add(paste);
		f.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				popupmenu.show(f, e.getX(), e.getY());
			}
		});
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		f.add(label);
		f.add(popupmenu);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd =e.getActionCommand();
		label.setText(cmd + " MenuItem clicked.");
	}

	public static void main(String args[]) {
		new PopupMenuExample2();
	}
}