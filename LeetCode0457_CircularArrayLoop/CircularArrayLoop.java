package LeetCode0457_CircularArrayLoop;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {
	public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            Set<Integer> set = new HashSet<Integer>();
            if(DFS(nums, i, visited, set)) return true;
        }
        return false;
    }
    
    private boolean DFS(int[] nums, int cur, boolean[] visited, Set<Integer> set) {
        visited[cur] = true;
        set.add(cur);
        int next = (cur + nums[cur] + nums.length) % nums.length;
        if(next == cur || nums[next] * nums[cur] < 0) return false;
        
        if(set.contains(next)) return true;
        if(DFS(nums, next, visited, set)) return true;
        return false;
    }
}
