<h1>Mistakes</h1>

[](../../doc/utilities.md)

## Image does not show when run jar
❌ **Mistake:**
❓ Strange enough, I load all Card Images, they are displayed with no problem. but I am using same code to load front window image, it does't show. it works fine when run it under Eclipse.
```java
	public ImagePanel() {
		this.setBackground(new Color(107,155,17));
		setLayout(new BorderLayout());
		URL url = getClass().getClassLoader().getResource("resources/animation.gif");
		System.out.println("URL: " + url);
		ImageIcon bkImage = new ImageIcon(url.getPath());
		JLabel titleLbl = new JLabel("Welcome to Our Blackjack Game!", SwingConstants.CENTER);
		titleLbl.setFont(new Font(Font.SERIF, Font.BOLD, 48));
		titleLbl.setForeground(new Color(110, 15, 135));
		JLabel imageLbl = new JLabel(bkImage);
		add(titleLbl, BorderLayout.NORTH);
		add(imageLbl, BorderLayout.CENTER);
	}
```

✔️😢 Use **paint(Graphics g)** method, instead of create JLabel image.
```java
	public ImagePanel() {
		URL url = getClass().getResource("/resources/animation.gif");
		frontImg = Toolkit.getDefaultToolkit().getImage(url);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 1024, 768);
		g.setColor(new Color(107,155,17));
		g.fillRect(0, 0, 1024, 768);
		g.setColor(new Color(110, 15, 135));
		g.setFont(new Font(Font.SERIF, Font.BOLD, 48));
		g.drawString("Welcome to Our Blackjack Game!", 160, 70);
		g.drawImage(frontImg, 180, 110, this);
	}
``` 
👎😢 Why run jar is different run under eclipse?! Bad, bad, bad!!❗️ ❗️ 