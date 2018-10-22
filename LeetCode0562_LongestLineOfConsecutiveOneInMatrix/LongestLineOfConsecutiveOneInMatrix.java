package LeetCode0562_LongestLineOfConsecutiveOneInMatrix;

public class LongestLineOfConsecutiveOneInMatrix {
	/*
    public int longestLine(int[][] M) {
        int res = 0;
        if(M == null || M.length == 0) return res;
        if(M[0].length == 0) return res;
        for(int i = 0; i < M.length; i++) {
            int len = 0;
            for(int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
            }
        }
        
        for(int j = 0; j < M[0].length; j++) {
            int len = 0;
            for(int i = 0; i < M.length; i++) {
                if(M[i][j] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
            }
        }
        
        for(int i = 0; i < M.length; i++) {
            int len = 0;
            int row = i;
            int col = 0;
            while(row >= 0 && col < M[0].length) {
                //System.out.println("row: " + row + ", col: " + col);
                if(M[row][col] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
                row--;
                col++;
            }
        }
        
        for(int j = 1; j < M[0].length; j++) {
            int len = 0;
            int row = M.length - 1;
            int col = j;
            
            while(row >= 0 && col < M[0].length) {
                if(M[row][col] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
                row--;
                col++;
            } 
        }
        
        for(int j = 0; j < M[0].length; j++) {
            int len = 0;
            int row = 0;
            int col = j;
            while(row < M.length && col < M[0].length) {
                if(M[row][col] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
                row++;
                col++;
            }
        }
        
        for(int i = 1; i < M.length; i++) {
            int len = 0;
            int row = i;
            int col = 0;
            while(row < M.length && col < M[0].length) {
                if(M[row][col] == 1) {
                    len++;
                }else{
                    len = 0;
                }
                res = Math.max(res, len);
                row++;
                col++;
            }
        }
        
        return res;
    }*/
    // solution 3 dimensions
    /*
    public int longestLine(int[][] M) {
        if(M.length == 0) return 0;
        int res = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][2] + 1: 1;
                    dp[i][j][3] = (i > 0 && j > 0) ? dp[i - 1][j - 1][3] + 1: 1;
                    int temp = Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3]));;
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }*/
    public int longestLine(int[][] M) {
        if(M.length == 0) return 0;
        int res = 0;
        int[][] dp = new int[M[0].length][4];
        for(int i = 0; i < M.length; i++) {
            int dignal = 0;
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1) {
                    dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1;
                    dp[j][1] = i > 0 ? dp[j][1] + 1 : 1;
                    dp[j][2] = (i > 0 && j < M[0].length - 1) ? dp[j + 1][2] + 1: 1;
                    int prev_dignal = dp[j][3];
                    dp[j][3] = (i > 0 && j > 0) ? dignal + 1: 1;
                    dignal = prev_dignal;
                    
                    int temp = Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3]));;
                    res = Math.max(res, temp);
                }else{
                    dignal = dp[j][3];
                    dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0;
                }
            }
        }
        return res;
    }	
}