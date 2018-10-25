package LeetCode0165_CompareVersionNumbers;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
	    
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        
        int v1Index = 0, v2Index = 0;
        int v1PreSum = 0, v2PreSum = 0;
        
        while(v1Index < v1.length && v2Index < v2.length) {
            if(v1[v1Index] == '.') {
                v1Index++;
            }else{
                int tempInt = 0;
                while(v1Index < v1.length && v1[v1Index] != '.') {
                    tempInt = tempInt * 10 + (v1[v1Index] - '0');
                    v1Index++;
                }
                v1PreSum += tempInt;
            }
            
            if(v2[v2Index] == '.') {
                v2Index++;
            }else{
                int tempInt = 0;
                while(v2Index < v2.length && v2[v2Index] != '.') {
                    tempInt = tempInt * 10 + (v2[v2Index] - '0');
                    v2Index++;
                }
                v2PreSum += tempInt;
            }
            if(v1PreSum > v2PreSum) {
                return 1;
            }else if(v1PreSum < v2PreSum) {
                return -1;
            }
        }
        while (v1Index < v1.length) {
            if ( v1[v1Index] > '0' && v1[v1Index] <= '9') {
                return 1;
            }
            v1Index++;
        }
        
        while (v2Index < v2.length) {
            if ( v2[v2Index] > '0' && v2[v2Index] <= '9') {
                return -1;
            }
            v2Index++;
        }
        
        return 0;
    }	
}