package LeetCode0056_MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	private class IntervalComparator implements Comparator<Interval> {
        @Override 
        public int compare(Interval i1, Interval i2) {
            return i1.start > i2.start ? 1 : i1.start == i2.start ? 0 : -1;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval top = stack.pop();

            if(top.end < intervals.get(i).start) {
                res.add(top);
                stack.push(intervals.get(i));
            }else{
                top.end = Math.max(top.end, intervals.get(i).end);
                stack.push(top);
            }
        }
        while(!stack.isEmpty()) res.add(stack.pop());
        return res;
    }	
}