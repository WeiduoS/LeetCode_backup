package LeetCode0310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adj.add(new HashSet<Integer>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if(adj.get(i).size() == 1) leaves.add(i);
        }
        //System.out.println(leaves);
        
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leave : leaves) {
                int neighbor = adj.get(leave).iterator().next();
                adj.get(neighbor).remove(leave);
                if(adj.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
