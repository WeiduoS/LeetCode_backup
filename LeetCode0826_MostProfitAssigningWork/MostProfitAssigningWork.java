package LeetCode0826_MostProfitAssigningWork;

import java.util.Arrays;

public class MostProfitAssigningWork {
	class Pair{
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        String print() {
            return "[" + this.a + "," + this.b + "]";
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Pair[] arr = new Pair[profit.length];
        for(int i = 0; i < profit.length; i++) {
            arr[i] = new Pair(difficulty[i], profit[i]);
        }
        Arrays.sort(arr, (a, b) -> (a.a - b.a));
        Arrays.sort(worker);
        //for(Pair p : arr) System.out.println(p.print());
        int res = 0, max = 0, i = 0, n = profit.length;
        for(int w : worker) {
            while(i < n && arr[i].a <= w) {
                max = Math.max(max, arr[i].b);
                i++;
            }
            res += max;
        }
        return res;
    }
}
