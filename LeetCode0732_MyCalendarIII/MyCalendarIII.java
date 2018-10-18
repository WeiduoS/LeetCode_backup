package LeetCode0732_MyCalendarIII;

public class MyCalendarIII {
	class SegmentTreeNode {
        int l, r;
        int k, lazy;
        SegmentTreeNode left, right;
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
            this.lazy = 0;
            this.left = this.right = null;
        }
    }
    
    private void update(SegmentTreeNode node, int start, int end, int val) {
        if(node.lazy != 0) {
            node.k += node.lazy;
        }
        if(node.l < node.r) {
            if(node.left == null || node.right == null) {
                int m = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, m, node.k);
                node.right = new SegmentTreeNode(m + 1, node.r, node.k);
            }else if(node.lazy != 0){
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        
        node.lazy = 0;
        
        if(start > end || node == null || start > node.r || end < node.l) return;
        
        if(start <= node.l && end >= node.r) {
            node.k += val;
            
            if(node.l < node.r) {
                if(node.left == null || node.right == null) {
                    int m = node.l + (node.r - node.l) / 2;
                    node.left = new SegmentTreeNode(node.l, m, node.k);
                    node.right = new SegmentTreeNode(m + 1, node.r, node.k);
                }else {
                    node.left.lazy += val;
                    node.right.lazy += val;
                }
            }
            return;
        }
        
        update(node.left, start, end, val);
        update(node.right, start, end, val);
        
        node.k = Math.max(node.left.k, node.right.k);
        
    }
    
    SegmentTreeNode root;
    
    public void MyCalendarThree() {
        root = new SegmentTreeNode(0, 1_000_000_000, 0);
        //root = new SegmentTreeNode(0, 30, 0);
    }
    
    public int book(int start, int end) {
        update(root, start, end - 1, 1);
        //System.out.println("l: " + root.left.l + ", r: " + root.left.r);
        //System.out.println("lazy: " + root.left.lazy + ", k: " + root.left.k);
        return root.k;
    }
    /*
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int ovelaps = 0, ans = 0;
        
        for(int ovelap : calendar.values()) {
            ovelaps += ovelap;
            ans = Math.max(ans, ovelaps);
        }
        return ans;
    }*/	
}