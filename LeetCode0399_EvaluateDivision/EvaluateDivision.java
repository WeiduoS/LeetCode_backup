package LeetCode0399_EvaluateDivision;

import java.util.HashMap;
import java.util.function.Function;

public class EvaluateDivision {
	// solution 1: Graph + DFS
    /*
    Map<String, HashMap<String, Double>> adj;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        adj = new HashMap<>();
        
        for(int i = 0; i < equations.length; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            double val = values[i];
            // adj.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
            if(adj.containsKey(x)) {
                adj.get(x).put(y, val);
            }else{
                adj.put(x, new HashMap<String, Double>());
                adj.get(x).put(y, val);
            }
            
            if(adj.containsKey(y)) {
                adj.get(y).put(x, 1.0 / val);
            }else{
                adj.put(y, new HashMap<String, Double>());
                adj.get(y).put(x, 1.0 / val);
            }
        }
        
        double[] ans = new double[queries.length];
        for(int i = 0; i < ans.length; i++) {
            String x = queries[i][0];
            String y = queries[i][1];
            if(!adj.containsKey(x) || !adj.containsKey(y)) ans[i] = -1.0;
            else ans[i] = dfs(x, y, new HashSet<String>());
        }
        return ans;
    }
    
    private double dfs(String x, String y, Set<String> set) {
        if(x.equals(y)) return 1.0;
        set.add(x);
        if(!adj.containsKey(x)) return -1.0;
        for(String neighbor : adj.get(x).keySet()) {
            if(set.contains(neighbor)) continue;
            double d = dfs(neighbor, y, set);
            if(d > 0) return d * adj.get(x).get(neighbor);
        }
        return -1.0;
    }*/
    // solution 2: Union Find Set
    /*
    class Node {
        String parent;
        double ratio;
        Node(String parent, double ratio) {
            this.parent = parent;
            this.ratio = ratio;
        }
    }
    
    class UnionFindSet {
        Map<String, Node> parents = new HashMap<>();
        // parents["A"] = {"B", 2.0} -> A = 2.0 * B
        // parents["B"] = {"C", 3.0} -> B = 3.0 * C
        public Node find(String s) {
            if(!parents.containsKey(s)) return null;
            Node n = parents.get(s);
            if(!n.parent.equals(s)) {
                Node p = find(n.parent);
                n.parent = p.parent;
                n.ratio *= p.ratio;
            }
            return n;
        }
        
        void union(String s, String p, double ratio) {
            boolean hasS = parents.containsKey(s);
            boolean hasP = parents.containsKey(p);
            
            if(!hasS && !hasP) {
                parents.put(s, new Node(p, ratio));
                parents.put(p, new Node(p, 1.0));
            } else if(!hasP) {
                parents.put(p, new Node(s, 1.0 / ratio));
            } else if(!hasS) {
                parents.put(s, new Node(p, ratio));
            }else{
                Node rS = find(s);
                Node rP = find(p);
                rS.parent = rP.parent;
                rS.ratio = ratio / rS.ratio * rP.ratio;
            }
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        UnionFindSet u = new UnionFindSet();
        for(int i = 0; i < equations.length; i++) {
            u.union(equations[i][0], equations[i][1], values[i]);
        }
        double[] ans = new double[queries.length];
        for(int i = 0; i < ans.length; i++) {
            Node rx = u.find(queries[i][0]);
            Node ry = u.find(queries[i][1]);
            if (rx == null || ry == null || !rx.parent.equals(ry.parent))
                ans[i] = -1.0;        
            else
                ans[i] = rx.ratio / ry.ratio;
        }
        return ans;
    }*/
    // https://leetcode.com/problems/evaluate-division/discuss/88207/java-solution-using-FloydWarshall-algorithm
    // solution 3: Floyd Warshall Algorithm
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        Function<String, HashMap<String, Double>> function = s -> new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            graph.computeIfAbsent(equations[i][0], function).put(equations[i][0], 1.0);
            graph.computeIfAbsent(equations[i][1], function).put(equations[i][1], 1.0);
            graph.get(equations[i][0]).put(equations[i][1], values[i]);
            graph.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        for(String mid : graph.keySet()) {
            for(String src : graph.get(mid).keySet()) {
                for(String dst : graph.get(mid).keySet()) {
                    double val = graph.get(src).get(mid) * graph.get(mid).get(dst);
                    graph.get(src).put(dst, val);
                }
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (!graph.containsKey(queries[i][0])) {
                result[i] = -1;
            } else {
                result[i] = graph.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
            }
        }
        return result;
    }
    
}
