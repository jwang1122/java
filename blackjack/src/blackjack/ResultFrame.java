package blackjack;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ResultFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	ResultFrame(){
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel resultPnl = new JPanel();
		Border borderLine = BorderFactory.createTitledBorder("Game Result");
		resultPnl.setBorder(borderLine);
		resultPnl.setLayout(new GridLayout(2,2));
		resultPnl.setBackground(Color.yellow);
		JLabel nameLbl = new JLabel("John");
		resultPnl.add(nameLbl);
		JLabel winLbl = new JLabel("1");
		resultPnl.add(winLbl);
		nameLbl = new JLabel("Hongkai");
		resultPnl.add(nameLbl);
		winLbl = new JLabel("2");
		resultPnl.add(winLbl);
		
		resultPnl.setLocation(250, 10);
		resultPnl.setSize(200,200);
		add(resultPnl);
		
	}
	public static void main(String[] args) {
		ResultFrame f = new ResultFrame();
		f.setLayout(null);
		f.setVisible(true);	}

}
