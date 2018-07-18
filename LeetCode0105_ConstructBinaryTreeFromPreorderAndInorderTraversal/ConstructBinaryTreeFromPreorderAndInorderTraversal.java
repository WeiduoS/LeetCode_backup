package LeetCode0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.val = data;
		}
	}
	
	static int preIndex = 0;
	
	// Recursive Solution
	public static TreeNode buildTreeRecur(int[] preorder, int[] inorder) {
		return buildTreeExtend(preorder, inorder, 0, inorder.length - 1);
	}
	 /*
	  * 
	  * preorder = [3,9,20,15,7]
	  * inorder = [9,3,15,20,7]
	  *      3
	  *     / \
	  *    9  20
	  *      /  \
	  *     15   7
	  *  
	  *  Step 1:
	  *     3
	  *   /   \
	  *  9   20, 15, 7
	  *  
	  *  Step 2:
	  *  	3
	  *   /   \
	  *  9(Re) 20, 15, 7
	  *  
	  *  Step 3:
	  *     3
	  *   /   \
	  *  9     20
	  *       /   \
	  *      15    7
	  *  Step 4:
	  *     3
	  *   /   \
	  *  9    20
	  *      /  \
	  *    15(Re) 7(Re)
	  *     
	  */
	
	private static TreeNode buildTreeExtend(int[] preorder, int[] inorder, int inStart, int inEnd) {
		// Return the null child nodes
		if(inStart > inEnd) return null;
		
		TreeNode node = new TreeNode(preorder[preIndex++]);
        
		// Return the left nodes
		if(inStart == inEnd) return node; 
		
		int inIndex = 0;
		
		for(int i = inStart; i <= inEnd; i++) {
			if(inorder[i] == node.val) {
				inIndex = i;
			}
		}
		
		node.left = buildTreeExtend(preorder, inorder, inStart, inIndex - 1);
		node.right = buildTreeExtend(preorder, inorder, inIndex + 1, inEnd);
		
		return node;
	}
	// Iterative Solution
	 public static TreeNode buildTreeIter(int[] preorder, int[] inorder) {
	        if(preorder.length == 0) return null;
	        
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode root = new TreeNode(preorder[0]);
	        TreeNode node = root;
	        /*
	         *             0  1   2  3   4
	         * preorder = [3, 9, 20, 15, 7]
	         * inorder  = [9, 3, 15, 20, 7]
	         */
	        for(int preIndex = 1, inIndex = 0; preIndex < preorder.length; preIndex++){
	            
	            if(node.val != inorder[inIndex]){
	                node.left = new TreeNode(preorder[preIndex]);
	                stack.push(node);
	                node = node.left;
	            }else{
	                stack.push(node);
	                while(!stack.isEmpty() && stack.peek().val == inorder[inIndex]){
	                    node = stack.pop();
	                    inIndex++;
	                }
	                node.right = new TreeNode(preorder[preIndex]);
	                node = node.right;
	            }
	            
	        }
	        
	        return root;
	    }
	
	
	public static String treeNodeToString(TreeNode root) {
		if(root == null) {
			return "[ ]";
		}
		String output = "";
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();
			
			if(node == null) {
				output += "null, ";
				continue;
			}
			
			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
		
	}
	

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		System.out.println("Build Tree from preorder and inorder arrays, Recursive solution will be:");
		System.out.println(treeNodeToString(buildTreeRecur(preorder, inorder)));
		System.out.println("");
		System.out.println("Build Tree from preorder and inorder arrays, Iterative solution will be:");
		System.out.println(treeNodeToString(buildTreeIter(preorder, inorder)));
	}
}