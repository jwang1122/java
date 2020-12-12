# Blackjack Card Game by Java

[Blackjack Rules](https://casinorange.com/how-to/how-to-play-blackjack#)

![Card Values](Blackjack-values.png)

![Classes Relationship](BlackJackClasses.png)

## Card
```java
public class Card {
	enum Faces {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	enum Suits {SPADE, CLUB, DIAMOND, HEART};
    
    Faces face;
    Suits suit;

    Card(Face face, Suit suit){
        ... ...
    }

    int getValue(){
        ... ...
    }

    public String toString(){
        return face + " of " + suit + getValue();
    }
```
## BlackJackCard
```java
public class BlackJackCard extends Card
{
 //constructors

 public int getValue()
 {
 //enables you to build the value for the game into
 //the card. This makes writing the whole program
 // a little easier
 }
}
```