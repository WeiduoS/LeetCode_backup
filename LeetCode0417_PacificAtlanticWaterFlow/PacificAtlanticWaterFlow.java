package LeetCode0417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	//solution 1: DFS
    /*
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            DFS(i, 0, pacific, matrix, matrix[i][0]);
            DFS(i, n - 1, atlantic, matrix, matrix[i][n - 1]);
        }
        
        for(int i = 0; i < n; i++) {
            DFS(0, i, pacific, matrix, matrix[0][i]);
            DFS(m - 1, i, atlantic, matrix, matrix[m - 1][i]);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(new int[]{i, j});
            }
        }
        return res;
    }
    
    private void DFS(int x, int y, boolean[][] visited, int[][] matrix, int height) {
        visited[x][y] = true;
        for(int[] dir : dirs) {
            int r = x + dir[0], c = y + dir[1];
            if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] < height || visited[r][c]) continue;
            DFS(r, c, visited, matrix, matrix[r][c]);
        }
    }*/
    
    // solution 2: BFS
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> altq = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            pacq.offer(new int[]{i, 0});
            altq.offer(new int[]{i, n - 1});
        }
        BFS(pacq, pacific, matrix);
        BFS(altq, atlantic, matrix);
        
        for(int i = 0; i < n; i++) {
            pacq.offer(new int[]{0, i});
            altq.offer(new int[]{m - 1, i});
        }
        BFS(pacq, pacific, matrix);
        BFS(altq, atlantic, matrix);
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(new int[]{i, j});
            }
        }
        return res;
    }
    
    private void BFS(Queue<int[]> q, boolean[][] visited, int[][] matrix) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            for(int[] dir : dirs) {
                int r = cur[0] + dir[0], c = cur[1] + dir[1];
                if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c] || matrix[r][c] < matrix[cur[0]][cur[1]]) continue;
                q.offer(new int[]{r, c});
            }
        }
    }
}
