package LeetCode0621_TaskScheduler;

import java.util.Arrays;

public class TaskScheduler {
	// solution 1: sort
    /*
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks)  map[task - 'A']++;
        Arrays.sort(map);
        //System.out.println(Arrays.toString(map));
        int time = 0;
        while(map[25] > 0) {
            int i = 0;
            while(i <= n) {
                if(map[25] == 0) break;
                if(i < 26 && map[25 - i] > 0) map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }*/
    
    // solution 2: priority queue
    /*
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks)  map[task - 'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for(int f : map) {
            if(f > 0) queue.add(f);
        }
        
        int time = 0;
        
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while(i <= n) {
                if(!queue.isEmpty()) {
                    if(queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    }else{
                        queue.poll();
                    }
                }
                time++;
                if(queue.isEmpty() && temp.size() == 0) break;
                i++;
            }
            for(int task : temp) queue.add(task);
        }
        return time;
    }*/
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks)  map[task - 'A']++;
        Arrays.sort(map);
        int maxFre = map[25] - 1;
        int slots = maxFre * n;
        for(int i = 24; i >= 0 && map[i] > 0; i--) {
            slots -= Math.min(map[i], maxFre);
        }
        
        return slots > 0 ? slots + tasks.length : tasks.length;
    }	
}