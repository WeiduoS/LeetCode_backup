package LeetCode0148_SortList;

public class SortList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	// solution 1: nlog(n) + O(1)
    /*
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left, right, prev;
        for(int i = 1; i < len; i *= 2) {
            cur = dummy.next;
            prev = dummy;
            
            while(cur != null) {
                left = cur;
                right = split(left, i);
                cur = split(right, i);
                prev = merge(left, right, prev);
            }
        }
        
        return dummy.next;
    }
   
    private ListNode split(ListNode head, int n) {
        if(head == null) return head;
        for(int i = 1; i < n; i++) {
            if(head.next != null) {
                head = head.next;
            }
        }
        ListNode second = head.next;
        head.next = null;
        return second;
    }
    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        ListNode cur = prev;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }else if(l2 != null) {
            cur.next = l2;
        }
        while(cur.next != null) cur = cur.next;
        return cur;
    }*/
    // solution 2: nlog(n) + nlog(n)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }	
}