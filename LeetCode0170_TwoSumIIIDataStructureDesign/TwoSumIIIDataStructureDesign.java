package LeetCode0170_TwoSumIIIDataStructureDesign;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStructureDesign {
	Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIIIDataStructureDesign() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number)) {
            map.put(number, 1);
        }else{
            map.put(number, map.get(number) + 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        //if(map.containsKey(value / 2) && map.get(value / 2) == 2) return true;
        for(Integer n : map.keySet()) {
            if(map.containsKey(value - n) && (n != value - n)) {
                return true;
            }
            if(n == value - n && map.get(n) == 2) return true;
        }
        return false;
    }
}