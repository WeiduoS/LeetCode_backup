package LeetCode0431_EncodeNaryTreeToBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class EncodeNaryTreeToBinaryTree {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	 }
	// Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if(root.children.size() > 0) {
            res.right = encode(root.children.get(0));
        }
        TreeNode cur = res.right; 
        for(int i = 1; i < root.children.size(); i++) {
            cur.left = encode(root.children.get(i));
            cur = cur.left;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node res = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.right;
        while(cur != null) {
            res.children.add(decode(cur));
            cur = cur.left;
        }
        return res;
    }	
}