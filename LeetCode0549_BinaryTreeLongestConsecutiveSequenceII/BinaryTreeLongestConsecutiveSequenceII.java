package LeetCode0549_BinaryTreeLongestConsecutiveSequenceII;

public class BinaryTreeLongestConsecutiveSequenceII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int[] helper(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int desc = 1, incre = 1;
        if(root.left != null) {
            if(root.left.val == root.val + 1) {
                incre = left[1] + 1;
            }
            if(root.left.val == root.val - 1) {
                desc = left[0] + 1;
            }
        }
        if(root.right != null) {
            if(root.right.val == root.val + 1) {
                incre = Math.max(incre, right[1] + 1);
            }
            if(root.right.val == root.val - 1) {
                desc = Math.max(desc, right[0] + 1);
            }
        }
        max = Math.max(max, desc + incre - 1);
        return new int[]{desc, incre};
    }
}
