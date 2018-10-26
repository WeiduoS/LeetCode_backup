package LeetCode0129_SumRootToLeafNumbers;

public class SumRootToLeatNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int totalSum;
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        treePath(root, 0);
        return totalSum;
    }
    
    private void treePath(TreeNode node, int pathSum) {
        if(node == null) return;
        //System.out.println("pathSum: " + pathSum + ", node.val: " + node.val + ", pathSum * 10 + node.val: " + (pathSum * 10 + node.val)); 
        pathSum = pathSum * 10 + node.val;
        if(node.left == null && node.right == null) {
            totalSum += pathSum;
            return;
        }
        treePath(node.left, pathSum);
        treePath(node.right, pathSum);
    }	
}