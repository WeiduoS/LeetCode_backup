package LeetCode0222_CountCompleteTreeNodes;

public class CountCompleteTreeNodes {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// TLE
    /*
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int h = height(root);
        if(h == 1) return 1;
        int count = (int)Math.pow(2, h - 1) - 1;
        int num = bottomTrav(root.left, 2, h) + bottomTrav(root.right, 2, h);
        return count + num;
    }
    private int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    private int bottomTrav(TreeNode root, int depth, int h) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && depth == h) return 1;
        return bottomTrav(root.left, depth + 1, h) + bottomTrav(root.right, depth + 1, h);
    }*/
    public int countNodes(TreeNode root) {
        int leftDep = leftHeight(root);
        int rightDep = rightHeight(root);
        if(leftDep == rightDep) return (int)Math.pow(2, leftDep) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int leftHeight(TreeNode root) {
        if(root == null) return 0;
        return leftHeight(root.left) + 1;
    }
    
    private int rightHeight(TreeNode root) {
        if(root == null) return 0;
        return rightHeight(root.right) + 1;
    }
}
