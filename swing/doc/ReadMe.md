<h1>Java Swing Learning Notes</h1>

[](../../doc/utilities.md)

## User Timer
* [Timer](https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html)

> Swing timers are very easy to use. When you create the timer, you specify an action listener to be notified when the timer "goes off". 

```java
Timer timer = new Timer(40, this);
timer.start();
```

Every 40 miliseconds, the application will run the function **actionPerformed()** defined in this class.

## Load Image

1. use Toolkit and getClass()
```java
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("/resources/apple.png");
		apple = t.getImage(iconUrl);
```
```output
<project root>
    ├── 📝doc/
    |    ├── mistakes.md 
    |    └── ReadMe.md 
    ├── 🔥src/
    |       ├── com/
    |       └── resources/
    └── 👉ReadMe.md
```
where **src** is in **classpath**. all images stored in **resources** folder.

🔔⚡️ Notice the / before **resoutces**.

2. use ImageIO and getClassLoader()
```java
		URL iconUrl = getClass().getClassLoader().getResource("resources/diamondK.gif");
		img = ImageIO.read(new File(iconUrl.getFile()));
```
🔔⚡️ Notice that there is no / before **resoutces**.