package packagee10_LinkedLists;

import packagee10_LinkedLists.A2_Delete_n_nodes_after_mth_node_of_a_LinkedList.Node;

public class A3_Swapping_nodes_in_a_LinkedList {
	
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
	
	public static void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	public static void printLL(Node head) {
		if(head == null) {
			System.out.println("Linked List is empty");
		}
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
	}
	
	public static void swap(int n, int m) {
		
		Node temp1 = head;
		for(int i=0;i<n;i++) {
			temp1 = temp1.next;
		}
		
		Node temp2 = head;
		for(int i=0;i<m;i++) {
			temp2 = temp2.next;
		}
		
		
		int temp1Data = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp1Data;
		
	}

	public static void main(String[] args) {
		
		A3_Swapping_nodes_in_a_LinkedList list = new A3_Swapping_nodes_in_a_LinkedList();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
		printLL(head);
		
		list.swap(2, 3);System.out.println();
		
		printLL(head);

	}

}
