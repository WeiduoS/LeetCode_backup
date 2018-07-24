package LeetCode0114_FlattenBinaryTreetoLinkedList;


public class FlattenBinaryTreeToLinkedList{
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	private TreeNode subNode = null;
    
    public void flattenRecur(TreeNode root) {
        if(root == null) return;
        flattenRecur(root.right);
        flattenRecur(root.left);
        root.right = subNode;
        root.left = null;
        subNode = root;
    }
    
    public void flattenIter(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        
        while(node != null){
            while(node.left != null){
                TreeNode subNode = node.left;
                while(subNode.right != null){
                    subNode = subNode.right;
                }
                subNode.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}