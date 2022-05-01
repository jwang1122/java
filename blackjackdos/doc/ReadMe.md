<h1>Blackjack Console Game</h1>


## Requirement documents

[Part 1]("Black Jack Part 1 -- The Card.compressed.pdf")

## Start the game

run Game.java


## Sample output

```dos
Add player? (y/n) y
Enter player name: 
John
Add player? (y/n) y
Enter player name: 
David
Add player? (y/n) n
[John, David]
John{[8, DIAMONDS] [Q, SPADES] }:18:0
David{[Q, CLUBS] [2, CLUBS] }:12:0
Dealer{[K, SPADES] HIDDEN}
John, do you want to hit? (y/n) n
David, do you want to hit? (y/n) y
David{[Q, CLUBS] [2, CLUBS] [10, HEARTS] }:22:0
David, do you want to hit? (y/n) n
John{[8, DIAMONDS] [Q, SPADES] }:18:0
David{[Q, CLUBS] [2, CLUBS] [10, HEARTS] }:22:0
Dealer{[K, SPADES] [J, SPADES] }:20:0

John{[8, DIAMONDS] [Q, SPADES] }:18:0
David{[Q, CLUBS] [2, CLUBS] [10, HEARTS] }:22:0
Dealer{[K, SPADES] [J, SPADES] }:20:2
More game? (y/n) n
Game Over!
```