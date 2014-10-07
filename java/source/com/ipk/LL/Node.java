package com.ipk.LL;

public class Node {
	private int elem;
	private Node next;
	public Node(int value) {
		elem = value;
		next = null;
	}
	public void setNext(Node next_node) {
		next = next_node;
	}
	public Node getNext() {
		return next;
	}
	public int getElem() {
		return elem;
	}

	public void setElem(int val) {
		elem = val;
	}
}
