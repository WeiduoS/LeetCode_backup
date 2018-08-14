package LeetCode0751_IPToCIDR;

import java.util.ArrayList;
import java.util.List;

public class IPToCIDR {
	public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> res = new ArrayList<>();
        //System.out.println(start);
        while(n > 0) {
            //System.out.println(start);
            //System.out.println(Long.lowestOneBit(start));
            int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)), 33 - bitLength(n));
            //System.out.println(mask);
            res.add(longToIp(start) + "/" + mask);
            start = start + (1 << (32 - mask));
            // x^2 >= n
            n = n - (1 << (32 - mask));
        }
        //System.out.println(Long.lowestOneBit(start));
        
        return res;
    }
    private long ipToLong(String ip) {
        long res = 0;
        for(String s : ip.split("\\.")) {
            res = 256 * res + Integer.valueOf(s);
        }
        return res;
    }
    private int bitLength(long x) {
        if(x == 0) return 1;
        int res = 0;
        while(x > 0){
            x >>= 1;
            res++;
        }
        return res;
    }
    private String longToIp(long x) {
        return String.format("%s.%s.%s.%s", x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
    }	
}