package LeetCode0110_BalancedBinaryTree;

public class BalancedBinaryTree {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public boolean isBalancedI(TreeNode root) {
        if(root == null) return true;
        return treeHighI(root) != -1;
    }
    private int treeHighI(TreeNode root) {
        if(root == null) return 0;
        int l = treeHighI(root.left);
        int r = treeHighI(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return Math.max(treeHighI(root.left), treeHighI(root.right)) + 1;
    }
    // optimized solution
    public boolean isBalancedII(TreeNode root) {
        if(root == null) return true;
        return treeHighII(root) != -1;
    }
    private int treeHighII(TreeNode root) {
        if(root == null) return 0;
        int l = treeHighII(root.left);
        if(l == -1) return -1;
        int r = treeHighII(root.right);
        if(r == -1) return -1;
        if(Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }	
}