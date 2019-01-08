package LeetCode0223_RectangleArea;

public class RectangleArea {
	class Rectangle {
        int x;
        int y;
        int w;
        int h;
        Rectangle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rectangle overlap = new Rectangle(0, 0, 0, 0);
        if(check(A, B, C - A, D - B, E, F, G - E, H - F)) {
            overlap = new Rectangle(Math.max(A, E), Math.max(B, F), Math.min(C, G) - Math.max(A, E), Math.min(D, H) - Math.max(B, F));
        }
        //System.out.println("A: " + (C - A) * (D - B) + ", B: " + (G - E) * (H - F));
        //System.out.println("overlap-x: " + overlap.x + ", overlap-y: " + overlap.y + ", overlap-w: " + overlap.w + ", overlap-h: " + overlap.h);
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap.h * overlap.w;
    }
    private boolean check(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        //System.out.println("x1: " + x1 + ", y1: " + y1 + ", w1: " + w1 + ", h1: " + h1);
        //System.out.println("x2: " + x2 + ", y2: " + y2 + ", w2: " + w2 + ", h2: " + h2);
        return x1 <= x2 + w2 && x1 + w1 >= x2 && y1 <= y2 + h2 && y1 + h1 >= y2; 
    }
}
