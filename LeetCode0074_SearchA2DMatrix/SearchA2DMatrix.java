package LeetCode0074_SearchA2DMatrix;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        
        int l = 0;
        int r = m * n - 1;
        while(l <= r) {
            //System.out.println("l : " + l + ", r: " + r);
            int mid = l + (r - l) / 2;
            if(matrix[mid / n][mid % n] == target) {
                return true;
            }else if(matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }   
        }
        return false;
    }
}