package LeetCode0721_AccountsMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AccountsMerge {
	/*
    class UnionFindSet {
        int[] parents;
        UnionFindSet(int n) {
            parents = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        
        void union(int x, int y) {
            parents[find(y)] = find(x);
        }
        
        int find(int x) {
            if(parents[x] != x) parents[x] = find(parents[parents[x]]);
            return parents[x];
        }
        
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFindSet uf = new UnionFindSet(10001);
        Map<String, String> acc = new HashMap<>();
        Map<String, Integer> emails = new HashMap<>();
        int index = 0;
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                acc.put(account.get(i), name);
                if(!emails.containsKey(account.get(i))) {
                    emails.put(account.get(i), index++);
                }
                uf.union(emails.get(account.get(1)), emails.get(account.get(i)));
            }
        }
        
        Map<Integer, List<String>> res = new HashMap<>();
        for(String email : acc.keySet()) {
            int pos = uf.find(emails.get(email));
            res.computeIfAbsent(pos, x -> new ArrayList()).add(email);
        }
        
        for(List<String> addname : res.values()) {
            Collections.sort(addname);
            addname.add(0, acc.get(addname.get(0)));
        }
        return new ArrayList(res.values());
    }*/
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> acc = new HashMap<>();
        Map<String, Set<String>> adj = new HashMap<>();
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                adj.computeIfAbsent(email, x -> new HashSet<>()).add(account.get(1));
                adj.computeIfAbsent(account.get(1), x -> new HashSet<>()).add(email);
                acc.put(email, name);
            }
        }
        
        Set<String> set = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email : adj.keySet()) {
            if(set.contains(email)) continue;
            set.add(email);
            Stack<String> stack = new Stack<>();
            stack.push(email);
            List<String> component = new ArrayList<>();
            while(!stack.isEmpty()) {
                String temp = stack.pop();
                component.add(temp);
                for(String neig : adj.get(temp)) {
                    if(!set.contains(neig)) {
                        set.add(neig);
                        stack.push(neig);
                    }
                }
            }
            Collections.sort(component);
            component.add(0, acc.get(component.get(0)));
            res.add(component);
        }
        return res;
    }
}
