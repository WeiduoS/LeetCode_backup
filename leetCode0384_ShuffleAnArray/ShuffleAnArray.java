package leetCode0384_ShuffleAnArray;

import java.util.Random;

public class ShuffleAnArray {
	int[] original;
    int[] arr;
    
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    public void Solution(int[] nums) {
        arr = nums;
        //original = Arrays.copyOf(arr, arr.length);
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    
    public int[] reset() {
        arr = original;
        //original = Arrays.copyOf(original, original.length);
        original = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    
    public int[] shuffle() {
        for(int i = 0; i < arr.length; i++) {
            swap(i, randRange(i, arr.length));
        }
        return arr;
    }
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}