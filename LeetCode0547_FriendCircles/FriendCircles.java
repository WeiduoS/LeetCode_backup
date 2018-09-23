package LeetCode0547_FriendCircles;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {
	/*
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;
        int[] visited = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                count++;
                dfs(M, visited, i);
                //System.out.println(Arrays.deepToString(visit));
            }
        }
        return count;
    }
    private void dfs(int[][] M, int[] visited, int cur) {
        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 0 && M[cur][i] == 1) {
                visited[i] = 1;
                dfs(M, visited, i);
            }
        }
    }*/
    
    class UnionFindSet {
        private int[] parents;
        private int[] ranks;
        
        public UnionFindSet(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
        }
        
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return false;
            if(ranks[u] > ranks[v]) {
                parents[pv] = pu;
            }else if(ranks[v] > ranks[u]) {
                parents[pu] = pv;
            }else{
                parents[pv] = pu;
                ranks[pu] += 1;
            }
            return true;
        }
        
        public int find(int node) {
            while(parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return parents[node];
        }
    }
     public int findCircleNum(int[][] M) {
         int n = M.length;
         if(M == null || n == 0) return 0;
         UnionFindSet s = new UnionFindSet(n);
         for(int i = 0; i < n; i++) {
             for(int j = i + 1; j < M[0].length; j++) {
                 if(M[i][j] == 1) {
                     s.union(i, j);
                 }
             }
         }
         Set<Integer> set = new HashSet<>();
         for(int i = 0; i < n; i++) {
             set.add(s.find(i));
         }
         return set.size();
     }	
}