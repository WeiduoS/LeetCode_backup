package LeetCode0654_MaximumBinaryTree;

public class MaximumBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return constructTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructTree(int[] nums, int i, int j) {
        if(i > j || i < 0 || j > nums.length - 1) return null;
        if(i == j) return new TreeNode(nums[i]);
        int nodeIndex = findMaxNumber(nums, i, j);
        TreeNode node = new TreeNode(nums[nodeIndex]);
        node.left = constructTree(nums, i, nodeIndex - 1);
        node.right = constructTree(nums, nodeIndex + 1, j);
        return node;
    }
    
    
    private int findMaxNumber(int[] nums, int i, int j) {
        int index = i;
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            if(nums[k] > max) {
                max = nums[k];
                index = k;
            }
        }
        return index;
    }	
}