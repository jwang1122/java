package swing.mp3;

import java.io.IOException;
import java.net.URL;
//import java.net.MalformedURLExc;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class SoundPlayer {
	private Player audioPlayer = null;

	public SoundPlayer() throws IOException, NoPlayerException, CannotRealizeException {
		URL url = getClass().getClassLoader().getResource("resources/whiff.wav");
		System.out.println(url.getPath());
		audioPlayer = Manager.createRealizedPlayer(url);
	}

	public void play() {
		audioPlayer.start();
	}

	public void stop() {
		audioPlayer.stop();
		audioPlayer.close();
	}

	public static void main(String[] args) {
		try {
//			File audioFile = new File("/t.mp3");
			SoundPlayer player = new SoundPlayer();

			player.play();

			// wait for the user to press Enter to proceed.
			System.in.read();
			System.out.println("-> Exiting");
			player.stop();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.exit(0);

	}
}