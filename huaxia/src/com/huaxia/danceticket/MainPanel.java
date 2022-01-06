package com.huaxia.danceticket;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Main panel show in the center of window. it display dance party information.
 * 
 * @author John
 *
 */
public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String IMAGE_FILE_PROP = "background.image.file";
	private static final String PARTY_START_TIME = "party.start.time";
	private static final String PARTY_LOCATION = "party.location";
	private static final String SPONSOR = "party.sponsor";

	private Image img;
	private int x, y;
	private MainFrame parent;

	public MainPanel(MainFrame parent) {
		this.parent = parent;
		String imageFile = parent.getProp().getProperty(IMAGE_FILE_PROP);
		InputStream imgStream = MainPanel.class.getClassLoader().getResourceAsStream(imageFile);
		try {
			img = ImageIO.read(imgStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout());
	}

	@Override
	public void paint(Graphics g) { // javax.swing.JComponent
		String time = getDateString();
		String location = getPartyLocation();
		String sponsor = getSponsor();
		int width = img.getWidth(this);
		int height = img.getHeight(this);
		g.drawImage(img, x, y, width, height, this);
		((Graphics2D) g).setStroke(new BasicStroke(3));
		g.setColor(Color.GRAY);
		g.drawRoundRect(250, 10, 220, 70, 5, 5);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.setColor(Color.RED);
		g.drawString("Time: " + time, 260, 35);
		g.drawString("Location: " + location, 260, 65);
		g.setColor(Color.BLACK);
		g.drawString("Sponsored by: " + sponsor, 160, 430);
	}

	private String getSponsor() {
		return parent.getProp().getProperty(SPONSOR);
	}

	private String getPartyLocation() {
		return parent.getProp().getProperty(PARTY_LOCATION);
	}

	private String getDateString() {
		Date date = new Date();
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfOutput = new SimpleDateFormat("h:mm a MM/dd/yyyy");
		try {
			Properties prop = parent.getProp();
			String startTime = prop.getProperty(PARTY_START_TIME);
			date = sdfInput.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdfOutput.format(date);
	}

}
