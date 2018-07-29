package LeetCode0498_DiagonalTraverse;

public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        
        int row = 0, column = 0;
        int m = matrix.length, n = matrix[m - 1].length; 
        int res[] = new int[m * n];
        
        for(int i = 0; i < res.length; i++){
            res[i] = matrix[row][column];
            // row + column number == even -> down left
            // down left: row - 1 && column + 1
            if((row + column) % 2 == 0){
                if(column == n - 1){ // the bottom boundary
                    row++;
                }else if(row == 0){ // the left boundary
                    column++;
                }else{
                    row--;
                    column++; 
                }
                // row + column number == odd -> up right
                // down left: row + 1 && column - 1
            }else if((row + column) % 2 == 1){
                if(row == m - 1){
                    column++;
                }else if(column == 0){
                    row++;
                }else{
                    row++;
                    column--;
                }
            }
        }
        return res;
    }
}