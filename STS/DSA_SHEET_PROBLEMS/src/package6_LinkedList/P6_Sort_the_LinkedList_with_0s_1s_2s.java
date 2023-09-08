package package6_LinkedList;

public class P6_Sort_the_LinkedList_with_0s_1s_2s {

	static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static Node head;
	public static Node tail;
	public static int size;

	public static void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}

	public static void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public static void printLL(Node head) {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static void printLL() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static void sortList() {
		
		int[] counter = new int[3];
		
		Node temp = head;
		
		while(temp != null) {
			counter[temp.data]++;
			temp = temp.next;
		}
		
		Node newHead = new Node(-1);
		Node newIterator = newHead;
		
		for(int i=0;i<counter.length;i++) {
			for(int j=0;j<counter[i];j++) {
				Node newNode = new Node(i);
				newIterator.next = newNode;
				newIterator = newIterator.next;
			}
		}
		
		head = newHead.next;
		System.out.println();
	}

	
	

	public static void main(String[] args) {

		P6_Sort_the_LinkedList_with_0s_1s_2s llist = new P6_Sort_the_LinkedList_with_0s_1s_2s();

		/*
		 * Constructed Linked List is 1->2->3->4->5->6->7-> 8->8->9->null
		 */
		llist.addLast(0);
		llist.addLast(1);
		llist.addLast(0);
		llist.addLast(2);
		llist.addLast(1);
		llist.addLast(1);
		llist.addLast(2);
		llist.addLast(1);
		llist.addLast(2);

		System.out.println("Linked List before sorting");
		llist.printLL();

		llist.sortList();
		
		System.out.println("Linked List after sorting");
		llist.printLL();

	}

}
