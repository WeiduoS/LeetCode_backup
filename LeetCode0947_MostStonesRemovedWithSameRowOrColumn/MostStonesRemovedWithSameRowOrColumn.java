package LeetCode0947_MostStonesRemovedWithSameRowOrColumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
	// solution 1: DFS
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            for(int j = i + 1; j < stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.putIfAbsent(i, new ArrayList<Integer>());
                    adj.putIfAbsent(j, new ArrayList<Integer>());
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        Set<Integer> set = new HashSet();
        for(int i = 0; i < stones.length; i++) {
            if(!set.contains(i)) {
                count++;
                DFS(i, adj, set);
            }
        }
        return stones.length - count;
    }
    
    private void DFS(int node, Map<Integer, List<Integer>> adj, Set<Integer> set) {
        set.add(node);
        if(!adj.containsKey(node)) return;
        for(Integer neighbor : adj.get(node)) {
            if(!set.contains(neighbor)) {
                DFS(neighbor, adj, set);
            }
        }
    }
    
    // solution 2: union find set
    /*
    class UnionFindSet{
        int[] parents;
        int[] ranks;
        int count;
        UnionFindSet(int n) {
            // initializal
            parents = new int[n];
            ranks = new int[n];
            count = n;
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
        }
        
        private void union(int x, int y) {
            int root_x = find(x), root_y = find(y);
            if(root_x == root_y) return;
            if(ranks[root_x] == ranks[root_y]) {
                parents[root_y] = root_x;
                ranks[root_x]++;
            }else{
                int samller = ranks[root_x] < ranks[root_y] ? parents[root_x] : parents[root_y];
                int larger = ranks[root_x] < ranks[root_y] ? parents[root_y] : parents[root_x];
                parents[samller] = larger;
            }
            count--;
            return;
        }
        
        private int find(int x) {
            int parent = parents[x];
            if(parent != x) {
                parents[x] = find(parents[parent]);
            }
            return parents[x];
        }
        
    }
    public int removeStones(int[][] stones) {
        // same row stones and their ids
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        // same col stones and their ids
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            rowMap.putIfAbsent(row, new ArrayList<>());
            colMap.putIfAbsent(col, new ArrayList<>());
            rowMap.get(row).add(i);
            colMap.get(col).add(i);
        }

        UnionFindSet uf = new UnionFindSet(stones.length);
        for(int key : rowMap.keySet()) {
            List<Integer> list = rowMap.get(key);
            int parent = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                uf.union(parent, list.get(i));
            }
        }
        
        for(int key : colMap.keySet()) {
            List<Integer> list = colMap.get(key);
            int parent = list.get(0);
            for(int i = 1; i < list.size(); i++) {
                uf.union(parent, list.get(i));
            }
        }
            
        return stones.length - uf.count;
    }*/
}
