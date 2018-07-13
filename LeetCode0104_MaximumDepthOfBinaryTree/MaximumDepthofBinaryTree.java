package LeetCode0104_MaximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class MaximumDepthofBinaryTree{
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.data = data;
		}
	}
	
	// Create Binary Tree
	/*
	 * 			   40
	 *           /    \
	 *        20        60
	 *       /  \      /  \
	 *      10  30    50   70
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node10=new TreeNode(10);
		TreeNode node30=new TreeNode(30);
		TreeNode node60=new TreeNode(60);
		TreeNode node50=new TreeNode(50);
		TreeNode node70=new TreeNode(70);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
 
		return rootNode;
			
	}
	
	public static int maxDepthIter(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int depth = 0;
		queue.add(root);
		while(!queue.isEmpty()) {
			Queue<TreeNode> subQueue = new LinkedList<>();
			while(!queue.isEmpty()) {
				root = queue.poll();
				//System.out.println(depth);
				//System.out.printf("%d ",root.data);
				if(root.left!=null)
					subQueue.add(root.left);
				if(root.right!=null)
					subQueue.add(root.right);
			}
			queue = subQueue;
			depth++;
		}
		return depth;
	}
	
	public static int maxDepthRecur(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right));
	}
	
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		System.out.println("The iterative solution will be:");
		System.out.println(maxDepthIter(rootNode));
		System.out.println("");
		System.out.println("The Recursive solution will be:");
		System.out.println(maxDepthRecur(rootNode));
	}
}