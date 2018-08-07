package LeetCode0349_IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i])){
                set.add(nums1[i]);
            }
        }
        Set<Integer> intersection = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                intersection.add(nums2[i]);
            }
        }
        
        int[] res = new int[intersection.size()];
        int i = 0;
        for(Integer num : intersection){
            res[i++] = num;
        }
        return res;
    }
}