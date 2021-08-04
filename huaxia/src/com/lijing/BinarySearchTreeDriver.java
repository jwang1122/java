import java.util.*;
import static java.lang.System.*;
import java.io.*;


public class BinarySearchTreeDriver {
	
	public static void main(String[] args)  throws Exception{
		Scanner input = new Scanner(new File("BinarySearchTree.txt"));

		BinarySearchTree tree = new BinarySearchTree();
		int numLines = input.nextInt();
		input.nextLine();
		for (int i = 0; i < numLines; i++) {
			String[] list = input.nextLine().split(" ");
			for (String k : list) {
				BinaryNode temp = new BinaryNode(k);
				tree.add(temp);
			}
		}

		// System.out.println("Tree-->" +tree);

		// tree.preOrder();

		// System.out.println("POST ORDER\n"+tree.postOrder());
//		System.out.println("IN ORDER\n");
//		tree.inOrder();
		/*
		System.out.println("REVERSE ORDER\n"+tree.reverseOrder());
		System.out.println("Number of leaves: "+tree.getNumLeaves());
		System.out.println("Number of levels: "+tree.getNumLevels());
		System.out.println("The Tree width: "+tree.getWidth());
		System.out.println("The Tree height: "+tree.getHeight());
		System.out.println("Number of nodes: "+tree.getNumNodes()); if(tree.isFull())
		out.println("Tree is full"); else out.println("Tree is not full.");
		
		numLines = input.nextInt(); for(int i=0; i<numLines; i++) { String x =
		input.next(); if(tree.contains(x)) out.println("Tree contains "+x); else
		out.println("Tree does not contain "+x); }
		
		out.println("Largest value: "+tree.getLargest());
		out.println("Smallest value: "+tree.getSmallest());
		out.println("Level order: "+tree.levelOrder());
		
		numLines = input.nextInt(); for(int i=0; i<numLines; i++) { String x =
		input.next(); BinaryNode k = tree.remove(x); if(k!=null) {
		out.println("Level Order Tree after removing: "+k);
		out.println("Level order: "+tree.levelOrder()); } else
		out.println("Cannot remove "+x+" from tree"); }
		
		out.println("Proper Tree Display"); tree.printFullTree(tree.fullLevelOrder(), Math.min(tree.getNumLevels(),6)); 
		*/
	}

}
