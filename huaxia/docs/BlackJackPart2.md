# Black Jack Card Game - Part 2
* Involved classes:

```
Card.java
BlackJackCard.java
Deck.java
DeckTest.java
```

* Finishi the Deck class:

```java
public class Deck
{
	public static final String FACES[] = {"A", "2", "3","4", "5", "6", "7", "8", "9", "10", "J","Q", "K"}; 
	public static final String SUITS[] = {"HEARTS", "DIAMONDS", "SPADES", "CLUBS"};
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;
	private int topCardIndex;
	private ArrayList<Card> stackOfCards;
   
   	// constructor
   public Deck()
   {
     //initialize the data
     //one loop to go through all SUITS
        //one loop to go through all FACES
       //add in each new Card() to the Deck
   }
	public int size() { return 0; }
   	public int numCardsLeft(){
      	return 0;
	}
	public void shuffle(){
	//add code to shuffle deck – Collections has a shuffle
	}
	public Card nextCard(){ 
		return stackOfCards.get(topCardIndex--); 
	}
	public String toString(){
		return stackOfCards + " topCardIndex = " + topCardIndex;
	} 
}
```
* NExt, Use DeckTest.java class to test the Deck class' functionality

```java
import static java.lang.System.*; 
public class DeckTestOne
{
	public static void main( String args[] ) {
		Deck deck = new Deck();
		for( int i=0; i<Deck.NUMCARDS; i++ ) {
			out.println(deck.nextCard()); 
		}
		out.println("\n\n");
		out.println("num cards left in the deck == " + deck.numCardsLeft());
		out.println("\n\nshuffling...");
		deck.shuffle();
		out.println("num cards left in the deck == " + deck.numCardsLeft()); 
		out.println("\n\ntoString");
		out.println(deck);
	}
}
```

* Predicted Output, maybe different because of the randomization

```

```
