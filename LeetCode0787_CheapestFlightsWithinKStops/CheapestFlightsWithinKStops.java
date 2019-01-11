package LeetCode0787_CheapestFlightsWithinKStops;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
	/*
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] f : flights) {
            map.computeIfAbsent(f[0], x -> new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], city = cur[1], k = cur[2];
            if(city == dst) return cost;
            if(k > K) continue;
            Map<Integer, Integer> neigh = map.getOrDefault(city, new HashMap<>());
            for(int next : neigh.keySet()) {
                pq.offer(new int[]{cost + neigh.get(next), next, k + 1});
            }
        }
        return -1;
    }*/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int INF = (int)1e9;
        int[][] dp = new int[K + 2][n];
        for(int[] row : dp) Arrays.fill(row, INF);
        dp[0][src] = 0;
        for(int i = 1; i <= K + 1; i++) {
            dp[i][src] = 0;
            for(int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i][f[0]] + f[2]);
            }
        }
        return dp[K + 1][dst] >= 1e9 ? -1 : dp[K + 1][dst];
    }
}
