package package6_LinkedList;

public class P1_Reverse_a_LinkedList {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			Node next = null;
		}
	}
	
	public static void reverse(Node head) {
		
		Node curr = head;
		Node prev = null;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
