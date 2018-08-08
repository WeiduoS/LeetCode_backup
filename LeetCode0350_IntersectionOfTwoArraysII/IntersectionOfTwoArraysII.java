package LeetCode0350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            if(!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }else{
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])  && map.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                map.put(nums2[i],  map.get(nums2[i]) - 1);
            }
        }
        int [] arr = new int[res.size()];
        int i = 0;
        Iterator<Integer> itr = res.iterator();
        while(itr.hasNext()){
            arr[i++] = (Integer)itr.next();
        }
        return arr;
    }
}