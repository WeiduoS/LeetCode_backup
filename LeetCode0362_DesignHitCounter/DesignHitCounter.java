package LeetCode0362_DesignHitCounter;

public class DesignHitCounter {
	/*
    Queue<Integer> queue;
    
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp - queue.peek() >= 300) queue.poll();
        return queue.size();
    }*/
    /*
    List<Integer> list;
    
    public HitCounter() {
        list = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int i;
        for(i = 0; i < list.size(); i++) {
            if(list.get(i) > timestamp - 300) break;
        }
        return list.size() - i;
    }*/
    
    /*由于Follow up中说每秒中会有很多点击，下面这种方法就比较巧妙了，定义了两个大小为300的一维数组times和hits，分别用来保存时间戳和点击数，在点击函数
     *中，将时间戳对300取余，然后看此位置中之前保存的时间戳和当前的时间戳是否一样，一样说明是同一个时间戳，那么对应的点击数自增1，如果不一样，说明已经过
     *了五分钟了，那么将对应的点击数重置为1。那么在返回点击数时，我们需要遍历times数组，找出所有在5分中内的位置，然后把hits中对应位置的点击数都加起来即
     *可
     */
    
    int[] times, hits;
    
    public void HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        }else{
            hits[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++) {
            if(timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }	
}