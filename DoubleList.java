import static java.lang.System.*;

import java.util.LinkedList;

public class DoubleList {
	private DoubleNode front, back;
	private int size;
 
	public DoubleList() {
		front = back = null;
		size = 0;
	}

	// ADDS NEW NODE TO THE BACK OF THE LIST FOR WORD IF IT DOES NOT EXIST.
	// IF IT EXISTS, IT BUMPS UP WORD'S COUNT BY ONE
	public void add(String word) {
		 DoubleNode newNode=new DoubleNode(word,1,null,null);
		 back=front;
	//	 newNode.getNext()=null;
		if(front == null){
			front = newNode;
			back=newNode;
			/* 
			DoubleNode fp=front.getPrev();
			fp=null;
			front.setPrev(fp);
			DoubleNode bp=back.getNext();
			bp=null;
			back.setNext(bp);
			*/
		 
		}
		DoubleNode temp = back;
		while(temp.getNext() != null){
			if(temp.getWord() == word){
				temp.setWordCount(temp.getWordCount() + 1);
				 
			}
			else
				temp = temp.getNext();
		}
		if(temp.getWord() == word)
			temp.setWordCount(temp.getWordCount() + 1);
		else
		temp.setNext(new DoubleNode(word, 1, null,null));
		 
	}

	// REMOVE ONE COUNT OF THE WORD FROM THE LIST, IF THE COUNT RESULTS IN ZERO
	// REMOVE THE WORD FROM LIST. RETURN THE NEW COUNT OF THE WORD OR ZERO
	// IF THE WORD DOES NOT EXSIST IN LIST
	/*
	 * public int remove(String word) {
	 * 
	 * }
	 * 
	 * // WILL RETURN THE WORD AT X. THE FRONT IS CONSIDERED 0. // IF X IS NEGATIVE
	 * IT WILL COUNT USING PREVIOUS // IF X IS POSITIVE IT WILL COUNT USING NEXT
	 * public String getWord(int x) {
	 * 
	 * }
	 * 
	 * // OPTIONAL PRIVATE METHOD private void removeNode(DoubleNode x, DoubleNode
	 * y, DoubleNode z) {
	 * 
	 * }
	 * 
	 * // RETURNS THE SIZE OF THE LIST public int size() { return size; }
	 * 
	 * // RETURNS IF THE LIST CONTAINS THE WORD IN IT //public boolean
	 * contains(String word) {
	 * 
	 * // }
	 */
	
	 public void printNodes() {  
	       
	        DoubleNode current = front;  
	        
	        while(current != null) {  
	            
	            System.out.print(current.getWord() + " ->"+current.getWordCount());  
	            current = current.getNext();  
	        }  
	      
	}
	// RETURNS THE LIST AS A BIG STRING
	public String toString() {
		String str = "";

		return str;
	}
}