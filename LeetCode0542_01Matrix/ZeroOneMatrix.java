package LeetCode0542_01Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int[] dir : dirs) {
                int r = point[0] + dir[0];
                int c = point[1] + dir[1];
                if(r < 0|| c < 0|| r > m - 1 || c > n - 1 || matrix[r][c] <= matrix[point[0]][point[1]] + 1) continue;
                queue.offer(new int[]{r, c});
                matrix[r][c] = matrix[point[0]][point[1]] + 1;
            }
        }
        
        return matrix;
    }	
}