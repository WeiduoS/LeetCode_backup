package LeetCode0134_GasStation;

public class GasStation {
	// worse answer
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int start = 0; start < len; start++) {
            if(gas[start] >= cost[start]) {
                int tank = gas[start];
                int used = cost[start];
                int next = (start + 1) % gas.length;
                while((tank - used) >= 0) {
                    tank = tank - used + gas[next];
                    used = cost[next];
                    if(next == start) return start;
                    next = (next + 1) % gas.length;
                }
            }
        }
        return -1;
    }*/
    // worse answer
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(len == 0) return 0;
        int[] used = new int[len];
        for(int i = 0; i < len; i++) {
            used[i] = gas[i] - cost[i];
        }
        for(int start = 0; start < len; start++) {
            if(used[start] >= 0) {
                int cur = (start + 1) % len;
                int sum = used[start];
                while(sum >= 0) {
                    sum += used[cur];
                        //System.out.println("start :" + start + ", cur: " + cur);
                    if(cur == start) return start;
                    cur = (cur + 1) % len;
                }
            }
        }
        return -1;
    }*/
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(len == 0) return 0;
        int[] used = new int[len];
        for(int i = 0; i < len; i++) {
            used[i] = gas[i] - cost[i];
        }
        int preSum = 0;
        for(int i = 0; i < len; i++) {
            preSum += used[i];
        }
        if(preSum < 0) return -1;
        for(int i = 0; i < len; i++) {
            int sum = 0;
            int start = i;
            while(start < len && sum + used[start] >= 0) {
                sum += used[start];
                start++;
            }
            if(start == len) return i;
            i = start;
        }
        return -1;
    }*/
    
    
    /*
     * case 1: -1, -1, 1, 1   -> start: 2
     * case 2: -1, -1, -1, 1 , 1  -> failed
     * case 3: -1, -1, 1, -2, 1, 1, 1, 1 -> start: 4
     */
    // only consider the current start gas if enough
    // and the total gas if enough, then return the current start
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }	
}