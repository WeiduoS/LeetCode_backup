package LeetCode0661_ImageSmoother;

public class ImageSmoother {
	int[][] dirs = {{-1, -1}, {-1, 0}, {0, -1}, {0, 0}, {1, 1}, {1, 0}, {0, 1}, {1, -1}, {-1, 1}};
    public int[][] imageSmoother(int[][] M) {
        int result[][] = new int[M.length][M[0].length];
        
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                int count = 0;
                int sum = 0;
                for(int[] dir : dirs) {
                    int row = i + dir[0], col = j + dir[1];
                    if(row < 0 || col < 0 || row >= result.length || col >= result[0].length) continue;
                    count++;
                    sum += M[row][col];
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
