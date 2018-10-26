package LeetCode0572_SubtreeOfAnotherTree;

public class SubtreeOfAnotherTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null && t != null || t == null && s != null) return false;
        List<TreeNode> nodeList = findRoot(s, t); 
        
        if(nodeList.size() == 0) return false;
        
        for(TreeNode node : nodeList) {
            if(helper(node, t)) return true;
        }

        return false;
    }
    
    private boolean helper(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            if(s == null && t == null) return true;
            return false;
        }else if(s.val != t.val) {
            return false;
        }else if(s.val == t.val) {
            return helper(s.left, t.left) && helper(s.right, t.right);
        }
        return false;
    }
    
    
    private List<TreeNode> findRoot(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        while(s != null || !stack.isEmpty()) {
            while(s != null) {
                if(s.val == t.val) {
                    list.add(s);
                }
                stack.push(s);
                s = s.left;
            }
            s = stack.pop();
            s = s.right;
        }
        return list;
    }*/
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    public boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
    
    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }	
}