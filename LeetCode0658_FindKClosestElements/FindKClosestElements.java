package LeetCode0658_FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	 // solution 1
    public List<Integer> findClosestElementsI(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        int index = binarySearch(arr, k, x);
        System.out.println(index);
        int leftSide = index;
        int rightSide = index;
        int count = k - 1;
        while(count > 0) {
            if(leftSide == 0) {
                rightSide++;
            }else if(rightSide == arr.length - 1) {
                leftSide--;
            }else{
                if(Math.abs(arr[leftSide - 1] - x) <= Math.abs(arr[rightSide + 1] - x)){
                    leftSide--;
                }else{
                    rightSide++;
                }
            }
            count--;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = leftSide; i <= rightSide; i++) {
                res.add(arr[i]);
        }
        return res;
    }
    private int binarySearch (int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while(l + 1 < r) {
            int m = l + (r - l) / 2;
            if(arr[m] == x) {
                r = m;
            }else if(arr[m] > x) {
                r = m;
            }else if(arr[m] < x) {
                l = m;
            }
        } 
        return arr[l] - x <= arr[r] - x ? l : r;
    }
    //solution 2
    public List<Integer> findClosestElementsII(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(arr[m] < x) {
                if(x - arr[m] > arr[m + k] - x) {
                    l = m + 1;
                }else{
                    r = m;
                }
            }else{
                r = m;
            }
        }
        int index = l;
        List<Integer> res = new ArrayList<>();
        for(int i = index; i < index + k; i++) {
                res.add(arr[i]);
        }
        return res;
        
    }	
}