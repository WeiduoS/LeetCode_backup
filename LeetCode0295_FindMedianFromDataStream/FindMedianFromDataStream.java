package LeetCode0295_FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	Queue<Integer> greater ;
    Queue<Integer> smaller;
    
    /** initialize your data structure here. 
     * @return */
    
    public void MedianFinder() {
        greater = new PriorityQueue<>();
        smaller = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }
    
    
    public void addNum(int num) {
        greater.add(num);
        smaller.add(greater.poll());
        if(greater.size() < smaller.size()) greater.add(smaller.poll());
    }
    
    public double findMedian() {
        if(greater.size() == smaller.size()) {
            return ((double)greater.peek() + smaller.peek()) / 2.0;
        }else{
            return greater.peek();
        }
    }	
}