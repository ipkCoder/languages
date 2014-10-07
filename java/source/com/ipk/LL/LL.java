package com.ipk.LL;

public class LL {

	private Node head;
	private Node rear;
	private int count;

	public LL() {
		head = rear = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public int get(int idx) {
		Node tmp = head;
		for (int i = 0; i < idx; ++i) {
			tmp = tmp.getNext();
		}
		return tmp.getElem();
	}

	public void set(int idx, int value) {
		Node tmp = head; 
		for (int i = 0; i < idx; ++i) {
			tmp = tmp.getNext();
		}
		tmp.setElem(value);
	}

	public void addToFront(int value) {
		if (head == null) {
			head = new Node(value);
			rear = head;
			
		} else {
			Node tmp = new Node(value);
			tmp.setNext(head);
			head = tmp;
		}
		++count;
	}

	public void append(int value) {
		if (head == null) {
			addToFront(value);
		} else {
			rear.setNext(new Node(value));
			rear = rear.getNext();
			++count;
		}
	}

	public void insert(int idx, int value) {

		assert (idx >= 0 && idx <= count) : "index value of " + idx + " is out of range";

		if (idx == 0) {
			addToFront(value);
		} else if (idx == count) {
			append(value);
		} else {
			Node tmp = head;
			for (int i = 0; i < (idx-1); ++i) {
				tmp = tmp.getNext();
			}
			Node new_node = new Node(value);
			new_node.setNext(tmp.getNext());
			tmp.setNext(new_node);
			++count;
		}
	}

	public void unshift() {
		if (head != null) {
			// int val = head.getElem();
			if (head.getNext() == null) {
				head = rear = null;
			} else {
				head = head.getNext();
			}
			--count;
		}
	}

	public void pop() {
		if (head != null) {
			// int val = rear.getElem();
			if (head.getNext() == null) {
				head = rear = null;
			} else {
				Node tmp = head;
				while (tmp.getNext() != rear) {
					tmp = tmp.getNext();
				}
				rear = tmp;
				rear.setNext(null);
			}
			--count;
		}
	}

	public void remove(int idx) {
		
		assert (idx >= 0 && idx < count) : "index value of " + idx + " is out of range";

		if (idx == 0) {
			unshift();
		} else if (idx == count-1) {
			pop();
		} else {
			Node tmp = head;
			for (int i = 0; i < (idx-1); ++i) {
				tmp = tmp.getNext();
			}
			tmp.setNext(tmp.getNext().getNext());
			--count;
		}
	}
	
    public void print() {
		Node tmp = head;
		while (tmp != null) {
			System.out.printf("%d ", tmp.getElem());
            tmp = tmp.getNext();
		}
		System.out.println(" count = " + count);
		// info();
	}
    
    public void info() {
        System.out.println(head.getElem());
        System.out.println(rear.getElem());
    }
	
    public static void main(String[] args) {
		LL list = new LL();
		list.addToFront(1);
        list.addToFront(2);
		list.addToFront(3);
		list.append(4);
		list.append(5);
		list.print();
		list.unshift();
		list.print();
		list.pop();
		list.print();
		list.pop();
		list.print();
		list.insert(1, 3);
		list.insert(0, 1);
		list.insert(4, 5);
		list.print();
		// list.insert(9, 0); // test assert
		list.print();
		list.set(3, 4);
		list.print();
		System.out.println(list.get(2));
		list.remove(2);
		list.remove(0);
		list.remove(2);
		list.print();
	}
}
