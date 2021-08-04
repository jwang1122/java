import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DominoSet {
	private ArrayList<Domino> setOfDominoes;
	private static ArrayList<Domino> orderedDominoes;

	public DominoSet(int max) {
		setOfDominoes = getSet(max);
	}
	
	public ArrayList<Domino> getSet(int max) {
		ArrayList<Domino> list = new ArrayList<>();
		for (int i = 0; i <= max; i++) {
			for (int j = i; j <= max; j++) {
				Domino dom = new Domino(i, j);
				list.add(dom);
			}
		}
		return list;
	}

	public ArrayList<Domino> shuffle(int randSeed) {
//		Collections.shuffle(setOfDominoes); // one line will shuffle the
											// ArrayList, no need for rotate()
		Random rand = new Random(randSeed);
		for (int i = 0; i < setOfDominoes.size(); i++) {
			if (rand.nextBoolean())
				setOfDominoes.get(i).rotate();
			int k = rand.nextInt(setOfDominoes.size());
			Domino temp = setOfDominoes.get(k);
			setOfDominoes.set(k, setOfDominoes.get(i));
			setOfDominoes.set(i, temp);
		}
		return setOfDominoes;
	}

	public ArrayList<Domino> getSetOfDominoes() {
		return setOfDominoes;
	}

	public void setSetOfDominoes(ArrayList<Domino> setOfDominoes) {
		this.setOfDominoes = setOfDominoes;
	}

	public static void main(String[] args) {
		DominoSet ds = new DominoSet(3);
		orderedDominoes = ds.getSet(3);
		List<Domino> shuffledList = ds.shuffle(26);
		List<Domino> player1Hand = new ArrayList<>();
		List<Domino> player2Hand = new ArrayList<>();
		List<Domino> player3Hand = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (i < 4) {
				player1Hand.add(shuffledList.get(i));
			}else if(i<7) {
				player2Hand.add(shuffledList.get(i));
			}else {
				player3Hand.add(shuffledList.get(i));
			}
		}
		displayList("Total Dominoes", orderedDominoes);
		displayList("After Shuffle Dominoes", ds.getSetOfDominoes());
		displayList("Player1", player1Hand);
		displayList("Player2", player2Hand);
		displayList("Player3", player3Hand);
	}
	
	private static void displayList(String player, List<Domino> list) {
		System.out.printf("%s's hand: ",player);
		for(Domino d: list) {
			System.out.print(d+",");
		}
		System.out.println();
	}
}