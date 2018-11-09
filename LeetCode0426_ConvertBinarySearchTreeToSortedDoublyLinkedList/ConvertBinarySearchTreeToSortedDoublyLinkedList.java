package LeetCode0426_ConvertBinarySearchTreeToSortedDoublyLinkedList;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	class Solution {
	    public Node treeToDoublyList(Node root) {
	        if(root == null) return null;
	        Node head = root;
	        while(head.left != null) {
	            head = head.left;
	        }
	        Node tail = root;
	        while(tail.right != null) {
	            tail = tail.right;
	        }
	        helper(root);
	        head.left = tail;
	        tail.right = head;
	        return head;
	    }
	    
	    private Node helper(Node root) {
	        if(root == null) return null;
	        Node left_subtree = helper(root.left);
	        if(left_subtree != null) {
	            //System.out.println("left_subtree: " + left_subtree.val + ", root: " + root.val);
	            left_subtree.right = root;
	            root.left = left_subtree;
	        }
	        Node right_subtree = helper(root.right);
	        if(right_subtree != null) {
	            Node temp = right_subtree;
	            while(temp.left != null) {
	                temp = temp.left;
	            }
	            temp.left = root;
	            root.right = temp;
	        }
	        return right_subtree == null? root : right_subtree;
	    }
	}
}
