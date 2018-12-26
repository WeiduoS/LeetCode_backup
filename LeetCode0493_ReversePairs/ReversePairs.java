package LeetCode0493_ReversePairs;

import java.util.Arrays;

public class ReversePairs {
	// Time Limit Exceeded
    /*
    class Node {
        Node left;
        Node right;
        int count;
        int val;
        Node(int val) {
            this.left = null;
            this.right = null;
            this.count = 1;
            this.val = val;
        }
    }
    
    private Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }else if(root.val == val) {
            root.count++;
        }else if(root.val > val) {
            root.left = insert(root.left, val);
        }else{
            root.count++;
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    private int search(Node root, long target) {
        if(root == null) {
            return 0;
        }else if(target == root.val) {
            return root.count;
        }else if(target < root.val) {
            return root.count + search(root.left, target);
        }else{
            return search(root.right, target);
        }
    }
    
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Node root = null;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += search(root, nums[i] * (long)2 + 1);
            root = insert(root, nums[i]);
        }
        return res;
    }*/
    /*
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0, n = nums.length;
        int[] v = Arrays.copyOf(nums, n);
        Arrays.sort(v);
        int[] BITree = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            //int half = nums[i] % 2 == 0 ? nums[i] > 0 ? nums[i] / 2 - 1 : nums[i] / 2 + 1 : nums[i] / 2;
            //res += getSum(BITree, index(v, half));
            int index = Arrays.binarySearch(v, (int)Math.ceil(nums[i] / 2.0));
            System.out.println("index: " + index + ", Math.ceil(nums[i] / 2.0)" + Math.ceil(nums[i] / 2.0));
            res += getSum(BITree, index > 0 ? index : -index - 1);
            //System.out.println("res: " + res + ", half: " + half + ", index: " + index(v, nums[i] / 2));
            update(BITree, index(v, nums[i]));
        }
        return res;
    }
    private int getSum(int[] BITree, int index) {
        index = index + 1;
        int sum = 0;
        while(index > 0) {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }
    private void update(int[] BITree, int index) {
        index = index + 1;
        while(index < BITree.length) {
            BITree[index]++;
            index += index & (-index);
        }
    }
    
    private int index(int[] v, int target) {
        int l = 0, r = v.length -1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(v[m] == target) {
                while(m + 1 < v.length - 1 && v[m] == v[m + 1]){
                    m++;
                }
                return m;
            }else if(v[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return r;
    }*/
    /*
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0, n = nums.length;
        int[] v = Arrays.copyOf(nums, n);
        Arrays.sort(v);
        int[] BITree = new int[n + 1];
        for(int num : nums){
            res += getSum(BITree, index(v, 2L * num + 1));
            update(BITree, index(v, num));
        }
        return res;
    }
    
    private int getSum(int[] BITree, int index) {
        index = index + 1;
        int sum = 0;
        while(index < BITree.length) {
            sum += BITree[index];
            index += index & (-index);
        }
        return sum;
    }
    
    private void update(int[] BITree, int index) {
        index = index + 1;
        while(index > 0) {
            BITree[index]++;
            index -= index & (-index);
        }
    }
    
    // find the leftmost target index
    // really important
    private int index(int[] v, long val) {
        int l = 0, r = v.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (v[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }*/
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int s, int e) {
        if(s >= e) return 0;
        int mid = s + (e - s) / 2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for(int i = s, j = mid + 1; i <= mid; i++) {
            while(j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        //Arrays.sort(nums, s, e + 1); 
        merge(nums, s, mid, e);
        return cnt; 
    }
    
    private void merge(int[] nums, int s, int m, int e) {
        int[] l = Arrays.copyOfRange(nums, s, m + 1);
        int[] r = Arrays.copyOfRange(nums, m + 1, e + 1);
        
        int i = 0, j = 0;
        for(int k = s; k <= e; k++) {
            if(i >= l.length) {
                nums[k] = r[j++];
                continue;
            }
            if(j >= r.length) {
                nums[k] = l[i++];
                continue;
            }
            if(l[i] <= r[j]) {
                nums[k] = l[i++];
            }else{
                nums[k] = r[j++];
            }
        }
    }
}
