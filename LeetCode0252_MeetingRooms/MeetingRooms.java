package LeetCode0252_MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].start < intervals[i + 1].end && intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
    //  Time Limit Exceeded
    /*
    class SegmentTreeNode{
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
    private void update(SegmentTreeNode node, int l, int r, int val) {
        if(node.lazy != 0) {
            node.k += node.lazy;
        }
        if(node.l < node.r) {
            if(node.left == null || node.right == null){
                int m = node.l + (node.r - node.r) / 2;
                node.left = new SegmentTreeNode(node.l, m, node.k);
                node.right = new SegmentTreeNode(m + 1, node.r, node.k);
            }else if(node.lazy != 0){
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        node.lazy = 0;
        
        if(l > r || node == null || l > node.r || r < node.l) return;
        
        if(l <= node.l && node.r <= r) {
            node.k += val;
            if(node.l < node.r) {
                if(node.left == null || node.right == null) {
                    int m = node.l + (node.r - node.l) / 2;
                    node.left = new SegmentTreeNode(node.l, m, node.k);
                    node.right = new SegmentTreeNode(m + 1, node.r, node.k);
                }else{
                    node.left.lazy += val;
                    node.right.lazy += val;
                }
            }
            return;
        }
        
        update(node.left, l, r, val);
        update(node.right, l, r, val);
        
        node.k = Math.max(node.left.k, node.right.k);
    }
    
    SegmentTreeNode root;
    public boolean canAttendMeetings(Interval[] intervals) {
        root = new SegmentTreeNode(0, 100000, 0);
        for(Interval interval : intervals) {
            update(root, interval.start, interval.end - 1, 1);
            if(root.k > 1) return false;
        }
        return true;
    }*/
}