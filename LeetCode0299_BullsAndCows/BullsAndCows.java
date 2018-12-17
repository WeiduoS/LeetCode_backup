package LeetCode0299_BullsAndCows;

public class BullsAndCows {
	/*
    public String getHint(String secret, String guess) {
        int[] characters = new int[256];
        int bulls = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }else{
                characters[secret.charAt(i)]++;
            }
        }
        int cows = 0;
        for(int i = 0; i < guess.length(); i++){
            if(secret.charAt(i) != guess.charAt(i) && characters[guess.charAt(i)] > 0) {
                characters[guess.charAt(i)]--;
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }*/
    public String getHint(String secret, String guess) {
        int[] characters = new int[256];
        int bulls = 0, cows = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }else{
                // 我们看如果secret当前位置数字的映射值小于0, 则表示其在guess中出现过
                if(characters[secret.charAt(i)] < 0) cows++;
                // 如果guess当前位置的数字的映射值大于0，则表示其在secret中出现过
                if(characters[guess.charAt(i)] > 0) cows++;
                characters[secret.charAt(i)]++;
                characters[guess.charAt(i)]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
