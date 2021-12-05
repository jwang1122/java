package com.huaxia.datastructure;

public class BinaryNode {
	int value;
	BinaryNode left;
	BinaryNode right;

	BinaryNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

	@Override
	public String toString() {
		return "BinaryNode [value=" + value + "]";
	}
	
	
}
