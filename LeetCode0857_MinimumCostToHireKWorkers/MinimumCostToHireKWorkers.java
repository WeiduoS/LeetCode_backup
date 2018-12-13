package LeetCode0857_MinimumCostToHireKWorkers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = wage.length;
        double[][] workers = new double[n][2];
        for(int i = 0; i < n; i++) {
            workers[i] = new double[] {(double)wage[i] / quality[i], (double)quality[i]};
        }
        
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        //for(double[] worker : workers) System.out.println(Arrays.toString(worker));
        double res = Double.MAX_VALUE, sum = 0;
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for(double[] worker : workers) {
            sum += worker[1];
            q.add(worker[1]);
            if(q.size() > K) sum -= q.poll();
            if(q.size() == K) res = Math.min(res, sum * worker[0]);
        }
        return res;
    }
}
