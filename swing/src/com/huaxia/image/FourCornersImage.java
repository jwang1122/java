package com.huaxia.image;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Make sure the FOLDER
 * @author John
 *
 */
public class FourCornersImage extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 640;
	static final String FOLDER = "/Users/12818/workspace/java/john/doc/";
	static final String RANGERS1 = "TexasRangers.png";
	static final String RANGERS2 = "Rangers.png";
	static final String ASTROS1 = "HoustonAstros.png";
	static final String ASTROS2 = "Astros.png";
	static final String MAVERICKS1 = "DallasMavericks.png";
	static final String MAVERICKS = "Mavericks.png";
	static final String ROCKETS1 = "HoustonRockets.png";
	static final String ROCKETS2 = "Rockets.png";
	
	boolean astros1 = false;
	boolean range1 = false;
	public FourCornersImage(String framename) {
		super(framename);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
//		add(new FourCornersPanel ());
		Container c = this.getContentPane();
		Toolkit t = Toolkit.getDefaultToolkit();
		ImageIcon astrosIcon1 = new ImageIcon(t.getImage(FOLDER + ASTROS1));
		ImageIcon astrosIcon2 = new ImageIcon(t.getImage(FOLDER + ASTROS2));
		JButton astrosBtn = new JButton(astrosIcon1);
		astrosBtn.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  if(astros1) {
				  astrosBtn.setIcon(astrosIcon1);
			  }else {
				  astrosBtn.setIcon(astrosIcon2);
			  }
			  astros1 = !astros1;
		  }
		});
		astrosBtn.setBounds(10, 10, 300, 300);
		c.add(astrosBtn);
		
		ImageIcon rangeIcon1 = new ImageIcon(t.getImage(FOLDER + RANGERS1));
		ImageIcon rangeIcon2 = new ImageIcon(t.getImage(FOLDER + RANGERS2));
		JButton rangeBtn = new JButton(rangeIcon1);
		rangeBtn.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  if(range1) {
				  rangeBtn.setIcon(rangeIcon1);
			  }else {
				  rangeBtn.setIcon(rangeIcon2);
			  }
			  range1 = !range1;
		  }
		});
		rangeBtn.setBounds(300, 10, 300, 300);
		c.add(rangeBtn);
//		setLayout(null);
		setLayout(new FlowLayout());
//		pack();
	}

	public static void main(String[] args) {
		FourCornersImage frame = new FourCornersImage("4-Corner image");
		frame.setVisible(true);
	}

}
