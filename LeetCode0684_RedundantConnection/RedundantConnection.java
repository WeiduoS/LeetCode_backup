package LeetCode0684_RedundantConnection;

public class RedundantConnection {
	 // solution 1: bfs
    /*
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < edges.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            Set<Integer> set = new HashSet<>();
            if(dfs(adjList, u, v, set)) return edge;
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return new int[0];
    }
    
    private boolean dfs(List<List<Integer>> adjList, int u, int v, Set<Integer> set) {
        if(u == v) return true;
        set.add(u);
        for(int neighbor : adjList.get(u)) {
            if(set.contains(neighbor)) continue;
            if(dfs(adjList, neighbor, v, set)) return true;
        }
        return false;
    }*/
    
    // solution 2: union find
    class UnionFindSet {
        private int[] parents;
        private int[] ranks;
        
        public UnionFindSet(int n) {
            this.parents = new int[n + 1];
            this.ranks = new int[n + 1];
            for(int i = 0; i < parents.length; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return false;
            if(ranks[v] > ranks[u]) {
                parents[pu] = pv;
            }else if(ranks[u] > ranks[v]) {
                parents[pv] = pu;
            }else {
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
            return node;
        }
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet s = new UnionFindSet(edges.length);
        for(int[] edge : edges) {
            if(!s.union(edge[0], edge[1])) return edge;
        }
        return new int[0];
    }	
}