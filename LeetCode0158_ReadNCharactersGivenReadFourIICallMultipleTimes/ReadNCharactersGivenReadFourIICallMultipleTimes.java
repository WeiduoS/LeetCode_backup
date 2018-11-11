package LeetCode0158_ReadNCharactersGivenReadFourIICallMultipleTimes;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenReadFourIICallMultipleTimes {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    /*
    private int preIndex = 0;
    private int delta = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n) {
            if(preIndex == 0) delta = read4(temp);
            
            if(delta == 0) break;
            
            while(index < n && preIndex < delta) {
                buf[index++] = temp[preIndex++];
            }
            if(preIndex >= delta) preIndex = 0;
        } 
        
        return index;
    }*/
    
    Queue<Character> queue = new LinkedList<>();
    public int read(char[] buf, int n) {
        int index = 0;
        
        while(!queue.isEmpty() && index < n) buf[index++] = queue.poll();
        
        if(index == n) return n;
        
        char[] temp = new char[4];
        
        while(index < n) {
            int delta = read4(temp);
        
            int i = 0;
            for(; i < delta && index < n; i++) {
                buf[index++] = temp[i];
            }
        
            while(i < delta) queue.offer(temp[i++]);
        
            if(delta < 4) break;
        }
        
        return index;
    }
	private int read4(char[] temp) {
		// TODO Auto-generated method stub
		return 0;
	}
}
