# Black Jack Card Game - Part 3

* Involved classes:
```
Card.java 
BlackJackCard.Java 
Deck.java 
Player.java 
PlayerTest.java
```

* Write a Player Class that has the following methods in it:

```java
public void addCardToHand( Card temp ) 
public void resetHand()
public boolean hit()
public void setWinCount( int numWins ) 
public int getWinCount()
public int getHandSize() 
public int getHandValue()
```
The Player class should have an ArrayList to hold the Cards in the player’s hand and an int to store the winCount. You should also have the following toString method:

```java
public String toString() {
	return "hand = " + hand.toString() + " - # wins " + winCount; 
}
```
For the hit method, the player will always hit when the hand value is less than or equal to 10 and will always not hit when the hand value is more than or equal to 20. Otherwise, there is a 50/50 chance for the Player to hit.
* Use the PlayerTest class to test what you wrote

```java
import static java.lang.System.*; 
import java.io.*;

public class PlayerTest {
	public static void main( String args[] ) {
		Player player = new Player(); Deck deck = new Deck();
		deck.shuffle(); player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard()); out.println("toString");
		out.println(player); out.println("handValue");
		out.println(player.getHandValue());
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());
		out.println("toString"); 
		out.println(player);
		out.println("handValue"); 
		out.println(player.getHandValue());
		out.println(player.hit());
	} 
}
```

Remember that you should use your already written Card, BlackJackCard, and Deck class.

* SAMPLE OUTPUT

```
toString
hand=[THREEofDIAMONDS|value=3,FOURofCLUBS|value=4]- #wins0 handValue
7
toString
hand = [THREE of DIAMONDS | value = 3, FOUR of CLUBS | value = 4, SEVEN of SPADES | value=7,NINEofCLUBS|value=9]- #wins0
handValue
23
false
hand = [TWO of DIAMONDS | value = 2, TWO of CLUBS | value=4,JACKofSPADES|value=10]- #wins0
Do you want to hit?(Y or N)false
hand = [TWO of DIAMONDS | value = 2, TWO of CLUBS | value=4,JACKofSPADES|value=10]- #wins0
Do you want to hit?(Y or N)true
hand = [TWO of DIAMONDS | value = 2, TWO of CLUBS | value=4,JACKofSPADES|value=10]- #wins0
Do you want to hit?(Y or N)false
hand = [TWO of DIAMONDS | value = 2, TWO of CLUBS | value=4,JACKofSPADES|value=10]- #wins0
Do you want to hit?(Y or N)true
```