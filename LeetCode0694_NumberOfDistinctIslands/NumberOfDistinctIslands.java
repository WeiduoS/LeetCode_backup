package LeetCode0694_NumberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
	// solution 1 :record the unique number
    /*
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        Set set = new HashSet<HashSet<Integer>>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    Set<Integer> shape = new HashSet<>();
                    DFS(i, j, i, j, grid, shape);
                    if(!shape.isEmpty()) set.add(shape);
                }
            }
        }
        return set.size();
    }
    
    private void DFS(int cur_x, int cur_y, int orig_x, int orig_y, int[][] grid, Set<Integer> shape) {
        grid[cur_x][cur_y] = 0;
        // why? ->  2 * grid[0].length
        // local col-coordinate could be negative and it shift one island to the next line

        //  1 1 1 1  <- 0 1 2 3
        //  1 0 1 0  <- 4 0 6 0
        //  0 0 0 0 
        //  0 1 1 1  <- 0 0 1 2
        //  1 1 0 1  <- 3 4 0 6
        shape.add((cur_x - orig_x) * 2 * grid[0].length + (cur_y - orig_y));
        for(int[] dir : dirs) {
            int r = cur_x + dir[0];
            int c = cur_y + dir[1];
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) continue;
            DFS(r, c, orig_x, orig_y, grid, shape);
        }
    }*/
    
    // solution 2: record the unique string
    /*
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    DFS(i, j, i, j, grid, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    private void DFS(int cur_x, int cur_y, int orig_x, int orig_y, int[][] grid, StringBuilder sb) {
        grid[cur_x][cur_y] = 0;
        sb.append((cur_x - orig_x) + "" + (cur_y - orig_y));
        for(int[] dir : dirs) {
            int r = cur_x + dir[0];
            int c = cur_y + dir[1];
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) continue;
            DFS(r, c, orig_x, orig_y, grid, sb);
        }
    }*/
    // solution 3: record the unique path
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right -> down -> left -> up
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    DFS(i, j, "-1", grid, sb);
                    //System.out.println("grid[i][j]: " + grid[i][j] + ", i: " + i + ", j: " + j + ", sb: " + sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        //for(String s : set) System.out.println(s);
        return set.size();
    }
    
    private void DFS(int cur_x, int cur_y, String pos, int[][] grid, StringBuilder sb) {
        if(grid[cur_x][cur_y] == 0) return;
        grid[cur_x][cur_y] = 0;
        sb.append(pos);
        for(int i = 0; i < dirs.length; i++) {
            int r = cur_x + dirs[i][0];
            int c = cur_y + dirs[i][1];
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) continue;
            DFS(r, c, String.valueOf(i), grid, sb);
        }
        sb.append("-2");// add the ending will make the path unique;
    }
}
