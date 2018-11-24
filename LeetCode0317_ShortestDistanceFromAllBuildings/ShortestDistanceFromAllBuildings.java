package LeetCode0317_ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
	int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int buildingNum = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    boolean[][] visited = new boolean[m][n];
                    int level = 1;
                    
                    while(!queue.isEmpty()) {
                        int size = queue.size();
                        
                        for(int k = 0; k < size; k++) {
                            int[] cur = queue.poll();
                            
                            for(int[] dir : dirs) {
                                int row = cur[0] + dir[0];
                                int col = cur[1] + dir[1];
                                
                                if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 0 || visited[row][col]) continue;
                                
                                distance[row][col] += level;
                                reach[row][col]++;
                                visited[row][col] = true;
                                queue.offer(new int[]{row, col});
                            } 
                        }
                        level++;
                    }
                    /*
                    for(int[] arr : distance) {
                        System.out.println(Arrays.toString(arr));
                    }*/
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
