# Black Jack Card Game - Part 1
* Involved classes:

```
Card.java
BlackJackCard.java
CatdTest.java
```

* Finish the Card class:

```java
public class Card {
public static final String FACES[] = {"A", "2", "3","4", "5", "6", "7", "8", "9", "10", "J","Q", "K"}; 
public static final String SUITS[] = {"HEARTS", "DIAMONDS", "SPADES", "CLUBS"};
private String face;
private String suit;

//constructors

//set methods

//get methods

	public int getValue() { 
		// your code here
	} 
	// equals method
	public String toString() {
		return "[" + face" +" of "+ suit+", " + getValue() + "]";
	} 
}
```
* NExt, finish the BlackJackCard class, for right now "A" count as 11 while "J", "Q", "K" count as 10

```java
public class BlackJackCard extends Card {
	//constructors
	
	public int getValue() {
		//enables you to build the value for the game into 
		//the card. This makes writing the whole program 
		// a little easier
	} 
}
```

* Test your classes using the CardTest.java class

```java
import static java.lang.System.*; 
import java.awt.Color;

public class CardTestOne
{
	public static void main( String args[] ) {
	        Card one = new BlackJackCard("1","DIAMONDS"); 
	        out.println(one);
	        Card two = new BlackJackCard("4","CLUBS"); 
	        out.println(two);
	        Card three = new BlackJackCard("Q","SPADES"); 
	        out.println(three);
	        Card four = new BlackJackCard("Q","HEARTS"); 
	        out.println(four);
	        Card five = new BlackJackCard("9","SPADES"); 
	        out.println(five);
	        Card six = new BlackJackCard("K", "DIAMONDS");
	        out.println(six);
	        out.println(one.equals(two)); 
	        out.println(one.equals(one)); 
	        out.println(four.equals(five)); 
	        out.println(three.equals(four));
	        out.println(five.equals(six));	}

	} 
}
```
* Predicted Output

```
[1, DIAMONDS]
[4, CLUBS]
[Q, SPADES]
[Q, HEARTS]
[9, SPADES]
[K, DIAMONDS]
false
true
false
true
false
```
