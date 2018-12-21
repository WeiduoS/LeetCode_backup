package LeetCode0800_SimilarRGBColor;

public class SimilarRGBColor {
	public String similarRGB(String color) {
        return "#" + helper(color.substring(1, 3)) + helper(color.substring(3, 5)) + helper(color.substring(5));
    }
    
    private String helper(String str) {
        int hex = Integer.parseInt(str, 16);
        int t = hex / 17 + (hex % 17 > 8 ? 1 : 0);
        return String.format("%02x", t * 17);
    }
}
