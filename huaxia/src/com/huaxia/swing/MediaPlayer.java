package com.huaxia.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
*
* @author BUDDHIMA
*/

public class MediaPlayer extends JFrame {


	public static void main(String[] args) {

		try {
			File file = new File("/Users/12818/workspace/java/kingdomino/kingdomino.mp4");
			Player player = Manager.createPlayer(file.toURI().toURL());
			player.start();
			player.close();
			
			Component visual = player.getVisualComponent();
			Component control = player.getControlPanelComponent();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}