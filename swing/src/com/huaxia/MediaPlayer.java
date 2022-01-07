package com.huaxia;

import java.io.File;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.JFrame;

/**
*
* @author BUDDHIMA
*/

public class MediaPlayer extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		try {
			File file = new File("/Users/12818/workspace/java/kingdomino/kingdomino.mp4");
			Player player = Manager.createPlayer(file.toURI().toURL());
			player.start();
			player.close();
			
			player.getVisualComponent();
			player.getControlPanelComponent();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}