# Current issues found in the homework

1. The implementation of getValue() method in Card class should be

```java
public int getValue() { return face; }
```
2. Missing getter for face attribute

```java
public int getFace() {
	return face;
}
```
3. getValue() method defined in BlackJackCard.java class maybe simplified to

```java
public int getValue() {
	int face = getFace();
	if ( face == 1)
		return 11;
	if (face >= 10)
		return 10;
	return face;
}
```

4. Missing CardTestOne.java

5. The constructor in Deck.java class, should use BlackJackCard to create new card.

6. The resetHand() method should create new ArrayList<Card> for new hand.(empty hand)

```java
public void resetHand() {
	hand = new ArrayList<Card>();
}
```
7. the Dealer constructor need create a Deck instance aDeck

8. the aDeck instance need to be shuffled in the constructor