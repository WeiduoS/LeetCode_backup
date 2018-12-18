package LeetCode059_SpiralMatrixII;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        int num = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = num;
                num++;
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = num;
                num++;
            }
            colEnd--;
            
            for(int i = colEnd; i >= colBegin; i--) {
                res[rowEnd][i] = num;
                num++;
            }
            rowEnd--;
            
            for(int i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = num;
                num++;
            }
            colBegin++;
        }
        
        return res;
    }
}
