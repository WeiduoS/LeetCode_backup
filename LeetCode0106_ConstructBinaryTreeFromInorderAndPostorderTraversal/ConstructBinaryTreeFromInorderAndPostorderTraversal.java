package LeetCode0106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.val = data;
		}
	}
	
	static int postIndex = 0;
	
	// Recursive Solution
	public static TreeNode buildTreeRecur(int[] inorder, int[] postorder) {
		 
		postIndex = postorder.length - 1;
	    return buildTreeRecurExtend(inorder, postorder, 0, inorder.length - 1);
	}
	private static TreeNode buildTreeRecurExtend(int[] inorder, int[] postorder, int inStart, int inEnd){
	    //System.out.println("postIndex: " + postIndex + ", inStart: " + inStart + ", inEnd: " + inEnd);
	    if(inStart > inEnd) return null;
	        
	    TreeNode root = new TreeNode(postorder[postIndex--]);
	    if(inStart == inEnd) return root;
	        
	    int inIndex = 0;
	        
	    for(int i = inStart; i <= inEnd; i++){
	        if(inorder[i] == root.val){
	        	 inIndex = i;  
	        }
	    }
	    //System.out.println("inIndex: " + inIndex);
	    root.right = buildTreeRecurExtend(inorder, postorder, inIndex + 1, inEnd);
	    root.left = buildTreeRecurExtend(inorder, postorder, inStart, inIndex - 1); 
	    return root;
	}
	 
	// Iterative Solution
	public static TreeNode buildTreeIter(int[] inorder, int[] postorder) {
		if(postorder.length == 0) return null;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		TreeNode node = root;
		
		for(int postIndex = postorder.length - 2, inIndex = inorder.length - 1; postIndex >= 0; postIndex--) {
			if(node.val != inorder[inIndex]) {
				node.right = new TreeNode(postorder[postIndex]);
				stack.push(node);
				node = node.right;
			}else {
				stack.push(node);
				while(!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
					node = stack.pop();
					inIndex--;
				}
				
				node.left = new TreeNode(postorder[postIndex]);
				node = node.left;
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
		int[] postorder = {9,15,7,20,3};
		int[] inorder = {9,3,15,20,7};
		System.out.println("Build Tree from preorder and inorder arrays, Recursive solution will be:");
		System.out.println(treeNodeToString(buildTreeRecur(inorder, postorder)));
		System.out.println("");
		System.out.println("Build Tree from preorder and inorder arrays, Iterative solution will be:");
		System.out.println(treeNodeToString(buildTreeIter(inorder, postorder)));
	}
}