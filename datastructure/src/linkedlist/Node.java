package linkedlist;

public class Node<T> { // generics data type
	private Node<T> prev;
	private T data; // data
	private Node<T> next; // link==node refernce to next node, pointer(refrence)
	
	public Node(T type) {
		data = type;
		next = null;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}
