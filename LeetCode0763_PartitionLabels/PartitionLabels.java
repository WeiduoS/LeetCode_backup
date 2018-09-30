package LeetCode0763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	 public List<Integer> partitionLabels(String S) {
	        List<Integer> res = new ArrayList<>();
	        if(S == null || S.length() == 0) return res;
	        int len = S.length();
	        int[] lastOccur = new int[26];
	        for(int i = 0; i < len; i++) {
	            lastOccur[S.charAt(i) - 'a'] = i;
	        }
	        int end = lastOccur[S.charAt(0) - 'a'];
	        for(int i = 0, j = 0; i < len; i++) {
	            if(lastOccur[S.charAt(i) - 'a'] > end) {
	                end = lastOccur[S.charAt(i) - 'a'];
	            }
	            if(i == end) {
	                res.add(i - j + 1);
	                j = i + 1;
	            }
	        }
	        return res;
	    }	
}