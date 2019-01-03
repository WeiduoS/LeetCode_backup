package LeetCode0505_TheMazeII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        for(int[] row : dists) Arrays.fill(row, Integer.MAX_VALUE);
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        dists[start[0]][start[1]] = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                int dist = dists[cur[0]][cur[1]];
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    dist++;
                }
                x -= dir[0];
                y -= dir[1];
                dist--;
                if(dists[x][y] > dist) {
                    dists[x][y] = dist;
                    if(x != destination[0] || y != destination[1]) queue.offer(new int[]{x, y});
                }
            }
        }
        int res = dists[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
