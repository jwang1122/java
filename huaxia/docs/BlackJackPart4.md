# Black Jack Card Game - Part 3

* Involved classes:
```
Card.java 
BlackJackCard.Java 
Deck.java 
Player.java 
PlayerTest.java
DealerTest.java 
Dealer.java
```
Write the Dealer class that extends the Player class. The dealer will always hit if the hand value is less than or equal to 16. Use all the previous classes you have written.
The Dealer Class will be

```
//define Dealer class here 
//instance variable - Deck
//constructors 
//method to shuffle 
//method to deal a card 
//hit method goes here
```

The DealerTest Class will be

```java
import static java.lang.System.*; import java.io.*;
public class DealerTestOne {
public static void main( String args[] ) {
//Code to test the Dealer Dealer dealer = new Dealer(); Player player = new Player();
dealer.shuffle();
player.addCardToHand(dealer.deal()); dealer.addCardToHand(dealer.deal()); player.addCardToHand(dealer.deal()); dealer.addCardToHand(dealer.deal());
int playerTotal = player.getHandValue(); int dealerTotal = dealer.getHandValue();
out.println("PLAYER ");
out.println("Hand Value :: " + playerTotal ); out.println("Hand Size :: " + player.getHandSize() ); out.println("Cards in Hand :: " + player.toString() ); out.println("\nDEALER ");
out.println("Hand Value :: " + dealerTotal ); out.println("Hand Size :: " + dealer.getHandSize() ); out.println("Cards in Hand :: " + dealer.toString() );
if(playerTotal>21&&dealerTotal<=21) {
out.println("\nDealer wins - Player busted!"); }
else if(playerTotal<=21&&dealerTotal>21) {
out.println("\nPlayer wins - Dealer busted!"); }
else if(playerTotal>21&&dealerTotal>21){ out.println("Both players bust!");
}
else if(playerTotal<dealerTotal){
out.println("\nDealer has bigger hand value!"); }
else{
out.println("\nPlayer has bigger hand value!");
} }
}
```
