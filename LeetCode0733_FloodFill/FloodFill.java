package LeetCode0733_FloodFill;

public class FloodFill {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0 || image == null) return new int[][] {};
        int color = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int row , int col, int color, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(row < 0 || col < 0 || row > m - 1 || col > n - 1 || image[row][col] == newColor || image[row][col] != color) return;
        
        image[row][col] = newColor;
        
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(image, r, c, color, newColor);
        }
    }
}