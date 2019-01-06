package LeetCode0695_MaxAreaOfIsland;

public class MaxAreaOfIsland {
	int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    
    private int dfs(int x, int y, int[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] != 1) {
            return 0;
        }
        int res = 1;
        visited[x][y] = true;
        for(int[] dir : dirs) {
            int r = x + dir[0];
            int c = y + dir[1];
            res += dfs(r, c, grid);
        }
        return res;
    }
}
