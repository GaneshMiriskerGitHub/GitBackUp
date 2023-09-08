package package6_LinkedList;


public class P8_Remove_nth_node_From_end {

	static class ListNode {

		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static ListNode head;
	public static ListNode tail;
	public static int size;

	public static void addFirst(int data) {
		ListNode newListNode = new ListNode(data);
		if (head == null) {
			head = tail = newListNode;
			size++;
			return;
		}
		newListNode.next = head;
		head = newListNode;
		size++;
	}

	public static void addLast(int data) {
		ListNode newListNode = new ListNode(data);
		if (head == null) {
			head = tail = newListNode;
			size++;
			return;
		}
		tail.next = newListNode;
		tail = newListNode;
		size++;
	}

	public static void printLL(ListNode head) {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static void printLL() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int sz = 0;
		ListNode temp = head;
		while (temp != null) {
			sz++;
			temp = temp.next;
		}

		if (n == sz) {
			head = head.next; // remove First
			return head;
		}
		// nth node from last == (size-n+1)th node from first
		int idx = sz - n + 1;
		ListNode prev = head;
		for (int i = 1; i < idx-1; i++) {
			prev = prev.next;
		}
		
		prev.next = prev.next.next;
		
		return head;
	}
	
	
	public static void main(String[] args) {
		
		P8_Remove_nth_node_From_end list = new P8_Remove_nth_node_From_end();
	
		list.addLast(1);
		list.addLast(2);
		
		printLL(list.removeNthFromEnd(list.head, 2));
	}

}
