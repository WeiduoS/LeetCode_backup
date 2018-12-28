package LeetCode0363_MaxSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
	/*
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                for(int r = 1; r <= i; r++) {
                    for(int c = 1; c <= j; c++) {
                        int d = sum[i][j];
                        d = d - sum[r - 1][j] - sum[i][c - 1] + sum[r - 1][c - 1];
                        if(d <= k) res = Math.max(res, d);
                    }
                }
            }
        }
        return res;
    }*/
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
        
        for(int c1 = 0; c1 < n; c1++) {
            int[] sum = new int[m];
            for(int c2 = c1; c2 >= 0; c2--) {
                for(int i = 0; i < m; i++) {
                    sum[i] += matrix[i][c2];
                }
                int temp_res = helper(sum, k);
                //System.out.println(temp_res);
                res = Math.max(temp_res, res);
            }
        }
        return res;
    }
    
    private int helper(int[] arr, int k) {
        int sum = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        int res = Integer.MIN_VALUE;
        tree.add(0);
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Integer ceiling = tree.ceiling(sum - k);
            if(ceiling != null) res = Math.max(res, sum - ceiling);
            tree.add(sum);
        }
        return res;
    }
}
