package swing.mp3;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Mp3Player extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Player player;
	JTextField filenameTxt;
	
	Mp3Player(){
		init();
		add(buildPnl());	
		URL url = getClass().getClassLoader().getResource("resources/yunque.mp3");
		try {
			InputStream is = new FileInputStream(url.getPath());
			filenameTxt.setText(url.getPath());
            BufferedInputStream bufferedInputStream=new BufferedInputStream(is);
            player=new Player(bufferedInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Component buildPnl() {
		JPanel pnl = new JPanel();
		JLabel filenameLbl = new JLabel("Enter mp3 file name:");
		pnl.add(filenameLbl);
		filenameTxt = new JTextField(20);
		pnl.add(filenameTxt);
		pnl.setBackground(Color.cyan);
		JButton playBtn = new JButton("Play");
		playBtn.addActionListener(this);
		pnl.add(playBtn);
		return pnl;
	}

	void init() {
		this.setTitle("Mp3 Player");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		Mp3Player frame = new Mp3Player();
		frame.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			player.play();
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
