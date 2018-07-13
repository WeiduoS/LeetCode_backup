package LeetCode0144_BinaryTreePreorderTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreePreOrder{
	
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
	
	// Iteration Version
	public LinkedList<Integer> preOrderIter(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null ){
                stack.push(root);
                list.add(root.data);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
	
	// Recursive Version
	private LinkedList<Integer> preOrderRecur(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		preOrderRecur(root, list);
		return list; 
	}
	public void preOrderRecur(TreeNode root, LinkedList<Integer> list) {
		if (root == null) {
	           return;
	    }
		list.add(root.data);
		preOrderRecur(root.left, list);
		preOrderRecur(root.right, list);
	}
	
	public static void main(String[] args) {
		BinaryTreePreOrder bi=new BinaryTreePreOrder();
		TreeNode rootNode=createBinaryTree();
		System.out.println("Using Iterative solution:"); 
		LinkedList<Integer> list1 = new LinkedList<>();
		list1 = bi.preOrderIter(rootNode);
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Using Recursive solution:"); 
		LinkedList<Integer> list2 = new LinkedList<>();
		list2 = bi.preOrderRecur(rootNode);
		System.out.println(Arrays.toString(list2.toArray()));
	}
}