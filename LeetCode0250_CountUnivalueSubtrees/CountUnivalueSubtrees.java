package LeetCode0250_CountUnivalueSubtrees;


public class CountUnivalueSubtrees{
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.val = data;
		}
	}
	
	// Create Binary Tree
	/*
	 * 			   40
	 *           /    \
	 *        20        60
	 *       /  \      /  \
	 *      20  20    60   60
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node20left=new TreeNode(20);
		TreeNode node20right=new TreeNode(20);
		TreeNode node60=new TreeNode(60);
		TreeNode node60left=new TreeNode(60);
		TreeNode node60right=new TreeNode(60);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left=node20left;
		node20.right=node20right;
 
		node60.left=node60left;
		node60.right=node60right;
 
		return rootNode;
		
		
	}
	
	public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        countUnivalSubtrees(root, count);
        return count[0];
    }
    private boolean countUnivalSubtrees(TreeNode root, int[] count){
        if(root == null) return true;
        
        boolean left = countUnivalSubtrees(root.left, count);
        boolean right = countUnivalSubtrees(root.right, count);
        
        if(left && right){
            if((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val))
                return false;
            
            count[0]++;
            return true;
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		CountUnivalueSubtrees bi=new CountUnivalueSubtrees();
		TreeNode rootNode=createBinaryTree();
		System.out.println(bi.countUnivalSubtrees(rootNode));

	}
}