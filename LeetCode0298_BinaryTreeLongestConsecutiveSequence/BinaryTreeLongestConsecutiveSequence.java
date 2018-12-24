package LeetCode0298_BinaryTreeLongestConsecutiveSequence;

public class BinaryTreeLongestConsecutiveSequence {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int res;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        res = 0;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode node) {
        if(node == null) return 1;
        int left = helper(node.left);
        int right = helper(node.right);
        if(node.left != null && node.val == (node.left.val - 1)) left = left + 1;
        else left = 1;

        if(node.right != null && node.val == (node.right.val - 1)) right = right + 1;
        else right = 1;
        //System.out.println("node: " + node.val + ", left: " + left + ", right: " + right);
        res = Math.max(res, Math.max(left, right));
        return Math.max(left, right);
    }
}
