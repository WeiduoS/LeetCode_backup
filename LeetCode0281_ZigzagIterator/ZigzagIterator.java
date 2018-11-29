package LeetCode0281_ZigzagIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	public List<Iterator<Integer>> its;
    public int turns;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        ArrayList<List<Integer>> vecs = new ArrayList<>();
        vecs.add(v1);
        vecs.add(v2);
        ZigzagIterator2(vecs);
    }
    
    public void ZigzagIterator2(List<List<Integer>> vecs) {
        this.its = new ArrayList<Iterator<Integer>>();
        for(List<Integer> vec : vecs) {
            if(vec.size() > 0) {
                its.add(vec.iterator());
            }
        }
        turns = 0;
    }

    public int next() {
        int elem = its.get(turns).next();
        if(its.get(turns).hasNext()) {
            turns = (turns + 1) % its.size();
        }else{
            its.remove(turns);
            if(its.size() > 0) turns %= its.size();
        }
        return elem;
    }

    public boolean hasNext() {
        return its.size() > 0;
    }
}
