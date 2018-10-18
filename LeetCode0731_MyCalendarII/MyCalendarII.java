package LeetCode0731_MyCalendarII;

import java.util.TreeMap;

public class MyCalendarII {
	/*
    List<int[]> calendar;
    List<int[]> overlaps;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] overlap : overlaps) {
            if(overlap[0] < end && overlap[1] > start) {
                return false;
            }
        }
        for(int[] interval : calendar) {
            if(interval[0] < end && interval[1] > start) {
                overlaps.add(new int[] {Math.max(interval[0], start), Math.min(interval[1], end)});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }*/
    /*
    class SegmentTreeNode {
        int l, r;
        int k , lazy;
        
        SegmentTreeNode left, right;
        
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
            this.lazy = 0;
            this.left = this.right = null;
        }
    }
    
    private int query(SegmentTreeNode node, int i, int j) {
        normalize(node);
        
        if(i > j || node == null || i > node.r || j < node.l) return 0;
        
        if(i <= node.l && node.r <= j) return node.k;
        
        return Math.max(query(node.left, i, j), query(node.right, i, j));
    }
    
    private void update(SegmentTreeNode node, int i, int j, int val) {
        
        normalize(node);
        
        if(i > j || node == null || i > node.r || j < node.l) return;
        
        if(i <= node.l && node.r <= j) {
            node.lazy = val;
            normalize(node);
            return;
        }
        
        update(node.left, i, j, val);
        update(node.right, i, j, val);
    
        node.k = Math.max(node.left.k, node.right.k);
    }
    
    private void normalize(SegmentTreeNode node) {
        if(node.lazy > 0) node.k += node.lazy;
        
        if(node.l < node.r) {
            if(node.left == null || node.right == null) {
                int m = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, m, node.k);
                node.right = new SegmentTreeNode(m + 1, node.r, node.k);
            }else if(node.lazy > 0){
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        
        node.lazy = 0;
    }
    
    SegmentTreeNode root;
    
    public MyCalendarTwo() {
        root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public boolean book(int start, int end) {
        int k = query(root, start, end - 1);
        if (k >= 2) return false;
    
        update(root, start, end - 1, 1);
        return true;
    }*/
    
    TreeMap<Integer, Integer> calendar;
    public void MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) -1);
        
        int overlaps = 0;
        
        for(int i : calendar.values()) {
            overlaps += i;
            if(overlaps >= 3) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                if(calendar.get(start) == 0) calendar.remove(start);
                
                return false;
            }
        }
        
        return true;
    }	
}