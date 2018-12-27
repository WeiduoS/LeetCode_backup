package LeetCode0959_RegionsCutBySlashes;

public class RegionsCutBySlashes {
	class UnionFindSet {
        int[] parents;
        UnionFindSet(int n) {
            parents = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        private int find(int x) {
            if(parents[x] != x) parents[x] = find(parents[x]);
            return parents[x];
        }
        private void union(int x, int y) {
            parents[find(x)] = find(y);
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFindSet uf = new UnionFindSet(n * n * 4);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char slash = grid[i].charAt(j);
                if(slash == '/') {
                    uf.union(index + 0, index + 3);
                    uf.union(index + 1, index + 2);
                }else if(slash == '\\') {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 2, index + 3);
                }else{
                    uf.union(index + 0, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                if(i < n - 1) uf.union(index + 2, index + 4 * n + 0);
                if(j < n - 1) uf.union(index + 1, index + 4 + 3);
            }
        }
        int res = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (uf.find(i) == i) res++;
        }

        return res;
    }
}
