package com.huaxia.danceticket;

import java.util.Queue;

public class BinaryTree {
	Node<Student> root;

	private Node<Student> addRecursive(Node<Student> current, Student s) {
		if (current == null) { // first time add root, or null node
			return new Node<Student>(s); // terminate recursive call
		}

		if (s.compareTo(current.student) < 0) {
			current.left = addRecursive(current.left, s);
		} else if (s.compareTo(current.student) > 0) {
			current.right = addRecursive(current.right, s);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(Student student) {
		root = addRecursive(root, student);
	}

	public void insert(Node<Student> current, Student student) {
		if (current == null) {
			root = new Node<Student>(student);
			return;
		}
		Queue<Node<Student>> queue = new java.util.LinkedList<Node<Student>>();
		queue.add(current);
		int id = student.getId();
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (id < current.student.getId()) {
				if (current.left == null) {
					current.left = new Node<Student>(student);
					break;
				} else {
					queue.add(current.left);
				}
			}else{
				if (current.right == null) {
					current.right = new Node<Student>(student);
					break;
				} else {
					queue.add(current.right);
				}
			}
		}
	}

	private Node<Student> deleteRecursive(Node<Student> current, Student value) {
		if (current == null) {
			return null;
		}

		if (value.equals(current.student)) {
			// no children
			if (current.left == null && current.right == null) {
				return null;
			}
			// has one child
			if (current.right == null) {
				return current.left;
			}
			if (current.left == null) {
				return current.right;
			}
			// has two children
			Student smallestValue = findSmallestValue(current.right);
			current.student = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value.compareTo(current.student) < 0) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	public void remove(Student value) {
		root = deleteRecursive(root, value);
	}

	private Student findSmallestValue(Node<Student> current) {
		return current.left == null ? current.student : findSmallestValue(current.left);
	}

	private boolean containsNodeRecursive(Node<Student> current, Student value) {
		if (current == null) {
			return false;
		}
		if (value.equals(current.student)) {
			return true;
		}
		return value.compareTo(current.student) < 0 ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean contains(Student value) {
		return containsNodeRecursive(root, value);
	}

	public void traverseInOrder(Node<Student> node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.student);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(Node<Student> node) {
		if (node != null) {
			System.out.print(" " + node.student);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traversePostOrder(Node<Student> node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.student);
		}
	}

	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}
		Queue<Node<Student>> nodes = new java.util.LinkedList<Node<Student>>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			Node<Student> node = nodes.remove();
			System.out.print(" " + node.student);
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	/**
	 * Gets the size of the current binary tree.
	 */
	public int size() {
		return (size(root));
	}

	/**
	 * Gets the size of the given branch
	 * 
	 * @param node The branch to count from.
	 */
	private int size(Node<Student> node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	public Student find(int id) {
		return findNodeRecursive(Student.students.root, id);
	}

	public Student findNodeRecursive(Node<Student> current, int id) {
		if (current == null) {
			return null;
		}
		if (id == current.student.getId()) {
			return current.student;
		}
		return id < current.student.getId() ? findNodeRecursive(current.left, id)
				: findNodeRecursive(current.right, id);

	}
}
