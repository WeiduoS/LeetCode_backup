package LeetCode0240_SearchA2DMatrixII;

public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = matrix.length - 1;
        int y = 0;
        while(x >= 0 && y <= matrix[0].length - 1) {
            if(matrix[x][y] == target) {
                return true;
            }else if(matrix[x][y] < target) {
                y++;
            }else{
                x--;
            }
        }
        return false;
    }	
}