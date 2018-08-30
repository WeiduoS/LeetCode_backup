package LeetCode0450_DeleteNodeInABST;

public class DeleteNodeInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(root.val == key) {
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            
            // replace root with its successor if root has two children
            TreeNode p = findSuccessor(root);
            root.val = p.val;
            root.right = deleteNode(root.right, p.val);
            return root;
            
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    private TreeNode findSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while(cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}