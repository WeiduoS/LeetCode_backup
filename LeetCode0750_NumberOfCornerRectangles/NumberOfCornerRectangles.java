package LeetCode0750_NumberOfCornerRectangles;

public class NumberOfCornerRectangles {
	public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for(int r1 = 0; r1 + 1 < grid.length; r1++) {
            for(int r2 = r1 + 1; r2 < grid.length; r2++) {
                int counter = 0;
                for(int c = 0; c < grid[0].length; c++) {
                    if(grid[r1][c] == 1 && grid[r2][c] == 1) counter++;
                }
                ans += counter * (counter - 1) / 2;
            }
        }
        return ans;
    }
}
