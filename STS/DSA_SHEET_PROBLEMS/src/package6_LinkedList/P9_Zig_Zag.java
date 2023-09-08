package package6_LinkedList;

public class P9_Zig_Zag { // solved on leetcode :- https://leetcode.com/problems/reorder-list/description/
	
	public static void zig_zag(ListNode head) {
		// find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;

        ListNode rightHalf = midNode.next;
        midNode.next = null;
        ListNode leftHalf = head;

        // reverse the second half
        ListNode curr = rightHalf;
        ListNode prev = null;
        ListNode next;
        while(curr
         != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode rightHead = prev;
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        boolean flag = true;
        while(leftHalf != null && rightHead != null) {
            if(flag) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
                temp = temp.next;
                flag = false;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
                flag = true;
            }
        }

        if(leftHalf != null) {
            temp.next = leftHalf;
        }

        if(rightHead != null){
            temp.next = rightHead;
        }

        head = newHead.next;
	}

	public static void main(String[] args) {
		
		

	}

}
