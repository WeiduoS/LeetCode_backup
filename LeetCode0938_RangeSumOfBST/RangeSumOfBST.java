package LeetCode0938_RangeSumOfBST;

public class RangeSumOfBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int res;
    int l;
    int r;
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.l = L;
        this.r = R;
        res = 0; 
        helper(root);
        return res;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        if(root.val >= l && root.val <= r) res += root.val;
        if(l < root.val) helper(root.left);
        if(root.val < r) helper(root.right);
    } 
}
