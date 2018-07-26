package LeetCode0430_FlattenAMultilevelDoublyLinkedList;

public class FlattenAMultilevelDoublyLinkedList{
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}
	
	// Accepted Solution 88.6%
	public Node flatten(Node head){
        if(head == null) return head;
        Node node = head;
        while(node != null){
            if(node.child != null){
                flatten(node, node.child);
            }
            node = node.next;
        }
        return head;
    }
    
    private void flatten(Node parent, Node child) {
        //System.out.println(parent.val + " " + child.val);
        Node parentNext = parent.next;
        parent.child = null;
        parent.next = child;
        child.prev = parent;
        while(child.next != null){
            if(child.next.child != null){
                flatten(child.next, child.next.child);
            }
            child = child.next;
        }
        //System.out.println(parent.val);
        if(parentNext != null){
            child.next = parentNext;
            parentNext.prev = child;
        }else{
            return;
        }
    }
}