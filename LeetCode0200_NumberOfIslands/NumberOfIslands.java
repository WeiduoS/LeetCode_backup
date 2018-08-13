package LeetCode0200_NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == '1') {
                    bfs(grid, row, col);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int[] dir : dirs) {
                int r = point[0] + dir[0];
                int c = point[1] + dir[1];
                if(r < 0 || c < 0 || r > n - 1 || c > m - 1 || grid[r][c] != '1') continue;
                grid[r][c] = '0';
                queue.offer(new int[] {r, c});
            }
                
        }
    }
}