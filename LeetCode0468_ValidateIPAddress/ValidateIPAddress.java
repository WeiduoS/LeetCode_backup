package LeetCode0468_ValidateIPAddress;

import java.util.Arrays;

public class ValidateIPAddress {
	public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0) return "Neither";
        if(isIpV4(IP)){
            return "IPv4";
        }else if(isIpV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    private boolean isIpV6(String ip) {
        // https://www.geeksforgeeks.org/split-string-java-examples/
        String[] splits = ip.split(":", -1);
        if(splits.length != 8) return false;
        for(String str : splits) {
            try {
                int val = Integer.parseInt(str, 16);
                if(val < 0 || val > ((1 << 16) - 1)) return false;
            }catch(Exception e) {
                return false;
            }
            if(str.charAt(0) == '-' || str.charAt(0) == '+') return false;
            if(str.length() > 4) return false;
        }
        return true;
    }
    private boolean isIpV4(String ip) {
        String[] splits = ip.split("\\.", -1);
        if(splits.length != 4) return false;
        for(String str : splits) {
            try{
                int val = Integer.parseInt(str, 10);
                if(val < 0 || val > ((1 << 8) - 1)) return false;
            }catch(Exception e) {
                return false;
            }
            if(str.charAt(0) == '-' || str.charAt(0) == '+') return false;
            if(str.charAt(0) == '0' && str.length() > 1) return false;
        }
        return true;
    }
}
