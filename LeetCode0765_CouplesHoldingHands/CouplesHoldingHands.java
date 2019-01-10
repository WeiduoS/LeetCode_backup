package LeetCode0765_CouplesHoldingHands;

public class CouplesHoldingHands {
	/*
    public int minSwapsCouples(int[] row) {
        int res = 0, n = row.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(row[i], i);
        }
        for(int i = 0; i < n - 1; i += 2) {
            if((row[i] ^ 1) ==  row[i + 1]) continue;
            res ++;
            int find_pos = map.get((row[i] ^ 1));
            int change_num = row[i + 1];
            int temp = row[find_pos];
            row[find_pos] = row[i + 1];
            row[i + 1] = temp;
            map.put(change_num, find_pos);
            map.put(row[i + 1],i + 1);
        }
        return res;
    }*/
    public int minSwapsCouples(int[] row) {
        int res = 0, n = row.length, cnt = n / 2;
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < n; i += 2) {
            int x = find(parents, row[i] / 2);
            int y = find(parents, row[i + 1] / 2);
            if(x != y) {
                parents[y] = x;
                cnt--;
            }
        }
        return n / 2 - cnt;
    }
    
    private int find(int[] parents, int x) {
        if(x != parents[x]) parents[x] = find(parents, parents[parents[x]]);
        return parents[x];
    }
}
