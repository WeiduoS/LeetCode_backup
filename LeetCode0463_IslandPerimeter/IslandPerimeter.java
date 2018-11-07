package LeetCode0463_IslandPerimeter;

public class IslandPerimeter {
	int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int islandPerimeter(int[][] grid) {
        
        int perimeter = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int edges = 4;
                    for(int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
                        //System.out.println("x: " + x + ", y: " + y);
                        if(grid[x][y] == 1) edges--;
                    }
                    perimeter += edges;
                }
            }
        }
        
        return perimeter;
    }	
}