package com.huaxia.component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CheckBoxMenuItem {
	String value = "option_1";
	
	CheckBoxMenuItem() {
		JFrame frame = new JFrame("Jmenu Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		// File->New, N - Mnemonic
		JMenuItem menuItem1 = new JMenuItem("Open", KeyEvent.VK_N);
		fileMenu.add(menuItem1);
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				System.out.println(cmd);
				System.out.println(value);
			}
			
		});

		JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Option_1");
		caseMenuItem.setMnemonic(KeyEvent.VK_C);
		fileMenu.add(caseMenuItem);

		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton aButton = (AbstractButton) event.getSource();
				boolean selected = aButton.getModel().isSelected();
				String newLabel;
				if (selected) {
					newLabel = "Value-1";
				} else {
					newLabel = "Value-2";
				}
				aButton.setText(newLabel);
				value = newLabel;
			}
		};

		caseMenuItem.addActionListener(aListener);
		JLabel lb = new JLabel();
		JButton jb = new JButton("Show Option");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lb.setText("Option: " + value);
				
			}
			
		});
		frame.setLayout(new FlowLayout());
		frame.add(lb);
		frame.add(jb);
		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);

	}

	public static void main(final String args[]) {
		new CheckBoxMenuItem();
	}
}
