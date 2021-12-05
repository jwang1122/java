package com.huaxia.datastructure;

import java.util.Queue;

public class BinaryTree {
	BinaryNode root;

	public static void main(String[] args) {
		BinaryTree tree = createBinaryTree();
		tree.traverseInOrder(tree.root);
		System.out.println();
		tree.traversePreOrder(tree.root);
		System.out.println();
		tree.traversePostOrder(tree.root);
		System.out.println();
		tree.traverseLevelOrder();
		System.out.println();
		System.out.println(tree.containsNode(5));
		System.out.println(tree.containsNode(2));
		System.out.println(tree.findSmallestValue(tree.root));
	}

	private BinaryNode addRecursive(BinaryNode current, int value) {
		if (current == null) {
			return new BinaryNode(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	public static BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		return bt;
	}

	private BinaryNode deleteRecursive(BinaryNode current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
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
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	private int findSmallestValue(BinaryNode root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	private boolean containsNodeRecursive(BinaryNode current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	public void traverseInOrder(BinaryNode node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(BinaryNode node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traversePostOrder(BinaryNode node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}

	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}

		Queue<BinaryNode> nodes = new java.util.LinkedList<BinaryNode>();
		nodes.add(root);

		while (!nodes.isEmpty()) {

			BinaryNode node = nodes.remove();

			System.out.print(" " + node.value);

			if (node.left != null) {
				nodes.add(node.left);
			}

			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
}
