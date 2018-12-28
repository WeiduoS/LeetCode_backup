package LeetCode0433_MinimumGeneticMutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
	char[] gene = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet(Arrays.asList(bank));
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                String cur = queue.poll();
                if(cur.equals(end)) return step;
                char[] temp = cur.toCharArray();
                for(int i = 0; i < temp.length; i++) {
                    char cur_c = temp[i];
                    for(char t : gene) {
                        if(t == cur_c) continue;
                        temp[i] = t;
                        String next = new String(temp);
                        if(set.contains(next)) {
                            //System.out.println(next);
                            queue.offer(next);
                        }
                        set.remove(next);
                    }
                    temp[i] = cur_c;
                }
            }
            step++;
        }
        return -1;
    }
}
