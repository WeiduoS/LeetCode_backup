package LeetCode0373_FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	/*
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        
        int[] index = new int[nums1.length];
        
        while(k > 0) {
            int min = Integer.MAX_VALUE;
            int pos = -1;
            for(int i = 0; i < nums1.length; i++) {
                //System.out.println("pos: " + pos + ", min: " + min + ", index: " + Arrays.toString(index));
                if(index[i] >= nums2.length) continue;
                if(nums1[i] + nums2[index[i]] < min) {
                    min = nums1[i] + nums2[index[i]];
                    pos = i;
                }
            }
            if(pos == -1) break; // nums1.length * nums2.length < k
            res.add(new int[]{nums1[pos], nums2[index[pos]]});
            index[pos]++;
            //System.out.println(Arrays.toString(index));
            k--;
        }
        
        return res;
    }*/
    /*
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] + i1[1] - i2[0] - i2[1];
            }
        });
        
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        
        while(k > 0) {
            if(queue.isEmpty()) break;
            res.add(queue.poll());
            k--;
        }
        
        return res;
    }*/
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] + i1[1] - i2[0] - i2[1];
            }
        });
        for(int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(new int[]{cur[0], cur[1]});
            int index = cur[2];
            k--;
            if(index == nums2.length - 1) continue;
            queue.offer(new int[]{cur[0], nums2[index + 1], index + 1});
        }
        
        return res;
    }
}
