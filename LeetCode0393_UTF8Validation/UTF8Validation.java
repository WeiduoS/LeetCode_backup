package LeetCode0393_UTF8Validation;

public class UTF8Validation {
	/*
     * 这道题考察我们UTF-8编码，这种互联网所采用的通用的编码格式的产生是为了解决ASCII只能表示英文字符的局限性，和统一Unicode的实现方式。下面这段摘自维 
     * 基百科UTF-8编码：
     *
     * 对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)；
     * 如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)；
     * 如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节；
     * 如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节；
     * 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节；
     */
    
    public boolean validUtf8(int[] data) {
        int numByte = 0;
        
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        
        for(int i = 0; i < data.length; i++) {
            if(numByte == 0) {
                int mask = 1 << 7;
                while((mask & data[i]) != 0) {
                    numByte++;
                    mask = mask >> 1;
                }
                
                // 1 byte characters
                if(numByte == 0) continue;
                
                // Invalid scenarios according to the rules of the problem.
                if (numByte > 4 || numByte == 1) {
                    return false;
                }
                
            }else{
                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                    return false;
                }
            }
            numByte -= 1;
        }
        
        return numByte == 0;
    }
}
