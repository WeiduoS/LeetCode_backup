package LeetCode0351_AndroidUnlockPatterns;

public class AndroidUnlockPatterns {
	/*
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for(int steps = m; steps <= n; steps++) {
            res += backtracking(-1, new boolean[9], steps);
        }
        return res;
    }
    
    private int backtracking(int cur, boolean[] used, int steps) {
        if(steps == 0) return 1; 
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            if(moveVaild(cur, i, used)) {
                used[i] = true;
                sum += backtracking(i, used, steps - 1);
                used[i] = false;
            }
        }
        return sum;
    }
    // vertical and horizonal move
    private boolean moveVaild(int cur, int next, boolean[] used) {
        if(used[next]) return false;
        
        if(cur == -1) return true;
        
        //if(next - cur == 1 || next - cur == -1 || next - cur == 3 || next - cur = 3) return true;
        
        if((next + cur) % 2 == 1) return true; 
        
        int mid = (cur + next) / 2;
        if(mid == 4) return used[mid];
        
        if((cur % 3 != next % 3) && (cur / 3 != next / 3)) return true;
        
        return used[mid];
    }*/
    
    
    public int numberOfPatterns(int m, int n) {
        int skips[][] = new int[10][10];
        skips[1][3] = skips[3][1] = 2;
        skips[1][7] = skips[7][1] = 4;
        skips[3][9] = skips[9][3] = 6;
        skips[7][9] = skips[9][7] = 8;
        skips[1][9] = skips[9][1] = skips[3][7] = skips[7][3] = skips[4][6] = skips[6][4] = skips[2][8] = skips[8][2] = 5;
        
        boolean visited[] = new boolean[10];
        int res = 0;
        for(int i = m; i <= n; ++i) {
            res += DFS(1, i - 1, visited, skips) * 4;
            res += DFS(4, i - 1, visited, skips) * 4;
            res += DFS(5, i - 1, visited, skips);
        }
        return res;
    }
    
    private int DFS(int cur, int remain, boolean[] visited, int[][] skips) {
        //if(remain < 0) return 0;
        if (remain == 0) return 1;
        
        visited[cur] = true;
        int res = 0;
        for(int i = 1; i <= 9; ++i) {
            if(!visited[i] && (skips[cur][i] == 0 || visited[skips[cur][i]])) {
                res += DFS(i, remain - 1, visited, skips);
            }
        }
        visited[cur] = false;
        return res;
    }
}
