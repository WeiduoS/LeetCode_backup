package LeetCode0297_SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;



public class SerializeAndDeserializeBinaryTreeRecurDFS{
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
	 *      10  30    50   70
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
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
        serializeExtend(root, sb);
        return sb.toString();
    }
    private void serializeExtend(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null ");
        }else{
            sb.append(node.val).append(" ");
            serializeExtend(node.left, sb);
            serializeExtend(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        int[] index = new int[1];
        return deserializeExtend(str, index);
    }
    private TreeNode deserializeExtend(String[] str, int[] index){
        if(str[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str[index[0]]));
        index[0]++;
        root.left = deserializeExtend(str, index);
        root.right = deserializeExtend(str, index);
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
		SerializeAndDeserializeBinaryTreeRecurDFS bi=new SerializeAndDeserializeBinaryTreeRecurDFS();
		TreeNode rootNode = createBinaryTree();
		System.out.println("Encodes a tree to a single string:"); 
		System.out.println(bi.serialize(rootNode)); 
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Decodes your encoded data to tree:");
		System.out.println(bi.treeNodeToString(bi.deserialize(bi.serialize(rootNode)))); 

	}
}