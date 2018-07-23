package LeetCode0234_PalindromeLinkedList;

public class PalindromeLinkedList{
	
	ListNode head;
	
	class ListNode {
		int val;
        ListNode next;
        ListNode(int d) {
            val = d;
            next = null;
        }
    }
	
	public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode middle = findMiddle(head); 
        middle = reversePart(middle);
        
        while(head != null && middle != null){
            if(head.val != middle.val) return false;
            head = head.next;
            middle = middle.next;
        }
        return true;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reversePart(ListNode head) {
        if(head.next == null || head == null) return head;
        ListNode curr = head.next;
        ListNode newHead = head;
        
        while(head.next != null){
            head.next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = head.next;
            
        }
        return newHead;
    }
	
	
	public static void main(String[] args) {
		PalindromeLinkedList list = new PalindromeLinkedList();
        list.head = list.new ListNode(1);
        list.head.next = list.new ListNode(2);
        list.head.next.next = list.new ListNode(2);
        list.head.next.next.next = list.new ListNode(1);
        boolean res = list.isPalindrome(list.head);
        System.out.println(res);


    }
	
	
	
	
}