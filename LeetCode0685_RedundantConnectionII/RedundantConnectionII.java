package LeetCode0685_RedundantConnectionII;

public class RedundantConnectionII {
	// solution 1: DFS
    /*
    public int[] findRedundantDirectedConnection(int[][] edges) {
        final int n = edges.length;
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        final Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            adjList.put(i, new HashSet<>());
        }
        
        int edgeTo = -1;
        for(final int[] edge : edges) {
            outdegree[edge[0]]++;
            indegree[edge[1]]++;
            if(indegree[edge[1]] > 1) {
                edgeTo = edge[1];
            }
            adjList.get(edge[0]).add(edge[1]);
        }
        
        int[] res = null;
        if(edgeTo != -1) {
            int root = -1;
            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) root = i;
            }
            
            for(int i = n - 1; i >= 0; i--) {
                if(edges[i][1] == edgeTo) {
                    if(tryDeleteEdge(edges[i][0], edges[i][1], root, adjList)) {
                        res = edges[i];
                        break;
                    }
                }
            }
        }else{
            for(int i = n - 1; i >= 0; i--) {
                int from = edges[i][0];
                int to = edges[i][1];
                
                //if(indegree[v] == 1 && outdegree[w] == 1) {
                //    continue;
                //}else if(indegree[v] == 1) {
                //    res = edges[i];
                //}
                if(to == 1) res = edges[i];
            }
        }
        
        return res;
    }
    
    private boolean tryDeleteEdge(int v, int w, int root, Map<Integer, Set<Integer>> adjList) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root, v, w, adjList, set);
        return set.size() == adjList.size();
    }
    
    private void dfs(int v, int from, int to, Map<Integer, Set<Integer>> adjList, HashSet<Integer> set) {
        set.add(v);
        for(Integer neighbor : adjList.get(v)) {
            if(!set.contains(neighbor) && (v != from || neighbor != to)) {
                dfs(neighbor, from, to, adjList, set);
            }
        }
    }*/
    // solution 2: union find set
    
    class UnionFindSet{
        int[] parents, ranks;
        
        UnionFindSet(int n) {
            parents = new int[n + 1];
            ranks = new int[n + 1];
            
            for(int i = 0; i <= n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            } 
        }
        
        public int find(int node) {
            while(node != parents[node]) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return parents[node];
        }
        
        public boolean union(int a, int b) {
            int a_parent = find(a);
            int b_parent = find(b);
            if(a_parent == b_parent) return false;
            
            if(ranks[a_parent] == ranks[b_parent]) {
                parents[b_parent] = a_parent;
                ranks[a_parent]++;
            }else{
                int samller = ranks[a_parent] < ranks[b_parent] ? a_parent : b_parent;
                int larger = ranks[a_parent] > ranks[b_parent] ? a_parent : b_parent;
                parents[samller] = larger;
            }
            return true;
        }
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] ans1 = new int[]{-1, -1};
        int[] ans2 = new int[]{-1, -1};
        for(int[] edge : edges) {
            if(parents[edge[1]] != 0) {
                ans1 = new int[]{parents[edge[1]], edge[1]};
                ans2 = new int[]{edge[0], edge[1]};
                edge[0] = edge[1] = 0;
            }else{
                parents[edge[1]] = edge[0];
            }
        }
        //System.out.println("ans1: " + Arrays.toString(ans1));
        //System.out.println("ans2: " + Arrays.toString(ans2));
        UnionFindSet uf = new UnionFindSet(edges.length);
        for(int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                if (edge[1] == 0) continue;
                //System.out.println("find: " + Arrays.toString(edge));
                return ans1[0] == -1 ? edge : ans1;
            }
        }
        return ans2;
    }
}
