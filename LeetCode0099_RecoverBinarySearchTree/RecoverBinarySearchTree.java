package LeetCode0099_RecoverBinarySearchTree;

public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        //System.out.println(firstNode.val + ", " + secondNode.val);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return;
    }
    
    private void inorderTraverse(TreeNode root) {
        
        if(root == null) return;
        
        inorderTraverse(root.left);
        if(firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if(firstNode != null && preNode.val >= root.val) {
            System.out.println(preNode.val + ", " + root.val);
            secondNode = root;
        }
        preNode = root;
        inorderTraverse(root.right);
    }	
}