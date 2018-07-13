package LeetCode0011_ContainerWithMostWater;

public class ContainerWithMostWater {
	private static int solution(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		
		while(left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			
			if(height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] height = {1, 1};
		
		int res = solution(height);
		
		System.out.println(res);
	}
}