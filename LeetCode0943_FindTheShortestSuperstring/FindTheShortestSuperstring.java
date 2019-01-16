package LeetCode0943_FindTheShortestSuperstring;

import java.util.Arrays;
import java.util.Stack;

public class FindTheShortestSuperstring {
	/*
    int best_len;
    int[][] g;
    int[] best_path;
    public String shortestSuperstring(String[] A) {
        final int n = A.length;
        g = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = A[j].length();
                for(int k = 1; k <= Math.min(A[i].length(), A[j].length()); k++) {
                    if(A[i].substring(A[i].length() - k).equals(A[j].substring(0, k))) {
                        g[i][j] = A[j].length() - k;
                    }
                }
            }
        }
        
        int[] path = new int[n];
        best_len = Integer.MAX_VALUE;
        dfs(A, 0, 0, 0, path);
        //System.out.println(Arrays.toString(best_path));
        String ans = A[best_path[0]];
        for(int k = 1; k < best_path.length; k++) {
            int i = best_path[k - 1];
            int j = best_path[k];
            ans += A[j].substring(A[j].length() - g[i][j]);
        }
        return ans;    
    }
    
    private void dfs(String[] A, int d, int used, int cur_len, int[] path) {
        //System.out.println("used: " + used + ", cur_len: " + cur_len);
        //System.out.print(Arrays.toString(best_path) + ", cur_len:" + cur_len + " " + ", best_len: " + best_len + " ");
        if(cur_len >= best_len) return;
        if(d == A.length) {
            best_len = cur_len;
            best_path = Arrays.copyOf(path, path.length);
            return;
        }
        for(int i = 0; i < A.length; i++) {
            if((used & (1 << i)) != 0) continue;
            path[d] = i;
            //System.out.println(Arrays.toString(path));
            dfs(A, d + 1, used | (1 << i), 
                d == 0 ? A[i].length() : cur_len + g[path[d - 1]][i], path);
        }
    }*/
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        // dp[s][i] := min cost to visit nodes of s and end with i
        // s is a binary string 
        // e.g. dp[14][2] is the min cost to visited {1, 2, 3} and end with 2 (14 = 2^1 + 2^2 + 2 ^3)
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;
        
        for(int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) == 0) continue;
                int prev = i - (1 << j);
                if(prev == 0) {// means i == j
                    dp[i][j] = A[j].length();
                }else{
                    for(int k = 0; k < n; k++) {
                        if(dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                            dp[i][j] = dp[prev][k] + graph[k][j];
                            path[i][j] = k;
                        }
                    }
                }
                // min exits at dp[2^n - 1][*];
                if(i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<>();
        while(cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }
        
        int i = stack.pop();
        sb.append(A[i]);
        while(!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(A[j].substring(A[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }
    
    private int calc(String a, String b) {
        for(int i = 1; i < a.length(); i++) {
            if(b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
