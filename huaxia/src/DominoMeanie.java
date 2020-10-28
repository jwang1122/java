import java.util.*;

public class DominoMeanie {

	public static void main(String[] args) {

		System.out.println("Enter in the number of players:");
		Scanner input = new Scanner(System.in);
		int playerNum = input.nextInt();
		input.nextLine();
		System.out.println("Enter in the max pip size:");
		int max = input.nextInt();
		input.nextLine();
		System.out.println("Enter in the random seed value:");
		int randSeed = input.nextInt();
		input.nextLine();
		System.out.printf("%d players, max pip size: %d, and Random seed: %d.\n", playerNum, max, randSeed);
		DominoSet s = new DominoSet(max);
		ArrayList<Domino> deck = s.shuffle(randSeed);
		Player[] players = new Player[playerNum];
		for(int i=0; i<playerNum; i++) {
			players[i] = new Player("Player " + i);
		}
		System.out.println("Total Dominoes in deck: " + deck.size());
		for(int i=0; i<deck.size(); i++) {
			if(i<max+1) {
				players[0].addDominoToHand(deck.get(i));
			}else if(i<2*max+1) {
				players[1].addDominoToHand(deck.get(i));
			}else {
				players[2].addDominoToHand(deck.get(i));
			}
		}
//		ArrayList<Domino> set1 = new ArrayList<Domino>();
//		Set<Domino> hand = new TreeSet<Domino>();
//		ListIterator<Domino> itr = deck.listIterator();
//		if (deck.size() / playerNum == 0) {
//			for (int i = 0; i < deck.size() / playerNum; i++)
//
//				set1.add(deck.get(i));
//
//		} else {
//			for (int i = 0; i <= deck.size() / playerNum; i++)
//				set1.add(deck.get(i));
//
//		}
		System.out.println("Player 1 hand: " + players[0].getHand());
		System.out.println("Player 2 number of dominoes: " + players[1].getHand().size());
		System.out.println("Player 3 number of dominoes: " + players[2].getHand().size());

		// randNum = new Random(randSeed);
		input.close();
	}

}

class Player{
	ArrayList<Domino> hand = new ArrayList<>();
	String name;
	
	public Player(String name) {
		this.name = name;
	}
			
	public void addDominoToHand(Domino domino) {
		hand.add(domino);
	}
	
	public Domino removeDominoFromHand() {
		if(hand.size()>0) {
			return hand.get(0);
		}
		return null;
	}
	
	public ArrayList<Domino> getHand(){
		return hand;
	}
}
