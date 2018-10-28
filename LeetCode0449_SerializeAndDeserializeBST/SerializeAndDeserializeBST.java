package LeetCode0449_SerializeAndDeserializeBST;

public class SerializeAndDeserializeBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeExtend(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void serializeExtend(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null ");
            return;
        }else{
            sb.append(String.valueOf(node.val)).append(" ");
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
    
    private TreeNode deserializeExtend(String[] str, int[] index) {
        if(str[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str[index[0]]));
        index[0]++;
        node.left = deserializeExtend(str, index);
        node.right = deserializeExtend(str, index);
        return node;
    }	
}