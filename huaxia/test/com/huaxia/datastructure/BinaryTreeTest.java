package com.huaxia.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

	BinaryTree tree;
	@BeforeEach
	void setUp() throws Exception {
		tree = BinaryTree.createBinaryTree();
	}

	@Test
	void testContains() {
		assertTrue(tree.containsNode(6));
	    assertTrue(tree.containsNode(4));
	 
	    assertFalse(tree.containsNode(1));
	}

	@Test
	void testDelete() {
		assertTrue(tree.containsNode(9));
		tree.delete(9);
		assertFalse(tree.containsNode(9));
	}
}
