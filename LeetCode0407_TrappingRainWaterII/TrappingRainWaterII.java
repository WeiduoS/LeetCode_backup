package LeetCode0407_TrappingRainWaterII;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    class Cell {
        int x, y, h;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        
        int m = heightMap.length, n = heightMap[0].length;
        
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> (a.h - b.h));
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for(int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        int res = 0;
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            for(int[] dir : dirs) {
                int row = cell.x + dir[0];
                int col = cell.y + dir[1];
                if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) continue;
                visited[row][col] = true;
                res += Math.max(0, cell.h - heightMap[row][col]);
                queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.h)));
            }
        }
        return res;
    }
}
