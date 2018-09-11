package LeetCode0048_RotateImage;

public class RotateImage {
	int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
	
	public void rotate(int[][] matrix) {
        /*
        int n = matrix.length;
        
        for(int i = 0; i <= (n - 1) / 2; i++) {
            // i controls the level
            for(int j = i; j < n - 1 - i; j++) {
                //j controls the begin and end of the line
                int temp = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
            }
        }*/
        /* 1  2  3
         * 4  5  6
         * 7  8  9
         * 
         * 1  4  7
         * 2  5  8
         * 3  6  9
         *
         * 7  4  1 
         * 8  5  2
         * 9  6  3
         */
        /*
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }*/
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix[0].length; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length / 2; j++) {
                matrix[i][j] ^= matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][matrix.length - 1 - j];
            }
        }
        
    }
   
}