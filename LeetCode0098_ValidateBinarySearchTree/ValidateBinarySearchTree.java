package LeetCode0098_ValidateBinarySearchTree;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// solution 1: preorder iterative
    public boolean isValidBSTI(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null ){
                stack.push(root);
                if(root.left != null) {
                    if(root.val <= root.left.val) return false;
                }
                root = root.left;
            }
            root = stack.pop();
            if(root.right != null) {
                if(root.val >= root.right.val) return false;
                if(!stack.isEmpty()) {
                    if(root.right.val >= stack.peek().val) return false;
                }
                if(root.right.left != null && root.right.left.val <= root.val) return false;
            }
            root = root.right;
        }

        return true;
    }
    // solution 2: Recursive

    public boolean isValidBSTII(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer max, Integer min) {
        if(root == null) return true;
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
    
    // solution 3: inorder traversal
    public boolean isValidBSTIII(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}