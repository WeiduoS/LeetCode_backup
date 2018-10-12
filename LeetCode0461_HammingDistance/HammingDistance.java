package LeetCode0461_HammingDistance;

public class HammingDistance {
	/*
    public int hammingDistance(int x, int y) {
        int diff = 0;
        for(int i = 0; i < 31; i++) {
            int xR = x % 2;
            int yR = y % 2;
            if(xR != yR) diff++;
            x /= 2;
            y /= 2;
        }
        return diff;
    }*/
    public int hammingDistance(int x, int y) {
        int XOR = x ^ y;
        int diff = 0;
        
        while(XOR > 0) {
            diff += XOR & 1;
            XOR /= 2;
        }
        
        return diff;
    }	
}