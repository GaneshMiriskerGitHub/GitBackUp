package package6_LinkedList;


public class PP11_find_intersection {
	
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
	
	public static Node findIntersection(Node head1, Node head2) {
		while(head2 != null) {
			Node temp = head1;
			while(temp != null) {
				if(temp == head2) {
					return temp;
				}
				temp = temp.next;
			}
			head2 = head2.next;
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		

	}

}
