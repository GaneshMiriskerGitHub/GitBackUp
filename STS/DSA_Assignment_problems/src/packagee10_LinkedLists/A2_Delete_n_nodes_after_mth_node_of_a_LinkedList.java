package packagee10_LinkedLists;


public class A2_Delete_n_nodes_after_mth_node_of_a_LinkedList {
	
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
	
	public static void delete(int n, int m) { // delete n nodes after mth node
		Node temp = head;
		int i=0;
		while(i<m-1) {
			temp = temp.next;
			i++;
		}
		
		Node temp2 = temp;
		for(int j=1;j<=n+1;j++) {
			temp2 = temp2.next;
		}
		
		temp.next = temp2;
		
	}
	
	public static void main(String[] args) {
		
		A2_Delete_n_nodes_after_mth_node_of_a_LinkedList list = new A2_Delete_n_nodes_after_mth_node_of_a_LinkedList();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
		list.delete(2, 2);
		
		printLL(head);
		
	}

}
