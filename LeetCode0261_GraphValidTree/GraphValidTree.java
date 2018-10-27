package LeetCode0261_GraphValidTree;

public class GraphValidTree {
	// solution 1: DFS
    /*
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<Integer>());
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if(hasCycle(adjList, 0, -1, visited)) return false;
        
        for(boolean v : visited) {
            if(v == false) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> adjList, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for(int neighbor : adjList.get(u)) {
            if(neighbor == parent) continue;
            if(visited[neighbor]) return true;
            if(hasCycle(adjList, neighbor, u, visited)) return true;
        }
        return false;
    }*/
    class UnionFindSet {
        private int[] parents;
        private int[] ranks;
        private int node;
        public UnionFindSet(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            this.node = n;
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public boolean union(int u, int v) {
            //System.out.println(Arrays.toString(parents));
            int pu = find(u);
            int pv = find(v);
            //System.out.println("u: " + u + ", v: " + v);
            if(pu == pv) return false;
            //System.out.println("pu == pv: " + (pu == pv));
            
            if(ranks[u] > ranks[v]) {
                parents[v] = pu;
            }else if(ranks[u] < ranks[v]){
                parents[u] = pv;
            }else{
                if(u < v) {
                    parents[v] = pu;
                    ranks[pu] += 1; 
                }else{
                    parents[u] = pv;
                    ranks[pv] += 1;  
                }
            }
            
            node--;
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
    public boolean validTree(int n, int[][] edges) {
        UnionFindSet s = new UnionFindSet(n);
        for(int[] edge : edges) {
            boolean diffSet = s.union(edge[0], edge[1]);
            //System.out.println("edge[0]: " + edge[0] + ", edge[1]: " + edge[1] + ", sameSet: " + sameSet);
            if(!diffSet) return false;
        }
        return s.node == 1;
    }	
}