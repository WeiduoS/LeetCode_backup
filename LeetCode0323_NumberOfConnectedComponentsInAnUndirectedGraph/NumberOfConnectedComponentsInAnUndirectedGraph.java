package LeetCode0323_NumberOfConnectedComponentsInAnUndirectedGraph;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	/*
    class UnionFindSet {
        int[] parents;
        int[] ranks;
        int connections;
        public UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            connections = n;
            
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
             }
        }
        
        private boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            
            if(pu == pv) return false;
            
            if(ranks[u] == ranks[v]) {
                parents[pv] = pu;
                ranks[pu]++;
            }else{
                int samller = ranks[u] > ranks[v] ? pv : pu;
                int greater = ranks[u] > ranks[v] ? pu : pv;
                parents[samller] = greater;
            }
            connections--;
            return true;
        }
        
        private int find(int node) {
            while(parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return parents[node];
        }
        
        private int getConnections() {
            return connections;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UnionFindSet uf = new UnionFindSet(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getConnections();
    }*/
    
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        int connect = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;
            connect++;
            dfs(adj, i, visited);
        }
        
        return connect;
    }
    
    private void dfs(List<List<Integer>> adj, int u, Set<Integer> visited) {
        visited.add(u);
        for(Integer neighbor : adj.get(u)) {
            if(visited.contains(neighbor)) continue;
            dfs(adj, neighbor, visited);
        }
        return;
    }	
}