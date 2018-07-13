package LeetCode0145_BinaryTreePostOrderTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class BinaryTreePostOrder{
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
	private LinkedList<Integer> postOrderRecur(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		postOrderRecur(root, list);
		return list;

	}
	public void postOrderRecur(TreeNode root, LinkedList<Integer> list){
		if(root == null) return;
		postOrderRecur(root.left, list);
		postOrderRecur(root.right, list);
		list.add(root.data);
	}
	
	// Iterative Version
	public LinkedList<Integer> postOrderIter(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();
		while(root != null || !stack.isEmpty()) {
			/*
			 *             40
			 *           /    \
			 *        20        60
			 *       /  \      /  \
			 *      10  30    50   70
			 *      
			 *      Stack(right -> root -> left): 60 -> 40  + 30 -> 20
			 *      if root.hasLeft && Left == stack.top && !stack.isEmpty
			 *      root = root.right
			 */
			while(root != null) {
				if(root.right != null) {
					stack.push(root.right);
				}
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			
			if(root.right != null && !stack.isEmpty( ) && root.right == stack.peek()) {
				stack.pop();
				stack.push(root);
				root = root.right;
			}else {
				list.add(root.data);
				root = null;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		BinaryTreePostOrder bi=new BinaryTreePostOrder();
		TreeNode rootNode = createBinaryTree();
		System.out.println("Using Recursive solution:"); 
		LinkedList<Integer> list1 = new LinkedList<>();
		list1 = bi.postOrderRecur(rootNode);
		System.out.println(Arrays.toString(list1.toArray())); 
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Using Iterative solution:"); 
		LinkedList<Integer> list2 = new LinkedList<>();
		list2 = bi.postOrderIter(rootNode);
		System.out.println(Arrays.toString(list2.toArray())); 
	}
}