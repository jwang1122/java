# Blackjack Card Game by Java

[Blackjack Rules](https://casinorange.com/how-to/how-to-play-blackjack#)

![Card Values](images/Blackjack-values.png)

![Classes Relationship](images/BlackJackClasses.png)

* [Black Jack Rules](https://bicyclecards.com/how-to-play/blackjack/)
1. Object of the game: 
>beat the dealer by getting a count as close to 21 as possible, without going over 21
2. Card Values 
>ace is worth 1 or 11, J,Q,K are 10, other card is its pip value
3. Betting
>for simplicity, we don't bet.
4. Shuffle and cut
>the dealer shuffles the pack of card, no need player cut
5. Deal
>dealer gives one card face up to each player, and one card face up for himself. Another round of cards is then dealt face up to each player, but the dealer takes the second card face down.
6. Naturals
>If a player's first two cards are an ace and a "ten-card" (a picture card or 10), giving a count of 21 in two cards, this is a natural or "blackjack." If any player has a natural and the dealer does not, the dealer lose.  If the dealer has a natural, other doesn't, dealer win. If both dealer and player have natural, no body wins.
7. The Play
>any player on his turn must decide whether to "stand" (not ask for another card) or "hit" (ask for another card in an attempt to get closer to a count of 21, or even hit 21 exactly). Thus, a player may stand on the two cards originally dealt to them, or they may ask the dealer for additional cards, one at a time, until deciding to stand on the total (if it is 21 or under), or goes "bust" (if it is over 21). In the latter case, play loses the game. The dealer then turns to the next player and serves them in the same manner. The combination of an ace with a card other than a ten-card is known as a "soft hand," because the player can count the ace as a 1 or 11, and either draw cards or not. For example with a "soft 17" (an ace and a 6), the total is 7 or 17. While a count of 17 is a good hand, the player may wish to draw for a higher total. If the draw creates a bust hand by counting the ace as an 11, the player simply counts the ace as a 1 and continues playing by standing or "hitting" (asking the dealer for additional cards, one at a time).
8. The Dealer's Play
>When the dealer has served every player, the dealers face-down card is turned up. If the total is 17 or more, it must stand. If the total is 16 or under, they must take a card. The dealer must continue to take cards until the total is 17 or more, at which point the dealer must stand. If the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21), the dealer must count the ace as 11 and stand. The dealer's decisions, then, are automatic on all plays, whereas the player always has the option of taking one or more cards.
9. No Splitting Pairs
10. No Doubing Down
11. No Insurance
12. Reshuffling when start new game.


### Object relationship
  
```mermaid
classDiagram
class Card {
  face:str
  suit:str
  getValue()
}

class BlackjackCard{
  getValue()
}

class Deck{
  topCardIndex:int
  stackOfCards:BlackjackCard
  shuffle()
  getCard()
  nextCard()
}

class Player{
  name:str
  hand:[]
  win:int
  addCardToHand()
  cleanHand()
  getHandValue()
  getHandSize()
  hit()
  showHand()
}

class Dealer {
  deck:Deck
  shuffle()
  deal()
  hit()
  showHand()
}

class Game{
  playerList:ArrayList<Player>
  dealer:Dealer
  determineWinner()
  play()
}

Player<|--Dealer:dealer is player
Dealer *--Deck:dealer own the deck
Card<|--BlackjackCard
Deck o--BlackjackCard:stack of Cards
Game *-- Dealer
Game *-- Player
```
### Game logic
```mermaid
graph TB
A([start])
B[Deal cards]
C[Show hands]
D{hit?}
F[determine winner<br>show result]
END[end]
AGAIN{more game?}
S[Shuffule, clean hand]

A-->B-->C-->D
D--true-->B
D--false-->F-->AGAIN
AGAIN--false-->END
AGAIN--true-->S-->B

classDef start fill:green,stroke:#DE9E1F,stroke-width:2px,color:white;
classDef end1 fill:red,stroke:#DE9E1F,stroke-width:2px,color:white;
classDef if fill:#EBCD6F,stroke:black,stroke-width:2px;

class A start
class END end1
class D,AGAIN if
```
### Code Optimization
```mermaid
graph TB
START([start])
PLAYER[player win]
DEALER[dealer win]
TIED[tied]

A{player>21}
C{dealer>21}
D{player==dealer}
E{player>dealer}

START-->A
A--false-->C
A--true-->DEALER
C--true-->PLAYER
C--false-->
D--true-->TIED
D--false-->E
E--true-->PLAYER
E--false-->DEALER

classDef if fill:#EBCD6F,stroke:black,stroke-width:2px;

class A,D,C,E if
```

* player get 4 Ace
* player get 3 Ace
* player get 2 Ace
* player get 1 Ace busted
* player get 1 Ace not busted
  
* [Face.java](../john/src/com/john/blackjack/Face.java)
* [Suit.java](../john/src/com/john/blackjack/Suit.java)
* [Card.java](../huaxia/src/blackjack/Card.java)
* [Deck.java](../huaxia/src/blackjack/Deck.java)
* [Player.java](../huaxia/src/blackjack/Player.java)
* [Dealer.java](../huaxia/src/blackjack/Dealer.java)
* [Game.java](../huaxia/src/blackjack/Game.java)


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