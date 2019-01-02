package LeetCode0381_InsertDeleteGetRandomO1DuplicatesAllowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1DuplicatesAllowed {
	List<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    Random random;
    // Initialize your data structure here. 
    public void RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random(); 
    }
    
    // Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
    public boolean insert(int val) {
        boolean has = map.containsKey(val);
        if(!has) {
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !has;
    }
    
    // Removes a value from the collection. Returns true if the collection contained the specified element.
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        
        Set<Integer> set1 = map.get(val);
        int Rindex = set1.iterator().next();
        set1.remove(Rindex);
        if(Rindex != list.size() - 1) {
            int last = list.get(list.size() - 1);
            Set<Integer> set2 = map.get(last);
            list.set(Rindex, last);
            set2.remove(list.size() - 1);
            set2.add(Rindex);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    // Get a random element from the collection. 
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}
