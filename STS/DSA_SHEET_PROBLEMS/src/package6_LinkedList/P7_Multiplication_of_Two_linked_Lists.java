package package6_LinkedList;

import package6_LinkedList.P6_Sort_the_LinkedList_with_0s_1s_2s.Node;

public class P7_Multiplication_of_Two_linked_Lists { // worked here but failed to pass the testcases over gfg platform
	
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
	
	public static long multiplyTwoLists(Node list1, Node list2) {
		
		StringBuilder s1 = new StringBuilder("");
		Node temp1 = list1;
		while(temp1 != null) {
			s1.append(temp1.data);
			temp1 = temp1.next;
		}
		
		StringBuilder s2 = new StringBuilder("");
		Node temp2 = list2;
		while(temp2 != null) {
			s2.append(temp2.data);
			temp2 = temp2.next;
		}
		
		return Long.parseLong(s1.toString()) * Long.parseLong(s2.toString());
	}
	
	// another appraoch
	public static long multiplyLL(Node list1, Node list2) {
		long num1 = 0;
		long num2 = 0;
		
		while(list1 != null) {
			num1 = num1*10 + (list1.data);
			list1 = list1.next;
		}
		
		while(list2 != null) {
			num2 = num2*10 + (list2.data);
			list2 = list2.next;
		}
		
		return num1*num2;
	}

	public static void main(String[] args) {
		
		Node first = new Node(9);
        first.next = new Node(4);
        first.next.next = new Node(6);
        System.out.print("First List is: ");
        printLL(first);
  
        // create second list 8->4
        Node second = new Node(8);
        second.next = new Node(4);
        System.out.print("Second List is: ");
        printLL(second);
  
        // Multiply the two lists and see result
        System.out.print("Result is: ");
        System.out.println(multiplyTwoLists(first, second));

	}

}
