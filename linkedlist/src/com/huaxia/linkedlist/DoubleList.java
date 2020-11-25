package com.huaxia.linkedlist;

public class DoubleList {
	private DoubleNode front, back;
	int size;

	public DoubleList() {
		front = back = null;
	}

	// ADDS NEW NODE TO THE BACK OF THE LIST FOR WORD IF IT DOES NOT EXIST.
	// IF IT EXISTS, IT BUMPS UP WORD'S COUNT BY ONE
	public void add(String word) {
		DoubleNode newNode = new DoubleNode(word, 1, null, null);
		if (front == null) {
			setFirstNode(newNode);
			return;
		}
		boolean found = findSameWord(word);
		if (!found) {
			adjustLinkedList(newNode);
		}
	}

	private void setFirstNode(DoubleNode firstNode) {
		front = firstNode;
		back = firstNode;
	}

	private boolean findSameWord(String word) {
		boolean found = false;
		DoubleNode cursor = front;
		do {
			if (cursor.getWord().equals(word)) {
				cursor.setWordCount(cursor.getWordCount() + 1);
				found = true;
				break;
			}
			cursor = cursor.getNext();
		} while (cursor != null);
		return found;
	}

	private void adjustLinkedList(DoubleNode newNode) {
		newNode.setPrev(back);
		back.setNext(newNode);
		back = newNode;
	}

	// REMOVE ONE COUNT OF THE WORD FROM THE LIST, IF THE COUNT RESULTS IN ZERO
	// REMOVE THE WORD FROM LIST. RETURN THE NEW COUNT OF THE WORD OR ZERO
	// IF THE WORD DOES NOT EXSIST IN LIST

	public int remove(String word) {
		DoubleNode temp = front;
		boolean found = false;
		int result = 0;
		while (temp != null) {
			if (temp.getWord().equals(word)) {
				if (temp.getWordCount() > 1) {
					result = temp.getWordCount();
					temp.setWordCount(result - 1);
				} else {
					DoubleNode pre = temp.getPrev();
					DoubleNode next = temp.getNext();
					if (next != null)
						next.setPrev(pre);
					if (pre != null)
						pre.setNext(next);
					result = 0;
				}
				found = true;
				break;
			}
			temp = temp.getNext();
		}
		if (!found) {
			result = 0;
		}
		return result;
	}

	// WILL RETURN THE WORD AT X. THE FRONT IS CONSIDERED 0.
	// IF X IS NEGATIVE
	// IT WILL COUNT USING PREVIOUS
	// IF X IS POSITIVE IT WILL COUNT USING NEXT
	public String getWord(int x) {
		if (x < 0) {
			return traverseBackward(x);
		}
		return traverseForward(x);
	}

	private String traverseForward(int x) {
		int index = 0;
		DoubleNode cursor = front;
		while (cursor != null) {
			if (index++ == x) {
				return cursor.getWord();
			}
			cursor = cursor.getNext();
		}
		return "";
	}

	private String traverseBackward(int x) {
		int index = 0;
		DoubleNode cursor = back;
		while (cursor != null) {
			if (index-- == x) {
				return cursor.getWord();
			}
			cursor = cursor.getPrev();
		}
		return "";
	}

	// OPTIONAL PRIVATE METHOD
	void removeNode(DoubleNode x, DoubleNode y, DoubleNode z) {

	}

	// RETURNS THE SIZE OF THE LIST
	public int size() {
		DoubleNode temp = front;
		size = 0;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	// RETURNS IF THE LIST CONTAINS THE WORD IN IT //
	public boolean contains(String word) {
		DoubleNode temp = front;
		while (temp != null) {
			if (temp.getWord().equals(word)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	public void printNodes() {
		DoubleNode current = front;
		while (current != null) {
			System.out.print(current + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	// RETURNS THE LIST AS A BIG STRING
	public String toString() {
		String str = "";
		DoubleNode temp = front;
		while (temp != null) {
			str += temp.toString() + " ";
			temp = temp.getNext();
		}
		return str;
	}
}