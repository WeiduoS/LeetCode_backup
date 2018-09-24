package LeetCode0207_CourseSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] status = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adj, i, status, stack)) return false;
        }
        return true;
    }
    
    private boolean dfs(List<List<Integer>> adj, int v,  int[] status, Stack<Integer> stack) {
        if(status[v] == 1) return false;
        if(status[v] == 2) return true;
        status[v] = 1;
        for(int neighbor : adj.get(v)) {
            if(!dfs(adj, neighbor, status, stack)) return false;
        }
        status[v] = 2;
        stack.push(v);
        return true;
    }
}