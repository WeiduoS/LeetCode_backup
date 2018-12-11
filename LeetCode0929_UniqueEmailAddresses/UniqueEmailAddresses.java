package LeetCode0929_UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails) {

            int i = email.lastIndexOf("@");
            String addr = email.substring(0, i);
            String dom = email.substring(i + 1);

            if(addr.contains("+")) addr = addr.substring(0, addr.indexOf("+"));
            
            String posAddr = "";
            /*
            for(char c : addr.toCharArray()) {
                if(c != '.') posAddr += c;
            }*/
            posAddr = addr.replaceAll(".", "");

            set.add(posAddr + "@" + dom);
        }
        //for(String s : set) System.out.println(s);
        return set.size();
    }
}
