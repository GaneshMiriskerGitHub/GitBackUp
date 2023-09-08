package packagee10_LinkedList;

public class Circular_LinkedList {
	
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
	
	public static void insertion(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}
		tail.next = newNode;
		newNode.next = head;
		tail = newNode;
	}
	
	public static void printCLL() {
		Node temp = head;
		System.out.println(temp.data);
		temp = temp.next;
		while(temp != head) {
			System.out.println(temp.data +"<->");
			temp = temp.next;
		}
	}
	

	public static void main(String[] args) {
		
		Circular_LinkedList list = new Circular_LinkedList();
		
		list.insertion(1);
		list.insertion(2);
		list.insertion(3);
		list.insertion(4);
		list.insertion(5);
		
		list.printCLL();

	}

}
