package LeetCode0302_SmallestRectangleEnclosingBlackPixels;

public class SmallestRectangleEnclosingBlackPixels {
	char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int m = image.length, n = image[0].length;
        int left = searchColumn(0, y, 0, m, true);
        int right = searchColumn(y + 1, n, 0, m, false);
        int top = searchRow(0, x, left, right, true);
        int bottom = searchRow(x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchRow(int i , int j, int left, int right, boolean opt) {
        while(i != j) {
            int k = left, mid = i + (j - i) / 2;
            while(k < right && image[mid][k] == '0') k++;
            if(k < right == opt) {
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
    private int searchColumn(int i , int j, int top, int bottom, boolean opt) {
        while(i != j) {
            int k = top, mid = i + (j - i) / 2;
            while(k < bottom && image[k][mid] == '0') k++;
            if(k < bottom == opt) {
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
}
