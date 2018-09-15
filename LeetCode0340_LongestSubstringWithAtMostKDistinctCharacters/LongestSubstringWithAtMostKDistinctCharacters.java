package LeetCode0340_LongestSubstringWithAtMostKDistinctCharacters;

public class LongestSubstringWithAtMostKDistinctCharacters {
	// solution 1: hashmap
    /*
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int longestMKD = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                longestMKD = Math.max(longestMKD, j - i + 1);
            }else{
                map.put(s.charAt(j), 1);
                if(map.size() <= k) {
                    //System.out.println("char: " + s.charAt(j) + ", " + map.size() + ", i: " + i + ", j: " + j);
                    longestMKD = Math.max(longestMKD, j - i + 1);
                }else{
                    while(map.size() > k) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                        if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                        i++;
                    }
                }
            }
        }
        
        return longestMKD;
    }*/
    // solution 2: array
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] characters = new int[256];
        int distinctChar = 0, longestMKD = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            if(characters[s.charAt(j)] == 0) {
                characters[s.charAt(j)]++;
                distinctChar++;
            }else{
                characters[s.charAt(j)]++;
            }
            if(distinctChar > k) {
                while(distinctChar > k && i < s.length() && characters[s.charAt(i)] > 0) {
                    characters[s.charAt(i)]--;
                    if(characters[s.charAt(i)] == 0) distinctChar--;
                    i++;
                }
            }
            longestMKD = Math.max(longestMKD, j - i + 1);
        }
        return longestMKD;
    } 
    /*
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }*/	
}