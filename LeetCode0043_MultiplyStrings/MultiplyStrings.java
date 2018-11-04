package LeetCode0043_MultiplyStrings;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int[] mul = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int lowPos = i + j + 1;
                int highPos = i + j;
                product += mul[lowPos];
                mul[lowPos] = product % 10;
                mul[highPos] += product / 10;
            }
        }
        
        String res = "";
        int index;
        for(index = 0; index < mul.length;) {
            if(mul[index] == 0) {
                index++;
            }else{
                break;
            }
        }
        for(int i = index; i < mul.length; i++) res += String.valueOf(mul[i]);
        
        return res.length() == 0 ? "0" : res;
    }	
}