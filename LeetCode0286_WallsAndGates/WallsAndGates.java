package LeetCode0286_WallsAndGates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    
    private int EMPTY = Integer.MAX_VALUE;
    private int GATE = 0;
    private List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
    );
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(rooms[row][col] == GATE) queue.offer(new int[] {row, col});
            }
        }
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
        
            for(int[] dir : DIRECTIONS) {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || c < 0 || r > m - 1 || c > n - 1 || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[] {r, c});
        }
        
     }
        
        
    }
}