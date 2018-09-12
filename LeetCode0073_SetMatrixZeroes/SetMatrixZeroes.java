package LeetCode0073_SetMatrixZeroes;

public class SetMatrixZeroes {
	 public void setZeroes(int[][] matrix) {
	        int n = matrix.length;
	        int m = matrix[0].length;
	        boolean firstRow = false;
	        boolean firstCol = false;
	        if(matrix == null || n <= 0 || m <= 0) return;
	        // identify the row and column 
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < m; j++) {
	                if(matrix[i][j] == 0) {
	                    if(i == 0) firstRow = true;
	                    if(j == 0) firstCol = true;
	                    matrix[0][j] = 0;
	                    matrix[i][0] = 0;
	                }
	            }
	        }
	        //System.out.println(Arrays.deepToString(matrix));
	        // change the colunm
	        /*
	        for(int j = 1; j < m; j++) {
	            if(matrix[0][j] == 0) {
	                for(int i = 1; i < n; i++) {
	                    if(matrix[i][j] == 0) continue;
	                    if(matrix[i][j] != 0) matrix[i][j] = 0;
	                }
	            }
	        }
	        //System.out.println(Arrays.deepToString(matrix));
	        // change the row
	        for(int i = 1; i < n; i++) {
	            if(matrix[i][0] == 0) {
	                for(int j = 1; j < m; j++) {
	                    if(matrix[i][j] == 0) continue;
	                    if(matrix[i][j] != 0) matrix[i][j] = 0;
	                }
	            }
	        }*/
	        for(int i = 1; i < n; i++) {
	            for(int j = 1; j < m; j++) {
	                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
	            }
	        }
	        
	        if(firstRow == true) {
	            for(int j = 0; j < m; j++) {
	                matrix[0][j] = 0;
	            }
	        }
	        if(firstCol == true) {
	            for(int i = 0; i < n; i++) {
	                matrix[i][0] = 0;
	            }
	        }
	        
	    }	
}