package package6_LinkedList;

import package6_LinkedList.P1_Reverse_a_LinkedList.Node;

public class P2_LinkedList_Cycle {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			Node next = null;
		}
	}
	
	public static boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
