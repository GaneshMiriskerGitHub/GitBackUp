package packagee10_LinkedList;

public class DLL {
	
	static class Node {
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	public static void addFirst(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = tail =newNode;
			size++;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		size++;
	}
	
	public static void printDLL(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+ " <->");
			temp = temp.next;
		}
	}
	
	public static int removeFirst() {
		if(head == null) {
			size = 0;
			return 0;
		}else if(size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}else {
			int val = head.data;
			head = head.next;
			head.prev = null;
			size--;
			return val;
		}
	}
	
	public static void reverseDLL() {
		Node curr = head;
		Node prev = null;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public static void main(String[] args) {
		
		DLL list = new DLL();
		
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);
//		list.removeFirst();
		list.reverseDLL();
		printDLL(head);
		
	}

}
