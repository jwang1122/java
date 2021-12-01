package com.huaxia.swing;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageViewer extends AbstractFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageViewer() {
		super();
	}
	
	@Override
	protected void init() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Subject");
		label.setIcon(new ImageIcon("C:\\Users\\hp\\workspace\\java\\rodney\\bin\\com\\rodney\\swing\\diamondK.gif"));
		panel.add(label);
		add(panel);
	}
	public static void main (String args[]) {
		ImageViewer iv = new ImageViewer();
		iv.setVisible(true);
	}

}
