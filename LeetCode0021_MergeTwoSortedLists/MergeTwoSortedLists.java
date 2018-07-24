package LeetCode0021_MergeTwoSortedLists;


public class MergeTwoSortedLists{
	
	ListNode head;
	
	class ListNode {
		int val;
        ListNode next;
        ListNode(int d) {
            val = d;
            next = null;
        }
    }
	
	void printList(ListNode node) {
		ListNode dummy = node;
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }
    }
	// Iterative solution
	public ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        
        
        while(l1 != null && l2 != null ){
            if(l1.val <= l2.val){
                curr.next = l1;
                //System.out.println(dummy.val);
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null)? l1 : l2;
        return newHead.next;
    }
	
	// Recursive Solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
	
	public static void main(String[] args) {
		MergeTwoSortedLists list1 = new MergeTwoSortedLists();
        list1.head = list1.new ListNode(1);
        list1.head.next = list1.new ListNode(3);
        list1.head.next.next = list1.new ListNode(5);
        list1.head.next.next.next = list1.new ListNode(7);
        MergeTwoSortedLists list2 = new MergeTwoSortedLists();
        list2.head = list2.new ListNode(2);
        list2.head.next = list2.new ListNode(4);
        list2.head.next.next = list2.new ListNode(6);
        list2.head.next.next.next = list2.new ListNode(8);
         
        MergeTwoSortedLists list = new MergeTwoSortedLists();
        ListNode res = list.mergeTwoListsIter(list1.head, list2.head);
        System.out.println("The Iterative Solution will be:");
        list.printList(res);
        System.out.println("");

    }
	
	
	
	
}