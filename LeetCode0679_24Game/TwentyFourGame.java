package LeetCode0679_24Game;

import java.util.ArrayList;
import java.util.List;

public class TwentyFourGame {
	public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int num : nums) list.add((double) num);
        return dfs(list);
    }
    
    private boolean dfs(List<Double> list) {
        if(list.size() == 1) {
            if (Math.abs(list.get(0)- 24.0) < 0.001) {
                return true;
            }
            return false;
        }
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                for(double c : compute(list.get(i), list.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(c);
                    for(int k = 0; k < list.size(); k++) {
                        if(k == i || k == j) continue;
                        next.add(list.get(k));
                    }
                    if(dfs(next)) return true;
                };
            }
        }
        return false;
    }
    
    private List<Double> compute(double x, double y) {
        ArrayList<Double> res = new ArrayList<>();
        res.add(x + y);
        res.add(x - y);
        res.add(y - x);
        res.add(x * y);
        res.add(x / y);
        res.add(y / x);
        return res;
    }
}
