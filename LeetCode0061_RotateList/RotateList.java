package LeetCode0061_RotateList;

public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 public ListNode rotateRight(ListNode head, int k) {
	        if(head == null || head.next == null) return head;
	        int len = 1;
	        ListNode curr = head;
	        
	        /* 1 -> 2 -> 3 -> 4 -> 5 : 2
	         * 1    2    *(3)
	         * 3 = 5 - 2
	         */
	        
	        while(curr.next != null){
	            curr = curr.next;
	            len++;
	        }
	        //System.out.println("curr.val: " + curr.val + ", len:" + len);
	        curr.next = head;
	        
	        for(int i = 0; i < len - (k % len) - 1; i++){
	            head = head.next;
	        }
	        curr = head;
	        head = head.next;
	        curr.next = null;
	        
	        
	        return head;
	    }
}