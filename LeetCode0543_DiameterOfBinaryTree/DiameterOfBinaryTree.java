package LeetCode0543_DiameterOfBinaryTree;

public class DiameterOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        helper(root);
        return ans - 1;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left_dis = helper(root.left);
        int right_dis = helper(root.right);
        ans = Math.max(ans, left_dis + right_dis + 1);
        return Math.max(left_dis, right_dis) + 1;
    }
}
