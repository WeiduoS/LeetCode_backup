package LeetCode0094_BinaryTreeInorderTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class BinaryTreeInOrder{
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
	
	// Recursive Version
	public LinkedList<Integer> inOrderRecur(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		inOrderRecur(root, list);
		return list;
	}
	public void inOrderRecur(TreeNode root,LinkedList<Integer> list ) {
		if (root == null) {
	           return;
	    }
		inOrderRecur(root.left, list); 
        list.add(root.data);
        inOrderRecur(root.right, list);
	}
	
	// Iterative Version
	public LinkedList<Integer> inOrderIter(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.data);
            root = root.right;
        }  
    return list;
	}
	
	public static void main(String[] args) {
		BinaryTreeInOrder bi=new BinaryTreeInOrder();
		TreeNode rootNode = createBinaryTree();
		System.out.println("Using Recursive solution:"); 
		LinkedList<Integer> list1 = new LinkedList<>();
		list1 = bi.inOrderRecur(rootNode);
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Using Iterative solution:"); 
		LinkedList<Integer> list2 = new LinkedList<>();
		list2 = bi.inOrderIter(rootNode);
		System.out.println(Arrays.toString(list2.toArray()));
	}
}