package com.lijing;

public class BinaryNode implements Comparable {

	private BinaryNode left;
	private BinaryNode right;
	private String data;

	public BinaryNode() {
		left = null;
		right = null;
		data = "";

	}

	public BinaryNode(String s) {
		left = null;
		right = null;
		data = s;
	}

	public String getValue() {
		return data;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setValue(String value) {
		this.data += value;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public String toString() {
		return data;
	}

	@Override
	public int compareTo(Object o) {
		BinaryNode tmp = (BinaryNode)o;
		return this.data.compareTo(tmp.getValue());
	}

}
