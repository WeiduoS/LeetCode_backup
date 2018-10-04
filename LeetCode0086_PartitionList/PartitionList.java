package LeetCode0086_PartitionList;

public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/*
    // mess up solution
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.val < x) {
            pre = cur;
            cur = cur.next;
        }
        ListNode next = cur;  
        ListNode beforeCur = pre;
        while(cur != null) {
            while(cur != null && cur.val < x) {
                beforeCur.next = cur.next;
                pre.next = cur;
                cur.next = next;
                if(beforeCur != null) cur = beforeCur.next;
                pre = pre.next;
            }
            // System.out.println("beforeCur : " + beforeCur.val + ", cur: " + cur.val);
            if(cur != null) {
                beforeCur = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }*/
    
    public ListNode partition(ListNode head, int x) {
        ListNode sHead = new ListNode(0);
        ListNode bHead = new ListNode(0);
        ListNode sCur = sHead, bCur = bHead;
        
        while(head != null) {
            if(head.val < x) {
                sCur.next = head;
                sCur = sCur.next;
            }else{
                bCur.next = head;
                bCur = bCur.next;
            }
            head = head.next;
        }
        bCur.next = null;
        sCur.next = bHead.next;
        return sHead.next;
    }	
}