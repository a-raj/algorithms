package data_structures;

public class LinkedListImpl {
	
	private int size = 0;
	Node head = null;
	
	
	/**
	 * Push in front
	 * */
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	/**
	 * Return true if successfully added else false
	 * */
	public boolean insertAfter(int key, int data) {
		
		Node current = head;
		
		while(current.next != null && current.data != key) {
			current = current.next;
		}
	
		if (current.data == key) {
			Node newNode = new Node(data);
			newNode.next = current.next;
			current.next = newNode;
			size++;
			return true;
		}
		return false;
	}
	
	public void append(int data) {
		
		if (head == null) { 
			Node node = new Node(data);
			head = node;
			size++;
			return;
		}
		Node last = head;
		while (last.next != null)
			last = last.next;
		
		last.next = new Node(data);
		size++;
	}
	
	public boolean deleteNode(int key) {
		Node temp = head;
		Node previous = null;
		
		//if key is head
		if (temp.next != null && temp.data == key) {
			head = temp.next;
			return true;
		}

		// iterate until the end or key matches
		while(temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}
		
		if (temp == null) {
			return false;
		}

		// temp has the key
		previous.next = temp.next;
		return true;
		
	}
	
	public int getSize() {
		return this.size;
	}
	
}
