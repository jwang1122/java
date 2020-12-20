# Frequently Used Java Tricks

## Table of Contents
1. [Loading image from class resource](#Loading-image-from-class-resource)
1. [Read .csv file from class](#Read-.csv-file-from-class)
1. [](#)

## Loading image from class resource
* The 'clubA.png' image file is located at 
./src/com/huaxia/swing/clubA.png
which s the same folder as MyPanel.java class.

```java
	public void paint(Graphics g) {

		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("clubA.png");
		apple = t.getImage(iconUrl);
		g.drawImage(apple, apple_x, apple_y, this);

	}
```
---
While 'Forest.jpg' is located in the same folder as Terrain.java class.
```java
    InputStream is = Terrain.class.getResourceAsStream("Forest.jpg");
    imageF = ImageIO.read(is);
```
---
[Table of Contents](#Table-of-Contents)

## Read .csv file from class
```java
    InputStream is = Deck.class.getResourceAsStream("dominos.csv");

    Scanner sc;
    sc = new Scanner(is);
    sc.nextLine(); // get rid of header line
    while (sc.hasNextLine()) {
        ...
    }
```
---
[Table of Contents](#Table-of-Contents)

