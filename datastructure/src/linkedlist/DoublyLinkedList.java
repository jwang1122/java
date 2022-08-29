package linkedlist;

public class DoublyLinkedList<T> {
	private Node<T> head; //
	private Node<T> tail; 
	
	public static void main(String[] args) {
		Node<Person> node = new Node<Person>(new Teacher("John"));
		DoublyLinkedList<Person> list = new DoublyLinkedList<>();
		list.add(node);
		node = new Node<Person>(new Teacher("Rodney"));
		list.add(node);
		Node<Person> node1 = new Node<Person>(new Teacher("Bob"));
		list.add(node1);
		
		list.insert(node, new Node<Person>(new Teacher("Charles"))); // John, Charles, Rodney
		
		list.add(2, new Node<Person>(new Teacher("Alex")));
		
		System.out.println(list);		
	}

	public void add(Node<T> node) {
		if(head==null) {
			this.head = node;
			this.tail = node;
		}else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
			tail.setNext(null);
		}
	}

	public void add(int index, Node<T> node) {
		Node<T> current = head;
		for (int i=0; i<index; i++) {
			if (current==null) {
				throw new IndexOutOfBoundsException();
			}
			current = current.getNext();
		}
		insert(current, node);
	}
	
	public Node<T> privous(Node<T> node) {
		return node.getPrev();
	}
	
	public Node<T> next(Node<T> node) {
		return node.getNext();
	}
	
	public void insert(Node<T> node, Node<T> newNode) { 
		// insert newNode after node
//		newNode.setNext(node.getNext());
//		node.setNext(newNode);
//		newNode.setPrev(node);
//		newNode.getNext().setPrev(newNode);
		
		// insert newNode before node
		newNode.setPrev(node.getPrev()); // reset newNode prev first
		node.getPrev().setNext(newNode);
		node.setPrev(newNode);
		newNode.setNext(node);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(); // StringBuilder()
		Node<T> current = head;
		while (current.getNext()!=null) {
			result.append(current.getData());
			current = current.getNext(); // feature of linked list 
		}
		result.append(current.getData());
		return result.toString();
	}

}
