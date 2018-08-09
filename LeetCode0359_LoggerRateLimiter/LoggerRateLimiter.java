package LeetCode0359_LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. 
     * @return */
    public  LoggerRateLimiter() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp - map.get(message) >= 10){
                map.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
    }
}