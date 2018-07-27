package LeetCode0708_InsertIntoACyclicSortedList;

public class InsertIntoACyclicSortedList {
	
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _next) {
	        val = _val;
	        next = _next;
	    }
	}
	
	public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);
        if(head == null){
            node.next = node;
            return node;
        }
        
        Node curr = head;
        Node largest = null;
        Node smallest = null;
        // conrner case 1: the cycle list is only one node
        if(curr == curr.next){
            node.next = curr;
            //System.out.println("curr.val: " + curr.val + ", curr.next.val: " + curr.next.val);
            // the test can be accepted without follow statement, the cycle list can be a loop. 
            // There may be an important problem should be considered again
            //curr.next = node;
            
        }
        while(curr.next.val > curr.val){
            curr = curr.next;
        }
        // curr is the largest one the curr next is the smallest one;
        largest = curr;
        smallest = curr.next;
        //System.out.println("curr.val: " + curr.val + ", curr.next.val: " + curr.next.val);
        // conrner case 2: the insertVal is the smallest one;
        // conrner case 3: the insertVal is the largest one;
        if(insertVal < smallest.val || insertVal > largest.val){
            node.next = curr.next;
            curr.next = node;
        }else{
            while(insertVal > curr.next.val){
                //System.out.println("insertVal: " + insertVal + ", curr.next.val: " + curr.next.val);
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
        }
        
        return head;
    }
}