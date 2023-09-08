package packagee10_LinkedList;

public class Tester {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode mergeSort(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		// find mid
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode midNode = slow;
		ListNode rightHalf = mergeSort(midNode.next);
		midNode.next = null;
		ListNode leftHalf = mergeSort(head);

		return merge(leftHalf, rightHalf);

	}

	public static ListNode merge(ListNode leftNode, ListNode rightNode) {
		ListNode mergedLL = new ListNode(-1);
		ListNode temp = mergedLL;

		while (leftNode != null && rightNode != null) {
			if (leftNode.val <= rightNode.val) {
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

	public ListNode mergeKLists(ListNode[] lists) {

		ListNode newHead = new ListNode(-1);
		ListNode newIterator = newHead;

		for (int i = 0; i < lists.length; i++) {

			ListNode head = lists[i];

			ListNode temp = head;
			while (temp != null) {
				newIterator.next = temp;
				newIterator = newIterator.next;
				temp = temp.next;
			}

		}

		newHead.next = mergeSort(newHead.next);

		return newHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
