package packagee10_LinkedLists;

import packagee10_LinkedLists.A4_Even_Odd_LinkedList.Node;

public class A5_Merge_K_Sorted_LinkedList { // https://leetcode.com/problems/merge-k-sorted-lists/description/

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node mergeSort(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

// find mid
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node midNode = slow;
		Node rightHalf = mergeSort(midNode.next);
		midNode.next = null;
		Node leftHalf = mergeSort(head);

		return merge(leftHalf, rightHalf);

	}

	public static Node merge(Node leftNode, Node rightNode) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;

		while (leftNode != null && rightNode != null) {
			if (leftNode.data <= rightNode.data) {
				temp.next = leftNode;
				temp = temp.next;
				leftNode = leftNode.next;
			} else {
				temp.next = rightNode;
				temp = temp.next;
				rightNode = rightNode.next;
			}
		}

		while (leftNode != null) {

			temp.next = leftNode;
			temp = temp.next;
			leftNode = leftNode.next;

		}

		while (rightNode != null) {

			temp.next = rightNode;
			temp = temp.next;
			rightNode = rightNode.next;

		}

		return mergedLL.next;
	}

	public Node mergeKLists(Node[] lists) {

		Node newHead = new Node(-1);
		Node newIterator = newHead;

		for (int i = 0; i < lists.length; i++) {

			Node head = lists[i];

			Node temp = head;
			while (temp != null) {
				newIterator.next = temp;
				newIterator = newIterator.next;
				temp = temp.next;
			}

		}

		Node newAnotherHead = new Node(-1);
		newAnotherHead.next = mergeSort(newHead.next);

		return newAnotherHead.next;
	}

	public static void main(String[] args) {
		
		// you can code and test over leetcode 
		// refer to this link :- https://leetcode.com/problems/merge-k-sorted-lists/description/

	}

}
