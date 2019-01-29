package LeetCode0778_SwimInRisingWater;

import java.util.LinkedList;
import java.util.Queue;

public class SwimInRisingWater {
	public int swimInWater(int[][] grid) {
        int l = grid[0][0], r = grid.length * grid[0].length;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(!check(grid, m)) l = m + 1;
            else r = m;
        }
        return l;
    }
    
    private boolean check(int[][] grid, int elevation) {
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                //System.out.println(Arrays.toString(cur));
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) return true;
                for(int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c]) continue;
                    visited[r][c] = true;
                    if(grid[r][c] <= elevation) queue.offer(new int[]{r, c});
                }
            }
        }
        return false;
    }
}
