## Black Jack: Part 5 – The Final Game
* Involved Classes

```
BlackJack.java 
Dealer.java 
Card.java 
BlackJackCard.Java 
Deck.java 
Player.java
```
* Write the BlackJack class which is the game itself

```java
import static java.lang.System.*;
public class BlackJack {
//add in Player instance variable //add in Dealer instance variable
public BlackJack() {
}
public void playGame() {
}
public static void main(String[] args) {
BlackJack game = new BlackJack(); game.playGame();
} }
```

* Here is an algorithm for playGame()

	- dealer shuffles the deck of cards

	 do{
		* 1st – deal the player two cards one at a time dealer deals himself two cards
		* 2nd – print out player’s hand value and cards
		* while(hand value < 21 and the player wants to hit)
		* 5. deal the player the next card
     			print out player’s hand value and cards
			if the player is over 21, the dealer wins and skip to part
		* 3rd – print out dealer’s hand value and cards while(dealer wants to hit)
		* 4th – 5th – 6th – code to add cards should be in dealer hit method
     			print out dealer’s hand value and cards
		* determine which player won
		* update the win total for the winner
		* dealer shuffles cards and players reset their hands
	}while neither person has won 3 games

* Here is a sample output

```
PLAYER
Hand value:9
Hand size:2
Cards in Handhand =
0
PLAYER
Hand value:13
Hand size:3
Cards in Handhand =
HEARTS|value=4]- #wins0
DEALER
Hand value:20
Hand size:2
Cards in Handhand = [TEN of CLUBS | value = 10, JACK of SPADES | value = 10] - # wins 0
Dealer wins
Dealer has won 1 times.
Player has won 0 times.
PLAYER
Hand value:17
Hand size:2
Cards in Handhand = [SEVEN of SPADES | value = 7, KING of HEARTS | value = 10] - # wins 0
PLAYER
Hand value:26
Hand size:3
Cards in Handhand = [SEVEN of SPADES | value = 7, KING of HEARTS | value = 10, NINE ofCLUBS|value=9]- #wins0
DEALER
Hand value:10
Hand size:2
Cards in Handhand = [THREE of CLUBS | value = 3, SEVEN of DIAMONDS | value = 7] - # wins 1
Dealer wins
Dealer has won 2 times.
Player has won 0 times.
PLAYER
Hand value:13
Hand size:2
[SIX of CLUBS | value = 6, THREE of HEARTS | value = 3] - # wins
[SIX of CLUBS | value = 6, THREE of HEARTS | value = 3, FOUR of

Cards in Handhand = [FIVE of DIAMONDS | value = 5, EIGHT of SPADES | value = 8] - # wins 0
DEALER
Hand value:14
Hand size:2
Cards in Handhand = [THREE of DIAMONDS | value = 3, ACE of DIAMONDS | value = 11] -
# wins 2
DEALER
Hand value:25
Hand size:3
Cards in Handhand = [THREE of DIAMONDS | value = 3, ACE of DIAMONDS | value = 11, ACE ofSPADES|value=11]- #wins2
Player wins
Dealer has won 2 times.
Player has won 1 times.
PLAYER
Hand value:8
Hand size:2 CardsinHandhand=[TWOofCLUBS|value=2,SIXofSPADES|value=6]- #wins1 PLAYER
Hand value:18
Hand size:3
Cards in Handhand = [TWO of CLUBS | value = 2, SIX of SPADES | value = 6, TEN of HEARTS|value=10]- #wins1
DEALER
Hand value:14
Hand size:2
Cards in Handhand = [JACK of HEARTS | value = 10, FOUR of DIAMONDS | value = 4] - # wins 2
DEALER
Hand value:19
Hand size:3
Cards in Handhand = [JACK of HEARTS | value = 10, FOUR of DIAMONDS | value = 4, FIVE ofDIAMONDS|value=5]- #wins2
Dealer wins
Dealer has won 3 times.
Player has won 1 times.
```