package LeetCode0803_BricksFallingWhenHit;

public class BricksFallingWhenHit {
	class UnionFindSet {
        int[] parents;
        int[] ranks;
        UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        private void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            
            if(root_x == root_y) return;
            /*
            if(ranks[root_x] == ranks[root_y]) {
                parents[root_y] = root_y;
                ranks[root_x]++;
            }else{
                int smaller = ranks[root_x] < ranks[root_y] ? root_x : root_y;
                int bigger = ranks[root_x] < ranks[root_y] ? root_y : root_x;
                parents[smaller] = bigger;
            }*/
            parents[root_x] = root_y;
            ranks[root_y] += ranks[root_x];
        }
        
        private int find(int n) {
            if(n != parents[n]) parents[n] = find(parents[n]);
            return parents[n];
        }
    }
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        
        //这里的 + 1主要是多一个0来表示顶，所有的第一排的砖在unionfind的时候都会直接与这个0相连。
        UnionFindSet uf = new UnionFindSet(m * n + 1);
        
        //首先把所有要打的砖块标记为2.
        for(int[] hit : hits) {
            if(grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = 2;
        }
        
        //然后对打掉后的数组中的砖块进行四个方向的union
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) unionAround(i, j, grid, uf);
            }
        }
        int count = uf.ranks[uf.find(0)];
        int[] res = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            if(grid[hit[0]][hit[1]] == 2) {
                // 对于需要复原的这个砖块做四个方向union，主要是为了得到有多少砖必须通过这块砖才能连接到顶部。
                unionAround(hit[0], hit[1], grid, uf);
                grid[hit[0]][hit[1]] = 1;
            }
            int size = uf.ranks[uf.find(0)];
            res[i] = (size - count > 0) ? size - count - 1 : 0;
            count = size;
        }
        return res;
    }
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void unionAround(int x, int y, int[][] grid, UnionFindSet uf) {
        int m = grid.length, n = grid[0].length;
        for(int[] dir : dirs) {
            int r = x + dir[0];
            int c = y + dir[1];
            if(r < 0 || r >= m || c < 0 || c >= n) continue;
            if(grid[r][c] == 1) uf.union(x * n + y + 1, r * n + c + 1);
        }
        if(x == 0) uf.union(x * n + y + 1, 0);
    }
}
