package LeetCode0101_SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SymmetricTree{
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
	 *        20        20
	 *       /  \      /  \
	 *      10  5    5   10
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node1=new TreeNode(20);
		///TreeNode node11=new TreeNode(10);
		TreeNode node12=new TreeNode(5);
		TreeNode node2=new TreeNode(20);
		TreeNode node21=new TreeNode(5);
		//TreeNode node22=new TreeNode(10);
		
		rootNode.left = node1;
		rootNode.right = node2;
		
		//node1.left=node11;
		node1.right=node12;
 
		node2.left=node21;
		//node2.right=node22;
 
		return rootNode;
			
	}
	
	// Recursive Version
	public static boolean isSymmetricRecur(TreeNode root) {
        return root == null || isSymmetricRecur(root.left, root.right);
    }
    public static boolean isSymmetricRecur(TreeNode left, TreeNode right) {
        if(left==null || right==null)
            return left==right;
        //if(left.val!=right.val)
           // return false;
        return left.val == right.val && isSymmetricRecur(left.left, right.right) && isSymmetricRecur(left.right, right.left);
    }
	
	// Iterative Version
	public static boolean isSymmetricIter(TreeNode root) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			
			if(left == null && right == null) continue;
			if(left == null || right == null) return false;
			if(left.val != right.val) return false;
			
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;	
	}
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode=createBinaryTree();
		System.out.println("Recrusive solution will be:");
		System.out.println(isSymmetricRecur(rootNode));
		System.out.println("Iterative solution will be:");
		System.out.println(isSymmetricIter(rootNode));
	}
}