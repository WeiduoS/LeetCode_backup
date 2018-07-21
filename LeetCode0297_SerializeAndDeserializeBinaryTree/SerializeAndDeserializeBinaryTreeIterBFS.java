package LeetCode0297_SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeAndDeserializeBinaryTreeIterBFS{
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
	 * 			   1
	 *            / \
	 *           2   3
	 *              / \
	 *             4   5
	 */
	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);

		
		rootNode.left = node2;
		rootNode.right = node3;
		
		node3.left=node4;
		node3.right=node5;
 
		return rootNode;
			
	}
	
	// Encodes a tree to a single string.
	/*public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        TreeNode x=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (x!=null || !stack.isEmpty()) {
            if (x!=null) {
                sb.append(String.valueOf(x.val));
                sb.append(' ');
                stack.push(x);
                x=x.left;
            }
            else {
                sb.append("null ");
                x=stack.pop();
                x=x.right;
            }
        }
        return sb.toString();
    }*/
	public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(String.valueOf(root.val)).append(" ");
        
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left == null) {
                sb.append("null ");
            }else{
                sb.append(String.valueOf(root.left.val)).append(" ");
                queue.offer(root.left);  
            }
            if(root.right == null){
                sb.append("null ");
            }else{
                sb.append(String.valueOf(root.right.val)).append(" ");
                queue.offer(root.right);  
            }
        }
        return sb.toString();
    }
    
	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() == 0) return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueIndex = 1;
        while(!queue.isEmpty()){
            Queue<TreeNode> subQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(str[queueIndex].equals("null")){
                    node.left = null;
                }else{
                    node.left = new TreeNode(Integer.valueOf(str[queueIndex]));
                    subQueue.offer(node.left);
                }
                queueIndex++;
                if(str[queueIndex].equals("null")){
                    node.right = null;
                }else{
                    node.right = new TreeNode(Integer.valueOf(str[queueIndex]));
                    subQueue.offer(node.right);
                }
                queueIndex++;
           }
            queue = subQueue; 
        }
        return root;
    }
    
    public String treeNodeToString(TreeNode root) {
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
		SerializeAndDeserializeBinaryTreeIterBFS bi=new SerializeAndDeserializeBinaryTreeIterBFS();
		TreeNode rootNode = createBinaryTree();
		System.out.println("Encodes a tree to a single string:"); 
		System.out.println(bi.serialize(rootNode)); 
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Decodes your encoded data to tree:");
		System.out.println(bi.treeNodeToString(bi.deserialize(bi.serialize(rootNode)))); 

	}
}