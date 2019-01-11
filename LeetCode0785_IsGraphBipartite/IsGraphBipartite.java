package LeetCode0785_IsGraphBipartite;

public class IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0 && !valid(graph, colors, i, 1)) return false;
        }
        return true;
    }
    private boolean valid(int[][] graph, int[] colors, int pos, int color) {
        if(colors[pos] != 0) return colors[pos] == color;
        colors[pos] = color;
        for(int neigh : graph[pos]) {
            if(!valid(graph, colors, neigh, -1 * color)) return false;
        }
        return true;
    }
}
