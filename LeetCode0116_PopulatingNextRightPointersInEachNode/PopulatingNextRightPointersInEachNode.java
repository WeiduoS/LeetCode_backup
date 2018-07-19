package LeetCode0116_PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public class TreeLinkNode {
	     int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	}
    // Iterative solution
    public void connectIter(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeLinkNode pre = null;
            for(int i = 0; i < len; i++){
                root = queue.poll();
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
                if(pre != null){
                    pre.next = root;
                }
                pre = root;
            }
        } 
    }
    // Recursive solution
    public void connectRecur(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.next != null && root.right != null){
            root.right.next = root.next.left;
        }
        
        connectRecur(root.left);
        connectRecur(root.right);
    }
}