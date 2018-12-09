package LeetCode0952_LargestComponentSizeByCommonFactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestComponentSizeByCommonFactor {
	class UnionFindSet {
        int[] parents;
        int[] ranks;
        UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
        }
        
        private void union(int x, int y) {
            int parent_x = find(x);
            int parent_y = find(y);
            
            if(parent_x == parent_y) return;
            
            if(ranks[parent_x] > ranks[parent_y]) {
                parents[parent_y] = parent_x;
            }else if(ranks[parent_x] < ranks[parent_y]){
                parents[parent_x] = parent_y;
            }else{
                parents[parent_y] = parent_x;
                ranks[parent_x]++;
            }
        }
        
        private int find(int x) {
            if(parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
    public int largestComponentSize(int[] A) {
        
        ArrayList<Integer>[] factors = new ArrayList[A.length];
        for (int i = 0; i < A.length; ++i) {
            factors[i] = new ArrayList<Integer>();
            int d = 2, x = A[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0)
                        x /= d;
                    factors[i].add(d);
                }

                d++;
            }

            if (x > 1 || factors[i].isEmpty())
                factors[i].add(x);
        }
        /*
        for(ArrayList<Integer> factor : factors) {
            for(Integer x : factor) {
                System.out.println(x);
            }
            System.out.println("------");
        }*/
        
        Set<Integer> primes = new HashSet<>();
        for(ArrayList<Integer> factor : factors) {
            for(Integer x : factor) primes.add(x);
        }
        
        int[] primes_index = new int[primes.size()];
        int index = 0;
        for(Integer prime : primes) {
            primes_index[index++] = prime;
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < primes_index.length; i++) {
            map.put(primes_index[i], i);
        }
        /*
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("entry.getKey(): " + entry.getKey() + ", entry.getValue(): " + entry.getValue());
        }*/
        UnionFindSet uf = new UnionFindSet(primes_index.length);
        for(ArrayList<Integer> factor : factors) {
            for(Integer x : factor) {
                uf.union(map.get(factor.get(0)), map.get(x));
            }
        }
        
        int[] count = new int[primes_index.length];
        for(ArrayList<Integer> factor : factors) {
            count[uf.find(map.get(factor.get(0)))]++;
        }
        
        int res = 0;
        for (int x: count)
            if (x > res) res = x;
        return res;
    }
}
