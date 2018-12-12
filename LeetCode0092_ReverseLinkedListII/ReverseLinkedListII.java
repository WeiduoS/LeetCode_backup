package LeetCode0092_ReverseLinkedListII;

public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(m == 1) {
            dummy.next = reverse(head, n - m);
            return dummy.next;
        }
        int count = m;
        while(head != null && count > 2) {
            head = head.next;
            count--;
        }
        //System.out.println("head: " + head.val);
        head.next = reverse(head.next, n - m);
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode tail = head;
        int count = k;
        
        while(tail != null && count > 0) {
            tail = tail.next;
            count--;
        }
        //System.out.println("tail: " + tail.val);
        if(tail != null) tail = tail.next;
        count = k;
        ListNode prev = tail, cur = head, next = null;
        while(cur != null && count >= 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        
        return prev;
    }
}
