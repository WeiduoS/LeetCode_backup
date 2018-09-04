package LeetCode0428_SerializeAndDeserializeNaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeNaryTree {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	// Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String res = serializeExtend(root, sb);
        res = res + "]";
        //System.out.println("res: " + res);
        return res;
    }
    /*
    private String serializeExtend(Node root, StringBuilder sb) {
        if(root == null) {
            return "";
        }else{
            sb.append(root.val + "[");
            for(Node child:root.children) serializeExtend(child,sb);
            sb.append("]");
        }
        System.out.println("sb: " + sb.toString());
        return sb.toString();
    }*/
    private String serializeExtend(Node root, StringBuilder sb) {
        if(root == null) {
            return "";
        }else{
            if(root.children.size() > 0) {
                sb.append("\"" + root.val + "\"" + "[");
                for(Node child:root.children) serializeExtend(child,sb);
                sb.append("]");
            }else{
                sb.append("\"" + root.val + "\"" + " ");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    /*
    public Node deserialize(String data) {
        int i = 0;
        int len = data.length();
        Node root = null;
        Stack<Node> stack = new Stack<>();
        while(i<len){
		    int start=i;
            System.out.println("start: " + start + ", i: " + i);
		    while(i<len && Character.isDigit(data.charAt(i))) i++;
            System.out.println("i: " + i);
		        if(start==i){
			        Node child = stack.pop();
			        if(stack.isEmpty()) {
                        root=child; break;
                    }
			        stack.peek().children.add(child);
		    }else{
                stack.push(new Node(Integer.parseInt(data.substring(start,i)),new ArrayList<Node>()));       
            }
		    i++;		
	    }	
        return root;
    }*/
    
    public Node deserialize(String data) {
        if(data.length() < 3) return null;
        Stack<Node> stack = new Stack<>();
        int len = data.length();
        int end = 0;
        Node root = null;
        for(int i = 0; i < len; i++) {
            //System.out.println("i: " + i);
            if(data.charAt(i) == ' ') {
                continue;
            }else if(data.charAt(i) == '[') {
                i += 2;
                end = parseInt(data, i);
                //System.out.println("end: " + end);
                stack.push(new Node(Integer.parseInt(data.substring(i,end)), new ArrayList<Node>()));
                i = end;
                //System.out.println(stack.peek().val);
            }else{
                
                Node child = stack.pop();
                //System.out.println("next val: " + stack.peek().val + ", size: " + stack.size());
                if(stack.isEmpty()) {
                    root = child; 
                    break;
                }else{
                    stack.peek().children.add(child);
                    if(data.charAt(i) == '\"') {
                        i++;
                        end = parseInt(data, i);
                        stack.push(new Node(Integer.parseInt(data.substring(i,end)), new ArrayList<Node>()));
                        i = end;
                    }
                }
            }
        }
        return root;
    }
    private int parseInt(String data, int i) {
        while(data.charAt(i) != '\"') {
            i++;
        }
        return i;
    }
}