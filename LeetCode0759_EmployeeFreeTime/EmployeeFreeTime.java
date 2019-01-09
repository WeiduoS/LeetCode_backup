package LeetCode0759_EmployeeFreeTime;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // [[[1,2],[5,6]],[[1,3]],[[4,10]]]
        // [1, 2] [1, 3] [4, 10] [5, 6]
        PriorityQueue<int[]> sort_schedule = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(List<Interval> s : schedule) {
            for(Interval t : s) {
                sort_schedule.add(new int[]{t.start, t.end});
            }
        }
        List<Interval> res = new ArrayList<>();
        int preEnd = sort_schedule.peek()[1];
        while(!sort_schedule.isEmpty()) {
            //System.out.println(Arrays.toString(sort_schedule.peek()));
            int[] event = sort_schedule.poll();
            if(event[0] > preEnd) {
                res.add(new Interval(preEnd, event[0]));
            }
            preEnd = Math.max(preEnd, event[1]);
        }
        return res;
    }
}
