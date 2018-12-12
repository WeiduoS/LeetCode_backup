package LeetCode0083_RemoveDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode dummy = head;
        ListNode cur = head, temp = null, next = null;
        
        while(cur != null) {
            next = cur; // find the next node
            // the node of last dup
            while(next.next != null && cur.val == next.next.val) next = next.next;

            temp = next.next;
            next.next = null;
            cur.next = temp;
            cur = cur.next;

        }
        return dummy;
    }
}
