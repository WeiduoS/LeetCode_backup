package LeetCode0687_LongestUnivaluePath;

public class LongestUnivaluePath {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) return 0;  
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum_left = 0, sum_right = 0;
        if(root.left != null && root.val == root.left.val) {
            sum_left += left + 1;
        }
        if(root.right != null && root.val == root.right.val) {
            sum_right += right + 1;
        }
        ans = Math.max(ans, sum_left + sum_right);
        return Math.max(sum_left, sum_right);
    }
}
