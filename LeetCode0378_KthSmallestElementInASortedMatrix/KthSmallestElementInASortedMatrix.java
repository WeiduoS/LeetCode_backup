package LeetCode0378_KthSmallestElementInASortedMatrix;

public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while(lo <= hi) {
            int m = lo + (hi - lo) / 2;
            int count = findLessEqual(matrix, m);
            if(count < k) {
                lo = m + 1;
            }else{
                hi = m - 1;
            }
            
        }
        
        return lo;
    }
    
    private int findLessEqual(int[][] matrix, int m) {
        int count = 0;
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > m) i--;
            else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }	
}