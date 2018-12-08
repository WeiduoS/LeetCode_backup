package LeetCode0025_ReverseNodesInKGroup;

public class ReverseNodesInKGroup {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	// solution 1: recursive
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, prev = null, next = null;
        // pre check for case: [1,2] 3
        if(head != null) {
            ListNode temp = head;
            int tempCount = 0;
            while(temp != null) {
                if(tempCount == k) break;
                tempCount++;
                temp = temp.next;
            }
            if(tempCount < k) return head;
        }
        
        // reverse group listnode
        int count = k;
        while(count > 0 && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        if(next != null) {
            ListNode temp = next;
            int tempCount = 0;
            while(temp != null) {
                if(tempCount == k) break;
                temp = temp.next;
                tempCount++;
            }
            
            // post check
            if(tempCount == k) {
                head.next = reverseKGroup(next, k);
            }else{
                head.next = next;
            }
        }
        return prev;
    }*/
    // optimize
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode temp = head;
        for(int i = 0; i < k - 1; i++){
            temp = temp.next;
            if(temp == null) return head;
        }
        
        temp = reverseKGroup(temp.next, k);
        
        ListNode prev = temp, next = null, cur = head;
        while(k > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        return prev;
    }*/
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preHead = dummy, tail = null, postTail = null;
        while(head != null) {
            tail = head;
            for(int i = 0; i < k - 1; i++) {
                tail = tail.next;
                if(tail == null) return dummy.next;
            }
 
            postTail = tail.next;
            tail.next = null;
            
            preHead.next = reverse(head);
            
            head.next = postTail;
            preHead = head;
            head = head.next;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null, cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
