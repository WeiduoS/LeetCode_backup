package LeetCode0847_ShortestPathVisitingAllNodes;

import java.util.Arrays;

public class ShortestPathVisitingAllNodes {
	/*
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for(int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }
        
        int target = (1 << n)  - 1;
        
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int pos = curr[0], state = curr[1];
                
                for(int neighbor : graph[pos]) {
                    int nextState = state | (1 << neighbor);
                    if(nextState == target) return step + 1;
                    // every time we should find a new node
                    if(visited[neighbor][nextState] == true) continue;
                    
                    visited[neighbor][nextState] = true;
                    queue.offer(new int[]{neighbor, nextState});
                }
            }
            step++;
        }
        
        return 0;
    }*/
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int dist[][] = new int[1 << N][N];
        // init floyd-Warshall algorithm
        for (int[] row: dist) Arrays.fill(row, N*N);
        for (int x = 0; x < N; ++x) {
            dist[1<<x][x] = 0;
        }
        /*
        for(int i = 0; i < dist.length; i++) {
            System.out.println("i: " + i + " " + Arrays.toString(dist[i]));
        }*/
        for(int cover = 0; cover < (1 << N); cover++) {
            boolean repeat = true;
            while(repeat) {
                repeat = false;
                for(int head = 0; head < N; head++) {
                    int d = dist[cover][head];
                    for(int next : graph[head]) {
                        int cover2 = cover | (1 << next);
                        if (d + 1 < dist[cover2][next]) {
                            dist[cover2][next] = d + 1;
                            if (cover == cover2) repeat = true;
                        }
                    }
                }
            }
        }
        
        int ans = N*N;
        for (int cand: dist[(1<<N) - 1])
            ans = Math.min(cand, ans);
        return ans;
    }	
}